package com.company;

/*
 * File: CAQueue.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

/**
 * This class construct a queue using a circular array
 */
public class CAQueue {

    private Object[] elements;
    private int currentSize; // counter for the actual size of the array
    private int front; // store index of front
    private int back; // store index of back
    private final static int ARRAY_SIZE = 1000; // initial size

    /**
     * Creates a new queue using circular array
     */
    public CAQueue() // constructor
    {
        this.elements = new Object[ARRAY_SIZE];
        this.currentSize = 0;
        this.front = 0;
        this.back = 0;
    }

    /**
     * Enqueue method add a give element
     * to the circular array
     *
     * @param ob given element
     */
    public void enqueue(Object ob)
    {
        //check if the array is full
        if (currentSize == elements.length)
        {
            resizeArray(); // double its size
        }
        else {
            elements[back] = ob; // enqueue element at last index
            back = (back + 1) % elements.length; // update the back index
            currentSize++;
        }
    }

    /**
     * Dequeue method removes the first element
     * inserted in the array
     *
     * @return
     */
    public Object dequeue()
    {
        Object removeElement = elements[front]; // hold the front element
        front = (front + 1) % elements.length; // update the front index
        currentSize--;

        return removeElement;
    }

    /**
     * This method increases the array's size.
     */
    private void resizeArray()
    {
        Object[] newArray = new Object[2 * elements.length];

        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[(front + i) % elements.length];
        }

        elements = newArray;
        front = 0;
        back = currentSize;
    }

    /**
     * Print all the elements
     * in the circular array
     * @return
     */
    @Override
    public String toString()
    {
        String str = " ";

        for (int i = 0; i < currentSize; i++) {
            str += elements[(front + i) % elements.length] + " ";
        }

        return '[' + str + ']' + "\n";
    }
}
