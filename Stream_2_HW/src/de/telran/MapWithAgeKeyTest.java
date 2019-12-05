package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static de.telran.Main.MapWithAgeKeys;

public class MapWithAgeKeyTest {

    Person Ivan = new Person ("Ivan", 30);
    Person Anna = new Person ("Anna", 25);
    Person Maria = new Person ("Maria", 57);
    Person Igor = new Person ("Igor", 34);

    List<Person> persons = Arrays.asList(Ivan, Anna, Maria, Igor);

    @Test

    public void mapWithAgeKeyTest(){
        Map<Integer, List<Person>> expected = new HashMap<>();
        expected.put(30, Arrays.asList(Ivan));
        expected.put(25, Arrays.asList(Anna));
        expected.put(57, Arrays.asList(Maria));
        expected.put(34, Arrays.asList(Igor));

        Map<Integer, List<Person>> actual = MapWithAgeKeys(persons);
        Assert.assertEquals( expected, actual);
    }

    @Test
    public void mapWithAgeKeyTestFail(){
        Map<Integer, List<Person>> expected = new HashMap<>();
        expected.put(30, Arrays.asList(Anna));
        expected.put(25, Arrays.asList(Ivan));
        expected.put(57, Arrays.asList(Maria));
        expected.put(34, Arrays.asList(Igor));

        Map<Integer, List<Person>> actual = MapWithAgeKeys(persons);
        Assert.assertEquals( expected, actual);
    }

}

