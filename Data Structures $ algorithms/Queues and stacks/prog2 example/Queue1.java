package com.company;//  File:  Queue1.java		(Dedicated to John DeLancey)

//  A generic Queue class with linked implementation.
//  Warning: throws NullPointerException if an attempt is made to serve an
//           empty queue

/**
 * A class that implements a generic queue
 */
public class Queue1<E> 
{
    // instance vars
    private Node front;		// pointer to front of queue
    private Node rear;		// pointer to rear of queue

    /**
     * Creates an empty queue.
     */
    public Queue1() 
    {
        front = rear = null ;
    }

    /**
     * Is the queue empty?
     * @return true if the queue is empty, false if nonempty
     */
    public boolean isEmpty() 
    {
        return front == null ;	
    }

    /**
     * Append an object to the end of the queue.
     * @param x the object to be appended
     */
    public void append(E x) 
    {
        Node temp = new Node(x);
        if (isEmpty()) // if queue is empty...
        {
            front = rear = temp;	// ...x becomes only object in queue
        } 
        else // if queue nonempty...
        {
            rear.next = temp;		// ...append object to end of queue
            rear = rear.next;		// ...and update rear pointer
        }
    }

    /**
     * Remove the object at the front of the queue and return it
     * @return the object at the front of the queue
     *
     * Precondition:  the queue is NOT empty
     **/
    public E serve() 
    {
        E saved = front.info;		// save object at the front of queue
        front = front.next;		// delete it from queue
        return saved;			// return it
    }

    public String toString() {
        if (isEmpty()) {
            return "queue is currently empty!";
        }
        String out = "";
        Node temp = front;
        while (temp != null) {
            out = out + temp.info + "  ";
            temp = temp.next;
        }
        return out;
    }
    
    class Node 		
    {
       // instance vars
       private E info;        // an object of the "type variable" class
       private Node next;     // pointer to next nodein the queue

       // Create a Node object 
       Node(E x)	      // constructor takes one param of class E
       {
          info = x ;          // set info portion to parameter passed
          next = null ;	
       }
    } // end of Node class definition
} // end of Queue2 class definition