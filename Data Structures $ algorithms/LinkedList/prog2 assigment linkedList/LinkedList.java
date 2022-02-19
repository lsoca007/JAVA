package assignment6;

/*
 * File: LinkedList.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

/**
 * LinkedList class implements a simple generic list
 * @param <E> object
 */
public class LinkedList<E> 
{
    private Node head = null; // head

    /**
     * Inner class Node creates a node with its next reference
     */
    class Node 
    {
        private E info; //object of the “type variable” class
        private Node next;   // pointer to the next node on the list.

        /**
         * Creates a new node
         *
         * @param x object data type
         */
        public Node(E x) // Constructor
        {
            this.info = x;
            next = null; // next pointer
        }
    }

    /**
     * Method that returns a pointer to the last node on the list
     *
     * @return last node
     */
    private Node lastNode()
    {
        if (head == null) // if list is empty
        {
            return null; // return null
        }
        else {

            Node temp = head; // temporal node start at the head

            while (temp.next != null) // while not at the last node
            {
                temp = temp.next;  // move to the next node
            }
            return temp; // return the pointer to last node
        }
    }

    /**
     * Append an object to the end of the list
     *
     * @param x the object to be appended
     */
    public void append(E x) {

        // create a new node with the given element
        Node newNode = new Node(x); // create new node pointing to x

        if (head == null)  // if list is empty
        {
            head = newNode;  // new node is the head of list
        }
        else {
            lastNode().next = newNode; // add element to the last position
        }
    }

    /**
     * Insert object X as the new Nth element in the list,
     * increasing the size of the list by 1
     *
     * @param index position for the object
     * @param x     the object to be added
     */
    public void addAt(int index, E x) {

        Node newNode = new Node(x); // new node with the data

        if (index == 1)
        {
            newNode.next = head; // link the two nodes
            head = newNode;  // set the head to reference the new node
        }
        else {
            Node previousNode = findPrevious(index);

            Node currentNode = previousNode.next; // position  at index
            newNode.next = currentNode;
            previousNode.next = newNode;
        }
    }

    /**
     * Remove the Nth object from the list
     * @param index position of the object to be removed
     */
    public void delete(int index)
    {
        if (head == null) // if list is empty, return null
        {
            return;
        }
        if (index == 1)  // delete first element in the list
        {
            head = head.next;   
        } 
        else {  // delete any other element

            Node previous = findPrevious(index); // find the previous
            Node current = previous.next; // find the current node
            // delete the node
            previous.next = current.next; 
            current.next = null;
        }
    }

    /**
     * Method used to find the previous of an object at the given index.
     * @param index for the current object
     * @return pointer of previous node
     */
    private Node findPrevious(int index)
    {
        int count = 1;
        Node previous = head;

        while (count < index - 1) // count how many element in the list
        {
            previous = previous.next;
            count++;
        }

        return previous;
    }

    /**
     * Interchange the positions of the Mth and Nth
     * objects on the list
     * @param indexM index of the first object
     * @param indexN index of the second object
     */
    public void swap(int indexM, int indexN)
    {
        // find the objects at the given index
        Node currentM = findPrevious(indexM).next;
        Node currentN = findPrevious(indexN).next;

        // if there is no previous, current is = head
        if (indexM == 1) 
        {
            currentM = head;
        }
        if (indexN == 1)
        {
            currentN = head;
        }

        addAt(indexM, currentN.info); // add a new node at the given index
        delete(indexM + 1);  // delete the repeated node at the next index
        addAt(indexN, currentM.info); // do the same for N
        delete(indexN + 1);
    }

    /**
     * Method that reverse the order of the objects
     * on the list
     */
    public void reverse()
    {
        if (head != null) { // if list is not empty

            int count = 0; // counter for element in the list
            Node temp = head; // start in the head

            // count how many element in the list
            while (temp != null) {
                temp = temp.next;
                count++;
            }

            // For each node on the list except the last,
            // remove the node from the list and insert it
            // immediately after the original last node
            while (count != 1) {
                Node previous = findPrevious(count);
                append(previous.info); // add the node at last position
                delete(count - 1); // remove the node
                count--;
            }
        }
    }

    /**
     * Clear the list (make it empty)
     */
    public void clear()
    {
        head = null;
    }

    /**
     * toString method print the objects in the list
     * @return the objects on the list in the order in which they occur.
     */
    @Override
    public String toString()
    {
        String str = " ";
        Node temp = head;

        while (temp != null)
        {
            str += temp.info + " ";
            temp = temp.next;
        }
        return '[' + str + ']' + "\n";
    }
}
