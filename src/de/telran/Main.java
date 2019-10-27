package de.telran;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String [] a = new String [] {"aa", "bb", "cc", "dd"};
        String [] b = new String [] {"cc", "dd","aa", "bb" };
        String [] c = new String [] {"dd", "ee", "ff"};
        String [] d = new String [] {"dd", "ff", "ee"};

        System.out.println(determineCyclic(a,b));
        System.out.println(determineCyclic(c,d));

       String[] names = new String [] {"Ivan", "Maria","Stephan","John","Amalia"};
       //  List<String> newNames = namesExcludingLength(names, 4);
        System.out.println(namesExcludingLength(names, 4));

        int[] first = new int[]{1,2,3,4};
        int[] second = new int[]{3,2,3,7};
        System.out.println(compare(first,second));
    }

    public static List<String> namesExcludingLength(String[] names, int length) {

        List<String> newNames = new ArrayList<String>();

        for(String name : names){
            if (name.length() != length){
                newNames.add(name);
            }
        }
        return newNames;
    }

    public static List<String> compare (int[] first, int[] second) {
        int length = first.length;
        List<String> array = new ArrayList<String>();

        for(int i =0; i < length; i++){
            if(first[i] == second[i]){
                array.add("YES");
            }else{
                array.add("NO");
            }
        }


        return array;
    }

    public static boolean determineCyclic  (String [] a, String [] b){

        if(a.length != b.length){
            return false;
        }

        int index = -1;
            // check array a
        for(int i = 0; i < a.length; i++){
            String el = a[i];
            int foundIndex = -1;
            //check array b;
            for(int j = 0; j < b.length; j ++){
                if (b[j] == el) {
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

}