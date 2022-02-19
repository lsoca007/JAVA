package com.company;

/*
 * File: Main.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Main class that compares the efficiency of UnbalancedTreeMap
 * with the standard java.util.TreeMap⟨String, Integer⟩
 */
public class Main {

    public static void main(String[] args) throws IOException
    {

        TreeMap<String, Integer> map = new TreeMap< String, Integer>();
        UnbalanceTreeMap treeMap = new UnbalanceTreeMap();

        MyUnbalancedTreeMapTest(treeMap);
        standardJavaTreeMapTest(map);
    }

    /**
     * Test Scenario: Calculating the Frequency of
     * Words appeared in H. C. Andersen Fairy Tales
     * Uses standard java.util.TreeMap⟨String, Integer⟩
     * @param map treemap object
     * @throws FileNotFoundException
     */
    private static void standardJavaTreeMapTest(TreeMap<String, Integer> map) throws FileNotFoundException {

        long startTime;
        long totalTime = 0;

        for (int i = 1; i <= 77 ; i++) {

            File file = new File ("/Users/luisdavid/Desktop/HCAndersen Tales/" + i + ".okpuncs"); // open each file

            Scanner scan = new Scanner(file); // reading the file

            while (scan.hasNext()) // read each
            {

                String[] line = scan.next().replaceAll("[\\W]", "").split(" "); // reading the word
                startTime = System.nanoTime(); // start counting time
                String word = line[0];

                if (map.get(word) == null) // if word is not in the tree
                {
                    map.put(word,0); // add word
                }
                else { // else, update value
                    map.put(word, 1 + map.get(word)); // add word to the tree

                }
                totalTime+= (System.nanoTime()- startTime);
            }
        }
        System.out.println("Standard Java Tree Map , " + totalTime );
    }

    /**
     * Test Scenario: Calculating the Frequency of
     * Words appeared in H. C. Andersen Fairy Tales
     * Uses standard java.util.TreeMap⟨String, Integer⟩
     * @param treeMap tree map object
     * @throws FileNotFoundException
     */
    private static void MyUnbalancedTreeMapTest(UnbalanceTreeMap treeMap) throws FileNotFoundException {

        long startTime;
        long totalTime = 0;

        for (int i = 1; i <= 77 ; i++) {

            File file = new File ("/Users/luisdavid/Desktop/HCAndersen Tales/" + i + ".okpuncs"); // open each file

            Scanner scan = new Scanner(file); // reading the file

            while (scan.hasNext()) // read each
            {

                String[] line = scan.next().replaceAll("[\\W]", "").split(" "); // reading the word
                startTime = System.nanoTime(); // start counting time
                String word = line[0];
                treeMap.put(word, 1 + treeMap.get(word));
                totalTime+= (System.nanoTime()- startTime);

            }
        }
        System.out.println("My Unbalanced TreeMap, " + totalTime );
    }
}
