package com.company;

/*
 * File: Main.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

/**
 * The Main class test the running times of “enqueue” and “dequeue” operations
 * for the queue using circular array and the queue using two stacks.
 */
public class Main {

    public static void main(String[] args) {

        CAQueue circularArray;
        SSQueue twoStacksQueue;

        int n[] = {20, 50, 100, 1000, 10000, 100000, 1000000 };

        System.out.println("\nScenario 1 for circular array");

        //Scenario 1:
        for (int k = 0; k < n.length ; k++) {
            circularArray = new CAQueue();

            for (int i = 0; i < n[k]; i++)
            {
                circularArray.enqueue(i);
            }

            long startTime = System.nanoTime();

            for (int i = 0; i < n[k]; i++)
            {
                circularArray.enqueue(i + n[k]);
                circularArray.dequeue();
            }

            long endTime = System.nanoTime();

            long totalTime = endTime - startTime;
            System.out.println(n[k] + ", " + totalTime);

        }

        System.out.println("\nScenario 1 for Two stacks queue");

        for (int k = 0; k < n.length ; k++) {

            twoStacksQueue = new SSQueue();

            for (int i = 0; i < n[k]; i++)
            {
                twoStacksQueue.enqueue(i);
            }
            long startTime = System.nanoTime();

            for (int i = 0; i < n[k]; i++)
            {
                twoStacksQueue.enqueue(i + n[k]);
                twoStacksQueue.dequeue();
            }

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(n[k] + ", " + totalTime);
        }

        //Scenario 2
        System.out.println("\nScenario 2 for circular array");

        for (int k = 0; k < n.length; k++)
        {
            circularArray = new CAQueue();
            for (int i = 0; i < n[k]; i++)
            {
                circularArray.enqueue(i);
            }
            long startTime = System.nanoTime();

            for (int i = 0; i < n[k]; i++)
            {
                if (Math.random() < 0.5)
                {
                    circularArray.enqueue(i + n[k]);
                }
                else {
                    circularArray.dequeue();
                }
            }

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(n[k] + ", " + totalTime);
        }

        System.out.println("\nScenario 2 for two stacks queue");

        for (int k = 0; k < n.length; k++)
        {
            twoStacksQueue = new SSQueue();
            for (int i = 0; i < n[k]; i++)
            {
                twoStacksQueue.enqueue(i);
            }

            long startTime = System.nanoTime(); // start time-----

            for (int i = 0; i < n[k]; i++)
            {
                if (Math.random() < 0.5)
                {
                    twoStacksQueue.enqueue(i + n[k]);
                }
                else {
                    twoStacksQueue.dequeue();
                }
            }

            long endTime = System.nanoTime(); // end time-------
            long totalTime = endTime - startTime;
            System.out.println(n[k] + ", " + totalTime);
        }
    }
}
