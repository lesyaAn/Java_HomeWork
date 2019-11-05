package de.telran;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.telran.Main.listWithIBANsWithStars;
import static de.telran.Main.mapWithPersonsBankAccount;

public class MapWithPersonsBATest {

    Person Ivan = new Person ("Ivan", 30);
    Person Anna = new Person ("Anna", 25);
    Person Maria = new Person ("Maria", 57);
    Person Igor = new Person ("Igor", 34);

    List<Person> persons = Arrays.asList(Ivan, Anna, Maria, Igor);

    BankAccount BA1 = new BankAccount( "DE2323", Ivan);
    BankAccount BA2 = new BankAccount( "DE1424", Anna);
    BankAccount BA3 = new BankAccount( "DE3525", Maria);
    BankAccount BA4 = new BankAccount( "DE4626", Igor);

    List<BankAccount> listWithBA = Arrays.asList(BA1, BA2, BA3, BA4);


    @Test
    public void mapWithPersonsBA(){

        Map<Person, List<String>> expected = new HashMap<>();
        expected.put(Ivan, Arrays.asList("DE2323"));
        expected.put(Anna, Arrays.asList("DE1424"));
        expected.put(Maria, Arrays.asList("DE3525"));
        expected.put(Igor, Arrays.asList("DE4626"));

        Map<Person, List<String>> actual = mapWithPersonsBankAccount(listWithBA);

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void mapWithPersonsBAFail(){

        Map<Person, List<String>> expected = new HashMap<>();
        expected.put(Anna, Arrays.asList("DE2323"));
        expected.put(Ivan, Arrays.asList("DE1424"));
        expected.put(Maria, Arrays.asList("DE3525"));
        expected.put(Igor, Arrays.asList("DE4626"));

        Map<Person, List<String>> actual = mapWithPersonsBankAccount(listWithBA);

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void listWithIBANsStarsTest(){
        List<String> expected = Arrays.asList("DE2***", "DE1***","DE3***","DE4***");
        List<String> actual = listWithIBANsWithStars(listWithBA);

        Assert.assertEquals(expected, actual);

    }
}
