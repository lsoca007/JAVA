package com.company;

public class Main {

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList();

        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(7);
        myLinkedList.prepend(1);
        myLinkedList.deleteWithValue(4);



        System.out.println(myLinkedList.toString());

        
    }
}
