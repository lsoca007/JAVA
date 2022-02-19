package com.company;

/*
 * File: UnbalanceTreeMap.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

/**
 *  This class implementing a tree map (UnbalancedTreeMap) and
 *  stores objects of class OrderedKeyValue in the unbalanced
 *  binary search tree.
 */
public class UnbalanceTreeMap {

    /**
     * Class for creating a node
     */
    class BinaryNode {

        private OrderedKeyValue keyValue;  // key
        private BinaryNode leftChild;  // left node
        private BinaryNode rightChild;  // right node

        /**
         * Creates an empty node
         *
         * @param keyValue key
         */
        public BinaryNode(OrderedKeyValue keyValue) // constructor
        {
            this.keyValue = keyValue;
            leftChild = null;
            rightChild = null;
        }
    }

    //instances
    private BinaryNode root; // root of binary tree
    private int count = 0; // keep count of elements in the tree
    private String[] keys; //for storing all the keys in the tree
    private int currPtr = 0; //for tracking the index of the key array


    /**
     * Creates an empty tree map
     */
    public UnbalanceTreeMap() // constructor
    {
        this.root = null;

    }

    /**
     * Searches through the binary search tree to see whether any node
     * stores an object of OrderedKeyValue which matches the input key.
     * If such OrderedKeyValue is found, the method returns its value;
     * otherwise, it returns 0.
     * @param key
     * @return 0 if key wasn't found in the tree
     */
    public int get(String key) {

        BinaryNode currentNode = root; // starting from the root

        while (currentNode != null)  // wile node is not empty
        {
            if (currentNode.keyValue.compareTo(key) < 0) // if key is smaller than current node ...
            {
                currentNode = currentNode.rightChild; // update currentNode to the left child

            } else if (currentNode.keyValue.compareTo(key) > 0) // if key is larger than currentNode
            {
                currentNode = currentNode.leftChild; // update currentNode to right child

            } else {
                return currentNode.keyValue.value; // else, currentNode == key, return key
            }
        }
        return 0; // key not found in the tree
    }

    /**
     * Searches through the tree to see whether any node stores
     * an object of OrderedKeyValue which matches the input key.
     * If such Ordered- KeyValue is found, the method sets its value
     * to the one given by the second input parameter and returns
     * the previous value as the method output; otherwise,
     * it inserts a new node to the tree to store
     * the given key and value and returns 0.
     * @param key   string to be inserted
     * @param value value for key string
     * @return 0 after the value was inserted successfully
     */
    public int put(String key, int value) {

        OrderedKeyValue newValue = new OrderedKeyValue(key, value); // new value to be inserted in a node of the tree
        BinaryNode currentNode = root; // keep track of current node in the tree. Start at tree root

        if (currentNode == null) { // if current node(root) is empty, insert node here
            root = new BinaryNode(newValue);
            count++;
            return 0;
        }

        while (currentNode != null) // in order traversal
        {
            if (currentNode.keyValue.compareTo(key) < 0) // if key is larger than current node ...
            {
                if (currentNode.rightChild == null) // if there is not right children ...
                {
                    currentNode.rightChild = new BinaryNode(newValue); // create right child with value
                    count++;
                    return 0; // exit loop
                } else {
                    currentNode = currentNode.rightChild; //update currentNode to right child
                }

            } else if (currentNode.keyValue.compareTo(key) > 0) // if key is smaller than current node ...
            {
                if (currentNode.leftChild == null) // if left there is not left child ...
                {
                    currentNode.leftChild = new BinaryNode(newValue); // create left child with the new value
                    count++;
                    return 0; // exit loop

                } else {
                    currentNode = currentNode.leftChild; // update currentNode to the left child
                }

            } else { //currentNode == key

                int keyValue = currentNode.keyValue.value;
                currentNode.keyValue = newValue;
                return keyValue;

            }
        }
        return 0;

    }

    /**
     * This method store all the keys in an array of strings
     * by visiting the nodes of BST using in-order traversal,
     * The returned array contains all the keys in alphabetical order.
     * @return array of strings
     */
    public String[] keySet() {
        keys = new String[count]; // count = total element in the tree
        inOrderTraversal(root); //recursive method store the string in order
        return keys;
    }

    /**
     * This method store in an array the keys in the proper order
     * (in-order traversal)
     * @param currentNode start node
     */
    void inOrderTraversal(BinaryNode currentNode)
    {
        if (currentNode != null)
        {
            inOrderTraversal(currentNode.leftChild); // left most child
            keys[currPtr++] = currentNode.keyValue.key; //store current value
            inOrderTraversal(currentNode.rightChild); // right child
        }
    }

}
