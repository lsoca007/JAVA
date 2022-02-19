package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int input;
        Graph graph = new Graph(55);

        // open the file
        File file = new File("/Users/luisdavid/Desktop/Assignment 5 Data Structures/exchange rates.csv");
        Scanner s = new Scanner(file); // read the file
        int edgeCount = 0;

        String currency[] = new String[55];

        // store all numbers in a 2d array
        for (int i = 0; i < 55; i++) {

            Scanner rowScanner = new Scanner(s.nextLine());
            rowScanner.useDelimiter(",");

            for (int j = 0; j < 55; j++) {
                if (j == 0 || i == 0) {
                    currency[j] = rowScanner.next(); // store currencies names (vertices)
                } else { // store edges
                    graph.edge[edgeCount].source = i;
                    graph.edge[edgeCount].destination = j;
                    double edge = (rowScanner.nextDouble()); // store edges
                    graph.edge[edgeCount].weight = edge;
                    edgeCount++;
                }

            }
        }

        System.out.println("Enter a number for the source currency: ");
        for (int i = 1; i < currency.length; i++) {
            System.out.println("" + i + ") " + currency[i]);

        }
        Scanner keyboard = new Scanner(System.in);
        input = keyboard.nextInt(); // user input
        // japanese ten = 42
        System.out.println("\tSource currency is " + currency[input]);
        BellmanFord(graph, input, currency);

    }

    /**
     * Method that implement Bellman Fold algorithm. Solves the shortest
     * path problem given a source in a graph with both negative and positive weights.
     *
     * @param graph    graph
     * @param src      source index
     * @param vertices vertices list
     */
    static public void BellmanFord(Graph graph, int src, String[] vertices) {
        int V = graph.V;
        int E = graph.E;
        double maxEx[] = new double[V];

        // Initialize distances
        for (int i = 0; i < V; ++i) {
            maxEx[i] = Double.MAX_VALUE; //  max value
        }

        maxEx[src] = 0; // make source = 0

        //Relax all edges |V| - 1 times
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].source; // gets the source index
                int v = graph.edge[j].destination; // gets destination index
                double logWeight = (-1) * Math.log(graph.edge[j].weight);

                if (maxEx[u] != Double.MAX_VALUE && maxEx[u] + logWeight < maxEx[v]) {
                    maxEx[v] = maxEx[u] + logWeight;
                }
            }
        }

        //Check for negative-weight cycles.
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].source;
            int v = graph.edge[j].source;
            double weight = graph.edge[j].weight;
            if (maxEx[u] != Double.MAX_VALUE && maxEx[u] + weight < maxEx[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printStatements(graph, src, vertices, V, maxEx);
    }

    /**
     * This method print Bellman Ford result
     * with the direct exchanges rates
     *
     * @param graph    original graph
     * @param src      source
     * @param vertices list of vertices
     * @param v        number of vertices
     * @param maxEx    bellman result list
     */
    private static void printStatements(Graph graph, int src, String[] vertices, int v,
                                        double[] maxEx) {
        int index = 0;
        int startIndex = 54 * (src - 1);
        double dist[] = new double[v];
        //store the direct rates
        for (int i = startIndex - 1; i < startIndex + 54; i++)
        {
            dist[index] = graph.edge[i].weight;
            index++;
        }

        // print final output
        for (int i = 1; i < v; ++i)
        {
            System.out.println(vertices[i] + ": max Exchange Rate is "
                    + Math.pow(Math.E, (-1) * maxEx[i]) + " and direct rate is " + dist[i]);
        }
    }


}
