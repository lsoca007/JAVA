package com.company;
/*
 * File: Graph.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

/**
 * Class that represent a graph
 */
public class Graph {

    public int V; // number of vertices
    public int E; // number of edges
    public Edge edge[]; // list of edges

    /**
     * Inner class for representing edges
     */
    public class Edge
    {
        double weight; // weight value
        int source; // source index
        int destination; // destination index
    }

    /**
     * Constructor. Creates an empty graph
     *
     * @param v number of vertices
     */
    public Graph(int v) {
        V = v;
        E = v * v;

        this.edge = new Edge[E];
        for (int i = 0; i < E; ++i)
            edge[i] = new Edge();
    }
}