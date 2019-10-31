package de.telran;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestCollection {

    @Test

    public void removeTest(){

        ArrayList<String> input = new ArrayList<>(Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan"));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Ivan", "Maria", "Piotr", "Anna"));

        ArrayList<String> actual = (ArrayList<String>) collectionP2.removeDuplicates(input);

        TestCase.assertEquals("wrong result sentence", expected, actual);

    }

    @Test

    public void duplicateTest(){
        ArrayList<String> input = new ArrayList<>(Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan"));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Maria", "Ivan"));

        ArrayList<String> actual = (ArrayList<String>) collectionP2.getDuplicates(input);

        TestCase.assertEquals("wrong result sentence", expected, actual);


    }


}
