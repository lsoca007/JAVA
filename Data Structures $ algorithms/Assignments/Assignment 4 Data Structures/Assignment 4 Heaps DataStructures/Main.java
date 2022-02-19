package com.company;
/*
 * File: Main.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Main class compare the efficiency of MyBinaryHeap
 * with the standard java.util.PriorityQueue⟨⟩
 * in a given scenario when merging 25 sorted lists.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        JavaPriorityQueueTest();
        MyBinaryHeapTest();

    }

    /**
     * Method for  test scenario using java.util.PriorityQueue⟨⟩.
     *
     * @throws FileNotFoundException
     */
    private static void JavaPriorityQueueTest() throws FileNotFoundException {
        //-----------Scenario 2---------

        // Creating empty priority queue

        long startTime;
        long totalTime = 0;
        // open the file
        File file = new File("/Users/luisdavid/Desktop/Data Sctructure/Assignment 4/in.csv");
        Scanner s = new Scanner(file); // read the file
        int count = 0;

        long a[][] = new long[25][10000]; // [row][column]

        // store all numbers in a 2d array
        for (int i = 0; i < 25; i++) {
            Scanner rowScanner = new Scanner(s.nextLine());
            rowScanner.useDelimiter(",");

            for (int j = 0; j < 10000; j++) {
                a[i][j] = rowScanner.nextLong();
            }
        }
        startTime = System.nanoTime(); // 5)

        //6) build a heap/priorityQueue of size 25 with the first elements of the 25 arrays.
        PriorityQueue<Element> pQueue = new PriorityQueue<Element>(25);

        // add the first 25 element to the heap
        for (int i = 0; i < 25; i++) {
            Element element = new Element(a[i][0], 0, i);
            pQueue.add(element);
        }

        //7) For i = 1 to 250,000 − 25
        ArrayList<Long> heapList = new ArrayList<Long>();  // for the sorted list

        for (int i = 0; i < (250000 - 25); i++) {

            //(a) extract the element (x) stored in the heap/priorityQueue with minimum key value.
            Element num = pQueue.poll();
            //(b) add x to an ArrayList which will eventually store the sorted list of all elements.
            heapList.add(num.key);
            //(c) insert the next element of the array from which x is taken from to the heap/priorityQueue.
            if ((num.column + 1) < 10000) {
                Element element = new Element(a[num.row][num.column + 1], num.column + 1, num.row);
                pQueue.add(element);
            }

        }
        totalTime += (System.nanoTime() - startTime);
        System.out.println("Java PriorityQueue, " + totalTime);
    }

    /**
     * Method for Test Scenario using MyBinaryHeap
     *
     * @throws FileNotFoundException
     */
    private static void MyBinaryHeapTest() throws FileNotFoundException {

        // ------Scenario 1--------
        long startTime;
        long totalTime = 0;
        // open the file
        File file = new File("/Users/luisdavid/Desktop/Data Sctructure/Assignment 4/in.csv");
        Scanner s = new Scanner(file); // read the file

        long a[][] = new long[25][10000]; // [row][column]

        // store all numbers in a 2d array
        for (int i = 0; i < 25; i++) {
            Scanner rowScanner = new Scanner(s.nextLine());
            rowScanner.useDelimiter(",");
            for (int j = 0; j < 10000; j++) {
                a[i][j] = rowScanner.nextLong();

            }
        }
        startTime = System.nanoTime();

        //6) build a heap/priorityQueue of size 25 with the first elements of the 25 arrays.
        MyBinaryHeap heap = new MyBinaryHeap(25);

        // add the first 25 element to the heap
        for (int i = 0; i < 25; i++) {
            Element element = new Element(a[i][0], 0, i);
            heap.insert(element);
        }

        //7) For i = 1 to 250,000 − 25
        ArrayList<Long> heapList = new ArrayList<Long>();  // for the sorted list

        for (int i = 0; i < (250000 - 25); i++) {

            //(a) extract the element (x) stored in the heap/priorityQueue with minimum key value.
            Element num = heap.deleteMin();
            //(b) add x to an ArrayList which will eventually store the sorted list of all elements.
            heapList.add(num.key);
            //(c) insert the next element of the array from which x is taken from to the heap/priorityQueue.
            if ((num.column + 1) < 10000) {
                Element element = new Element(a[num.row][num.column + 1], num.column + 1, num.row);
                heap.insert(element);
            }
        }
        totalTime += (System.nanoTime() - startTime);
        System.out.println("MyBinaryHeap, " + totalTime);
    }
}
