package com.company;
/*
 * File: Element.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */


/**
 * Class Element store a key value type long and
 * two ints for row and column of the key.
 * Implements the Comparable interface for
 * comparing two key values.
 */
public class Element implements Comparable<Element> {

    public long key; // long value
    public int column; // column index
    public int row;  // row index

    /**
     * Creates a new element
     *
     * @param key    value
     * @param column column index
     * @param row    row index
     */
    public Element(long key, int column, int row) {
        this.key = key;
        this.column = column;
        this.row = row;
    }

    /**
     * compareTo Method to compare key values
     * with another element
     *
     * @param o second element
     * @return 1,-1 if one is smaller or 0 if they are equal
     */
    @Override
    public int compareTo(Element o) {
        Element element2 = o;

        if (this.key < element2.key) {
            return 1;
        } else if (this.key > element2.key) {
            return -1;
        } else {
            return 0;
        }

    }
}
