package com.company;

/*
 * File: Stack.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

/**
 * Stack class represent a linear list
 * using arrays
 */
public class Stack {

    private final static int ARRAY_SIZE = 1000; // array initial size
    private int top; // keeps track of the last element
    private Object[] stackElements;

    /**
     * Constructor. Creates a new stack
     */
    public Stack()
    {
        this.top = 0;
        this.stackElements = new Object[ARRAY_SIZE];
    }

    /**
     * Check if the stack is empty
     *
     * @return true if the stack is empty or
     * false if it is not.
     */
    public boolean isEmpty()
    {
        return top == 0;
    }

    /**
     * Return the last element of the stack
     * @return peek of the stack
     */
    public Object peek()
    {
        return stackElements[top - 1];
    }

    /**
     * Add element to the stack
     * @param data
     */
    public void push(Object data)
    {
        // if the stack is full
        if (top == stackElements.length)
        {
            resizeArray();
        }
        stackElements[top] = data; // add data
        top++;
    }

    /**
     * Remove the last element from the stack
     * @return element removed
     */
    public Object pop()
    {
        Object data = stackElements[top - 1]; // hold the last element
        stackElements[top - 1] = null;
        top--; // decrease counter
        return data; // return last element
    }

    /**
     * This method increases the array's size in case it is needed.
     */
    private void resizeArray()
    {
        Object[] newArray = new Object[2 * stackElements.length];
        for (int i = 0; i < stackElements.length; i++)
        {
            newArray[i] = stackElements[i];
        }
        stackElements = newArray;
    }

    /**
     * toString method print the objects in the stack
     * @return all element as a list
     */
    @Override
    public String toString()
    {
        String str = " ";

        for (int i = top - 1; i >= 0; i--)
        {
            str += stackElements[i] + " ";
        }
        return '[' + str + ']' + "\n";
    }
}