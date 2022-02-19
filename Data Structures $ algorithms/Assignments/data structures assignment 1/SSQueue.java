package com.company;

/*
 * File: SSQueue.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

/**
 * SSQueue class creates a queue using two stacks
 */
public class SSQueue {
    private Stack stackNew;
    private Stack stackOld;

    /**
     * Constructor. Creates a new queue using two stacks
     */
    public SSQueue() {
        this.stackNew = new Stack();
        this.stackOld = new Stack();
    }

    /**
     * Add data to the queue
     * @param data
     */
    public void enqueue(Object data)
    {
        stackNew.push(data);
    }

    /**
     * Return the last element of the queue
     * @return peek
     */
    public Object peek()
    {
        // Move element from stack1 to stack2
        shiftStacks();

        // move elements back
        return stackOld.peek();
    }

    /**
     * Remove the first element added
     * to the list
     * @return first element
     */
    public Object dequeue()
    {
        shiftStacks();
        return stackOld.pop();
    }

    /**
     * Push all elements from one stack to another
     * for reversing the order
     */
    private void shiftStacks()
    {
        if (stackOld.isEmpty())
        {
            while (!stackNew.isEmpty())
            {
                stackOld.push(stackNew.pop());
            }
        }
    }

    /**
     * Print the final stack with all the elements
     * @return
     */
    @Override
    public String toString()
    {
        if (!stackNew.isEmpty())
        {
            return stackNew.toString();
        }
        else {
            return stackOld.toString();
        }
    }
}
