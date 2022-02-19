package com.company;
/*
 * File: Main.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main class used to compares the running times of the
 * implemented pivot picking methods in the two given scenarios
 */
public class Main {

    public static void main(String[] args) throws IOException
    {
        int n[] = {100, 1000, 4000, 16000, 32000, 64000, 128000, 256000, 512000};

        scenario1(n);
        scenario2(n);

    }

    /**
     * Method used for testing scenario 1
     *
     * @param n array of elements
     * @throws IOException
     */
    public static void scenario1(int n[]) throws IOException {

        // read file and store data in array
        BufferedReader br = null;
        String line;
        int lineCount = 0;
        double[] a = new double[512000];

        try {

            // read the file
            br = new BufferedReader(new FileReader("uniformlyDistributedFrom-12BTo+12B.csv"));

            // while the  file has next line
            while ((line = br.readLine()) != null) {
                double data = Double.parseDouble(line);
                a[lineCount] = data;
                lineCount++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        br.close();

        // for pivotPick1, pivotPick2, pivotPick3, pivotPick4
        // Scenario 1:
        QuickSort quickSort;
        System.out.println("Scenario 1");

        for (int k = 0; k < n.length; k++) {

            long startTime = System.nanoTime();

            quickSort = new QuickSort(a, 0, n[k] - 1);

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(n[k] + ", " + totalTime);
        }
    }

    /**
     * Method used for testing scenario 2
     *
     * @param n array of elements
     * @throws IOException
     */
    public static void scenario2(int n[]) throws IOException {

        //Scenario 2:
        // Sorting an array of normally distributed long integers
        // for pivotPick1, pivotPick2, pivotPick3, pivotPick5
        // read file and store data in array
        BufferedReader br = null;
        String line;
        int lineCount = 0;
        double[] a = new double[512000];
        try {

            // read the file
            br = new BufferedReader(new FileReader("normallyDistributedTruncatedFrom-12BTo+12B.csv"));

            // while the  file has next line
            while ((line = br.readLine()) != null) {

                double data = Double.parseDouble(line);
                a[lineCount] = data;

                lineCount++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        br.close();

        // testing
        System.out.println("Scenario 2");

        QuickSort quickSort;

        for (int k = 0; k < n.length; k++) {

            long startTime = System.nanoTime();

            quickSort = new QuickSort(a, 0, n[k] - 1);

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(n[k] + ", " + totalTime);

        }
    }
}
