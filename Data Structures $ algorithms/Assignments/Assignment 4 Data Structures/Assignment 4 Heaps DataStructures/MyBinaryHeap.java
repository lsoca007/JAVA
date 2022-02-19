package com.company;
/*
 * File: MyBinaryHeap.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

import java.util.Arrays;

/**
 * This class creates a binary Heap and
 * store objects of the class elements
 */
public class MyBinaryHeap {

    private int capacity; // capacity of the array
    private int currentSize; // current # of element in the array
    private Element[] array; // array of elements

    /**
     * Creates a new Heap
     */
    public MyBinaryHeap() // no-arg constructor
    {
        this.capacity = 10;
        this.currentSize = 0;
        this.array = new Element[capacity];
    }

    /**
     * Creates a new Heap with given capacity
     */
    public MyBinaryHeap(int capacity) // parameterized constructor
    {
        this.capacity = capacity;
        this.currentSize = 0;
        this.array = new Element[capacity];
    }


    /**
     * Get the index of the left child
     *
     * @param parentIndex index of the parent
     * @return left child index
     */
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    /**
     * Get the index of the right child
     *
     * @param parentIndex index of the parent
     * @return right child index
     */
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    /**
     * Get the parent index
     *
     * @param childIndex index of the child
     * @return parent index
     */
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    /**
     * Check if there is a left child
     *
     * @param index index to check
     * @return true if there is left child
     */
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < currentSize;
    }

    /**
     * Check if there is a right child
     *
     * @param index index to check
     * @return true if there is right child
     */
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < currentSize;
    }

    /**
     * Check if there a parent
     *
     * @param index index to check
     * @return true if there is a parent
     */
    private boolean hasParent(int index) {
        return getParentIndex(index) < currentSize;
    }

    /**
     * Get the element in the left child
     *
     * @param index of the element
     * @return element at given index
     */
    private Element leftChild(int index) {
        return array[getLeftChildIndex(index)];
    }

    /**
     * Get the element in the right child
     *
     * @param index of the element
     * @return element at given index
     */
    private Element rightChild(int index) {
        return array[getRightChildIndex(index)];
    }

    /**
     * Get the parent of element
     *
     * @param index index of element
     * @return parent element
     */
    private Element parent(int index) {
        return array[getParentIndex(index)];
    }

    /**
     * Swap two elements at the given indexes
     *
     * @param indexOne indexOne
     * @param indexTwo indexTwo
     */
    private void swap(int indexOne, int indexTwo) {
        Element temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    /**
     * Method used to resize the array
     */
    private void ensureExtraCapacity() {
        if (currentSize == capacity) // if array is full, resize
        {
            array = Arrays.copyOf(array, capacity * 2);
            capacity *= 2;
        }
    }

    /**
     * Insert a new element to the end of the array and
     * then applying a percolate-up operation
     *
     * @param newElement element to be added in the heap
     */
    public void insert(Element newElement) {
        // Element item = new Element(key,x,y);
        ensureExtraCapacity(); // check if array is full
        array[currentSize] = newElement; // add element to the last position
        currentSize++; // increase size
        heapifyUp();
    }

    /**
     * deleteMin method remove the smalles item from the array
     * deleteMin requires:
     * - swap the first and last elements of the array;
     * 􏰀- shorten the array by removing the last element; 􏰀
     * - and finally apply a percolate-down operation.
     *
     * @return
     */
    public Element deleteMin() {
        // if array is empty
        if (currentSize == 0) throw new IllegalStateException();

        // if array is not empty
        Element minElement = array[0]; // hold the minimum value in a temporal variable
        array[0] = array[currentSize - 1]; // take the last element in the array and move it to the first element
        currentSize--; // decrease the size

        heapifyDown(); // call method to heapify down
        return minElement; // return min
    }

    /**
     * heapifyUp method put the new added element in the right position
     * by moving up the element in the heap while comparing
     * to the current parent and swapping the elements.
     */
    public void heapifyUp() {
        int index = currentSize - 1; // start with the last element

        //        true        and  down element is smaller than parent
        while (hasParent(index) && parent(index).compareTo(array[index]) < 0) {
            swap(getParentIndex(index), index); // swap element
            index = getParentIndex(index); // update index
        }
    }

    /**
     * heapifyDown rearrange the heap after deleting the peak element by inserting
     * at the top, the last element at the bottom of the heap and
     * then heapfying the new top element down
     */
    public void heapifyDown() {
        int index = 0; // start at index 0

        while (hasLeftChild(index)) // if there is no left child, there is not right child
        {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) > 0) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (array[index].compareTo(array[smallerChildIndex]) > 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;

        }
    }

    /**
     * Print all the element in the heap as a list
     *
     * @return str String with all the elements
     */
    @Override
    public String toString() {

        String str = " ";

        for (int i = 0; i < currentSize; i++) {
            str += array[i].key + " index = " + array[i].row + "\n";
        }

        return str;
    }
}
