package de.telran;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class ParametrizedTest {

    static TrackingService service = new TrackingService();
    int input;
    int expected;

    public ParametrizedTest(int input, int expected){
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {5, 5}, {5, 10}, {-12, 0}, {50, 50}, {1, 51}
        });

        }

     @Test
     public void testAddCalories() throws MaxNumberExceededException {
        if(input>=0) service.addCalories(input);
        else service.removeCalories(-input);

        assertEquals(expected, service.getTotal());
     }

     @Test(timeout = 200)
    public void BadTest() throws MaxNumberExceededException {

         for (int i = 0; i < 10000000; i++)
             service.addCalories(10);
         ;
     }

}
