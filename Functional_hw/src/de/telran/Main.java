package de.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String [] args){

        Address address1 = new Address("Berliner Str.", 29);
        Address address2 = new Address("Akazien Str.", 22);

        Person ivan = new Person("Ivan", 35, address1);
        Person alex = new Person("Alex", 16, address2);

        ArrayList<Person> persons = new ArrayList<>(Arrays.asList (ivan, alex));
        getAddressFromPersonMore17(persons);



    }

    public static List<Address> getAddressFromPersonMore17(List <Person> persons) {

        return (List<Address>) persons.stream()
                .filter(p -> p.getAge() > 17)
                .map(Person::getAddress);

    }
}
