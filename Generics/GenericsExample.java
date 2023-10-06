package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample <T extends Animal> {
    public static void main(String[] args) {

        List<Integer> intList  = new ArrayList<>();
        intList.add(4);
        printList(intList);
    }

    public static void printList(List<?> myList) {
        System.out.println(myList);
    }
}
