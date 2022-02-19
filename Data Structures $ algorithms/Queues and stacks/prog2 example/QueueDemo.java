package com.company;// File: QueueDemo.java

// Test class for CircularArrayQueue.java

import java.util.Random ;

public class QueueDemo 
{
    public static void main(String[] args) 
    {
        CircularArrayQueue<Integer> q = new CircularArrayQueue<Integer>() ;	
        Random r = new Random();

        // append 5 random positive 2-digit ints to the queue
        for (int i = 1; i <= 5; i++) 
        {
            int next = (r.nextInt(90) + 10);
            System.out.print("Now Appending " + next);
            q.append(next);
            System.out.println("\tUpdated queue : " + q);
        }

        // serve the queue 3 times
        for (int i = 1; i <= 3; i++) 
        {
            System.out.print("Item served: " + q.serve());
            System.out.println("\t\tUpdated queue : " + q);
        }

        // append 5 more random ints
        for (int i = 1; i <= 5; i++) 
        {
            int next = r.nextInt(90) + 10 ;	// 10 to 99, inclusive
            System.out.print("Now Appending " + next);
            q.append(next);
            System.out.println("\tUpdated queue: " + q);
        }

        // "safe" serve the queue 10 times
        for (int i = 1; i <= 10; i++) 
        {
            if (!q.isEmpty()) 
            {
                System.out.print("Item served: " + q.serve());
                System.out.println("\t\tUpdated queue: " + q);
            } 
            else 
            {
                System.out.println("ERROR! Attempt to serve empty queue!");
            }
        }
    }
}

