package de.telran;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.telran.Main.removeDuplicatesNames;

    public class RemoveDuplicatesTest {
        List<String> names = new ArrayList<>();

        @Before
        public void init() {
            names.add("Ivan");
            names.add("Maria");
            names.add("Anna");
            names.add("Ivan");

        }

        @Test
        public void listWithoutDuplicatesTest(){
            List<String> expected = Arrays.asList("Ivan", "Maria", "Anna");
            List<String> actual = removeDuplicatesNames(names);

            Assert.assertEquals("List is correct", expected, actual);

        }

        @Test
        public void listWithDuplicatesTest(){
            List<String> expected = Arrays.asList("Ivan", "Maria", "Anna", "Ivan");
            List<String> actual = removeDuplicatesNames(names);

            Assert.assertEquals("List is not correct", expected, actual);

        }

    }


