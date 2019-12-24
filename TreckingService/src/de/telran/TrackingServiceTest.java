package de.telran;


import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TrackingServiceTest {

    private static TrackingService service;
    @Rule
    public TestName testName = new TestName();


    @BeforeClass
    public static void before(){
        System.out.println("BeforeClass");
        service = new TrackingService();
    }

    @After
    public  void after(){
        System.out.println("Current test is " + testName.getMethodName());
    }

    @Test
    @Category(PositiveTestCategory.class)
    public void addCalories() throws MaxNumberExceededException {
        TrackingService service = new TrackingService();

        service.addCalories(300);

        assertEquals("Alarm!", 300, service.getTotal());
        assertTrue(300 == service.getTotal());

        assertEquals(1, service.getHistory().size());

    }

    @Test
    @Category(PositiveTestCategory.class)
    public void removeCalories(){
        TrackingService service = new TrackingService();

        service.removeCalories(200);

        assertEquals("Alarm!", 0, service.getTotal());
        assertTrue(0 == service.getTotal());

        assertEquals(1, service.getHistory().size());

    }

    @Test(expected = MaxNumberExceededException.class)

    public void exceptionTest() throws MaxNumberExceededException {
        TrackingService service = new TrackingService();

        service.addCalories(200);
    }

}
