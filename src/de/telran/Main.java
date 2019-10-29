package de.telran;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //7
        List <Integer> removeList = new ArrayList <> (Arrays.asList(1,2,3,4));
        System.out.println(removeMore(removeList, 2));

        //6
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        System.out.println(mergeList(listOne,listTwo));

        //5
        List <Integer> reverseTest = new ArrayList <> (Arrays.asList(1,2,3,4,5));
        System.out.println(reverse(reverseTest));

        //4
        ArrayList<String> a = new ArrayList<>(Arrays.asList ("aa", "bb", "cc", "dd"));
        ArrayList<String> b = new ArrayList<>(Arrays.asList ("cc", "dd","aa", "bb" ));
        ArrayList<String> c = new ArrayList<>(Arrays.asList ("dd", "ee", "ff"));
        ArrayList<String> d = new ArrayList<>(Arrays.asList ("dd", "ff", "ee"));

        System.out.println(determineCyclic(a,b));
        System.out.println(determineCyclic(c,d));

        //3
        ArrayList<String> names = new ArrayList<>(Arrays.asList ("Ivan", "Maria","Stephan","John","Amalia"));
        System.out.println(namesExcludingLength(names, 4));

        //2
        List <Integer> first = new ArrayList <> (Arrays.asList(1,2,3,4));
        List <Integer> second = new ArrayList <> (Arrays.asList(3,2,3,7));
        System.out.println(compare(first,second));
    }

    public static List<String> namesExcludingLength(List<String> names, int length) {

        List<String> newNames = new ArrayList<String>();

        for(String name : names){
            if (name.length() != length){
                newNames.add(name);
            }
        }
        return newNames;
    }

    public static List<String> compare (List <Integer> first, List <Integer> second) {
        int length = first.size();
        List<String> array = new ArrayList<String>();

        for(int i =0; i < length; i++){
            if(first.get(i) == second.get(i)){
                array.add("YES");
            }else{
                array.add("NO");
            }
        }
        return array;
    }

    public static boolean determineCyclic (List<String> a, List<String> b){

        if(a.size() != b.size()){
            return false;
        }

        int index = -1;
            // check array a
        for(int i = 0; i < a.size(); i++){
            String el = a.get(i);
            int foundIndex = -1;
            //check array b;
            for(int j = 0; j < b.size(); j ++){
                if (b.get(j) == el) {
                    foundIndex = j;
                }
            }
            //element not found in b array
            if(foundIndex < 0) {
                return false;
            }

            if ((index < 0) || (index == foundIndex - 1) || (foundIndex == 0)) {
                index = foundIndex;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static List <Integer> reverse (List <Integer> list){

        List<Integer> array = new ArrayList<>(list.size());

        for(int i = list.size() - 1; i >= 0; i-- ) {
            array.add(list.get(i));
        }

        return array;
    }

    public static List <String> mergeList (List<String> listOne, List<String> listTwo){

        List<String> merged = new ArrayList<>();

        merged.addAll(listOne);
        merged.addAll(listTwo);

        return merged;

    }

    public static List <Integer> removeMore (List <Integer> newList, int element){

        List<Integer> newArray = new ArrayList<>(newList.size());

        for(int i = 0; i < newList.size(); i++){
            if(newList.get(i) > element){
                newList.remove(i);
            }else{
                newArray.add(i);
            }

        }

        return newArray;
    }

}