package de.telran;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
//2
    public static List<String> removeDuplicatesNames(List<String> names){

        List<String> newListWithoutDuplicates = names.stream()
                .distinct()
                .collect(Collectors.toList());
        return newListWithoutDuplicates;
    }
//3
    public static Map<Integer, List<Person>> MapWithAgeKeys (List<Person> persons) {

        return persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));
    }
//4
    public static Map<Person, List<String>> mapWithPersonsBankAccount(List<BankAccount> listWithBA){
        return listWithBA.stream()
                .collect(Collectors.groupingBy
                        (BankAccount::getOwner,
                                Collectors.mapping(BankAccount::getIBAN,
                                        Collectors.toList())));
    }
//5
    public static List<String> listWithIBANsWithStars(List<BankAccount> listWitBA){
        return listWitBA.stream().map(BankAccount::getIBAN)
                .map(s -> s.substring(0, 3) + s.substring(3).replaceAll("\\d", "*"))
                .collect(Collectors.toList());
    }




}
