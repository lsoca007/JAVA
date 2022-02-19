package assignment6;
/*
 * File: Test.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Test class will read list operation instructions 
 * from a data file until end-of-file and call 
 * the appropriate method to execute each one.  
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException {

        LinkedList list = new LinkedList(); // creates a new list

        BufferedReader br = null;
        String line;
        int data = 0; // hold the info of the object
        int index; // hold the index for one object
        int index2; // hold a second index

        try {
            // seach the file
            br = new BufferedReader(new FileReader("list-ops.txt")); 
            
            // while the  file has next line
            while ((line = br.readLine()) != null) 
            {
                System.out.println(line);

                if (line.contains("APPEND"))
                {
                    data = Integer.parseInt(line.substring(6).trim());
                    list.append(data);
                    System.out.println(list);
                }
                if (line.contains("ADD"))
                {
                    index = Integer.parseInt(line.substring(4, 5).trim());
                    data = Integer.parseInt(line.substring(5).trim());
                    list.addAt(index, data);
                    System.out.println(list);
                }
                if (line.contains("DELETE")) {
                    index = Integer.parseInt(line.substring(7, 8).trim());
                    list.delete(index);
                    System.out.println(list);
                }
                if (line.contains("SWAP")) 
                {
                    index = Integer.parseInt(line.substring(5, 6).trim());
                    index2 = Integer.parseInt(line.substring(7, 8).trim());
                    list.swap(index, index2);
                    System.out.println(list);
                }
                if (line.contains("CLEAR"))
                {
                    list.clear();
                    System.out.println(list);
                }
                if (line.contains("REVERSE"))
                {
                    list.reverse();
                    System.out.println(list);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
