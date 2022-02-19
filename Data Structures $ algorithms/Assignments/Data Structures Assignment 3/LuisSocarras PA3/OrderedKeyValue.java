package com.company;

/*
 * File: OrderedKeyValue.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */


/**
 * Class OrderedKeyValue which implements Comparable interface of Java and
 * store an ordered pair of a String key and its Integer value.
 */
public class OrderedKeyValue implements Comparable<String> {

    public String key; //String key
    public int value;

    /**
     * Creates a new object with key and value initialized
     * by the input parameters.
     * @param key
     * @param value
     */
    public OrderedKeyValue(String key, int value) // Constructor
    {
        this.key = key;
        this.value = value;
    }

    /**
     *  Method to implements Comparable interface by comparing the keys
     *  of two OrderedKeyValues based on the alphabetical order
     *  and in a case-insensitive fashion.
     * @param key2
     * @return
     */
    @Override
    public int compareTo(String key2) {

      return this.key.compareTo(key2);
    }
}
