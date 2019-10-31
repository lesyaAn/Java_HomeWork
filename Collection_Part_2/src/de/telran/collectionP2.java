package de.telran;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class collectionP2 {

    public static List<String> removeDuplicates(List<String> input){

        HashSet<String> hs = new HashSet<>();

        hs.addAll(input);
        input.clear();
        input.addAll(hs);

        return input;
    }

    public static List<String> getDuplicates(List<String> input){

        HashSet<String> hs = new HashSet<>();
        List duplicatesName = new ArrayList();

        for (String s : input) {
            if (!hs.add(s)) duplicatesName.add(s);
        }
        return duplicatesName;

    }
}
