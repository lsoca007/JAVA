package com.company;

public class LinkedList {
    Node head;

    public void append (int data) {

        if ( head == null) {

            head = new Node(data);
            return;
        }

        Node current = head; // iterator

        while (current.next != null) { // go through the nodes until finds the last node
            current = current.next;
        }
        // after finding the last node
        current.next = new Node(data); // creates a new node whit the data


    }

    public void prepend (int data) {
        Node newHead = new Node(data); // creates a new node with the data
        newHead.next = head; // makes this node to point to the head
        head = newHead; // makes this the head

    }

    public void deleteWithValue (int data) {

        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next !=null) {

            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public String toString()
    {
        String str = " ";
        Node temp = head;

        while (temp != null)
        {
            str += temp.data + " ";
            temp = temp.next;
        }
        return '[' + str + ']' + "\n";
    }
}
