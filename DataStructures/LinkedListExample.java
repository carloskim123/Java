package DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {

        LinkedList<String> namesLinkedList = new LinkedList<>();
        namesLinkedList.add("Carlos");
        namesLinkedList.add("John");
        namesLinkedList.add("KK");
        namesLinkedList.add("Carl");
        System.out.println(namesLinkedList.get(2));

        namesLinkedList.add(1, "Jerry");
        System.out.println(namesLinkedList);

        String[] names = new String[4];

        ArrayList<String> namesArrayList = new ArrayList<>();
        namesLinkedList.add("Carlos");
        namesLinkedList.add("John");
        namesLinkedList.add("KK");
        namesLinkedList.add("Carl");
    }

}
