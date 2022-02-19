package com.company;

public class Stack {

    private static class Node {

        private int data;
        private Node next;

        //constructor
        private Node (int data) {
            this.data = data;
        }
    }

    private Node top;

    public boolean isEmpty () {
        return top == null;
    }
    public int peek () {
        return top.data;

    }
    public void push (int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;

    }
    public int pop () {
        int data = top.data;
        top = top.next;
        return data;

    }

    @Override
    public String toString()
    {
        String str = " ";
        Node temp = top;

        while (temp != null)
        {
            str += temp.data + " ";
            temp = temp.next;
        }
        return '[' + str + ']' + "\n";
    }
}
