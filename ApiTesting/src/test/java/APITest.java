package test.java;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;

public class APITest {
     String baseURL = "https://api.github.com/";
     String userValid = "lesyaAn";
     String userNotValid = "lesyaann";
     CloseableHttpClient client;
     HttpGet request;
     HttpPost postRequest;
     HttpResponse response;
     HttpDelete deleteRequest;
     String email = "lisaalisa92@bk.ru";
     String user = "lesyaAn";
     String auth;
     String pass = "lesyashaV282726";
     String repoName = "TelranRepo";
     static String token = "5ac3ac5b21d1743b390a18a5b2ee60c4a79962d2";
    String authHeader = makeHeader();

    @Test
    public void ExistenUser200() throws IOException {
        client = HttpClientBuilder.create().build();

        //Given
        request = new HttpGet(baseURL + "users/" + userValid);

        //When
        response = client.execute(request);

        //Then
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    public void ExistenUser404() throws IOException {

        client = HttpClientBuilder.create().build();

        //Given
        request = new HttpGet(baseURL +"users/" + userNotValid);

        //When
        response = client.execute(request);

        //Then
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);

    }

    @Test
    public void CreateRepoGitHub() throws IOException {

        //Given

        client = HttpClientBuilder.create().build();

        String name = String.valueOf(new Random().nextInt(10000));
        System.out.println("Generated number: " + name);

        postRequest = new HttpPost(baseURL + "user/repos");
        postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

        String json = "{\"name\":\""+ repoName + "\"}";
        postRequest.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        //when
        response = client.execute(postRequest);

        //Then
        assertEquals(response.getStatusLine().getStatusCode(), 201);



    }

    @Test
    public void InitRepoName() throws IOException {

        //Given
        CloseableHttpClient client2 = HttpClientBuilder.create().build();
        request = new HttpGet(baseURL + "repos/lesyaAn/" + repoName);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

        //When
        response = client2.execute(request);

        //Then
        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        client2.close();

    }

   @Test
    public void testDelete() throws IOException {

        CloseableHttpClient client3 = HttpClientBuilder.create().build();

        //Given
        deleteRequest = new HttpDelete(baseURL + "repos/" + user + "/" + repoName);

        deleteRequest.setHeader(HttpHeaders.AUTHORIZATION, "token " + token);
        //When
        HttpResponse response2 = client3.execute(deleteRequest);
        assertEquals(response2.getStatusLine().getStatusCode(), 204);

        client3.close();
    }

    private String makeHeader(){

        auth = email + ":" + pass;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);
        System.out.println(authHeader);
        return authHeader;

    }
}
