package up42;

import com.jayway.restassured.internal.path.json.JSONAssertion;
import com.jayway.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import up42.utils.Requests;
import up42.utils.Utils;


import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

import static junit.framework.TestCase.fail;
import static org.awaitility.Awaitility.with;
//import static up42.Constans.API_KEY;
//import static up42.Constans.PROJECT_ID;

@Slf4j
public class RunJobTest {

    private static String token;
    private static String projectId;
    private final String name = "TestWorkFlow";
    private final String block1 = "sobloo-s2-l1c-aoiclipped";
    private final String block2 = "sharpening";
    private static String apiKey;



        @BeforeClass
        public  static  void init(){
           // token = Requests.retrieveToken(API_KEY,PROJECT_ID);
            apiKey = System.getenv("apiKey");
            projectId = System.getenv("projectId");

        }

        @Test
        public  void runJobBasicFlow() throws JSONException {
//
//          Response createResponse = Requests.createWorkflow(token, projectId, "{\"name\":\"" + name + "\"}");
            Response createResponse = Requests.createWorkflow(token,projectId,
                  "{\"name\": \"QA coding challenge workflow\", \"description\": \"Workflow description\"  }");

            try {
                JSONAssert.assertEquals("Create Workflow response is invalid",
                        Utils.resourceAsString("expected/createWF.json"), createResponse.asString(),
                        new CustomComparator(JSONCompareMode.STRICT,
                                new Customization("data.createdAt", (o1, o2) -> true),
                                new Customization("data.id", (o1, o2) -> true),
                                new Customization("data.updatedAt", (o1, o2) -> true)
                        ));
            }
            catch (AssertionError e){
                log.error("Assertion error{}", createResponse.asString());
                fail();
            }

            String workFlowId = createResponse.jsonPath().getString("data.id");
            Response getWorkflow =  Requests.getWorkflowInfo(token, projectId, workFlowId);
            assertTrue(getWorkflow.jsonPath().getString("data.id").equals(workFlowId));

            Response configResponse =  Requests.configWorkflow(token, projectId, workFlowId,
                    Utils.resourceAsString("workflowConfig.json"));

            //assertTrue(configResponse.jsonPath().getString("data[0].name").equals("sobloo-s2-l1c-aoiclipped")
           // && configResponse.jsonPath().getString("data[1].name").equals("sharpening"));

            Response jobId = Requests.createRunJob(token, projectId, workFlowId, Utils.resourceAsString("job.json"));

            with().pollInterval(500, TimeUnit.MILLISECONDS).await().atMost(120, TimeUnit.SECONDS)
                    .until(() -> Requests.getJobStatus(token, projectId, jobId).equals("SUCCEEDED"));

            Requests.deleteWorkflow(token, projectId, workFlowId);
            assertTrue(Requests.getWorkflowInfo(token, projectId, workFlowId).getStatusCode() == 404);


        }


}
