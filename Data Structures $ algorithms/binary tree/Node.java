package com.company;

public class Node {
    Node left;
    Node right;
    int data;

    public Node (int data) {

        this.data = data;
    }

    public void insert ( int value) {

        if (value <= data) {
            if (left == null) { // if left side is null, insert there
                left = new Node (value);
            } else { // if not, call this method again for the left side
                left.insert(value);
            }
        } else { // if value >= data
            if (right == null) { // if right is empty
                right = new Node(value); // insert value at right side

            } else { // if not, call this method again for the right side
                right.insert(value);
            }
        }


    }

    public boolean contains (int value) {

        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public void printInOrder() {

        if (left !=null) {
            left.printInOrder();
        }
        System.out.println(data);

        if (right != null) {
            right.printInOrder();
        }
    }

}
