package com.company;

/*
 * File: QuickSort.java
 * Programmer: Luis David Socarras
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 */

/**
 * Class that uses a internal quicksort method
 * implementing multiple pivot picking methods
 */
public class QuickSort {

    private static final int CUTOFF = 10;
    private double[] a;
    private int left;
    private int right;

    /**
     * Creates a new quicksort
     *
     * @param a     an array of Comparable items.
     * @param left  he left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    public QuickSort(double[] a, int left, int right) {
        this.a = a;
        this.left = left;
        this.right = right;
        quicksort(a, left, right);
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static void quicksort(double[] a, int left, int right) {

        if (left + CUTOFF <= right) {
            double pivot = pivotPick(a, left, right); // number in the pivot

            //begin partitioning
            int i = left - 1, j = right + 1;

            for (; ; ) {

                while (a[++i] < pivot) {
                }

                while (a[--j] > pivot) {
                }
                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }

            }
            quicksort(a, left, i - 1);// sort small elements
            quicksort(a, j + 1, right);// sort large elements
        } else { // Do an insertion sort on the subarray
            insertionSort(a, left, right);
        }
    }

    /**
     * SwapReferences method swap two element in the array
     *
     * @param array an array of Comparable items.
     * @param i     left index to swap
     * @param j     right index to swap
     */
    public static void swapReferences(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * This method implement an insertion sort
     *
     * @param list  an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    public static void insertionSort(double[] list, int left, int right) {

        for (int i = left; i <= right; ++i) {
            int j = i;
            // Insert numbers[i] into sorted part
            // stopping once numbers[i] in correct position
            while (j > 0 && list[j] < list[j - 1]) {
                double temp = list[j];
                list[j] = list[j - 1];
                list[j - 1] = temp;
                --j;
            }
        }
    }

    /**
     * PivotPick1: Returns middle element of array
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     * @return pivot
     */
    public static double pivotPick(double[] a, int left, int right) {

        return a[(left + right) / 2];
    }

    /**
     * PivotPick2 returns the median of three elements of array
     * at indices left, right, and the middle element
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     * @return pivot
     */
    public static double pivotPick2(double[] a, int left, int right) {

        double arr[] = {a[left], a[(left + right) / 2], a[right]};

        if (arr[2] < arr[0]) {
            swapReferences(arr, 0, 2);
        }
        if (arr[1] < arr[0]) {
            swapReferences(arr, 1, 0);
        }
        if (arr[2] < arr[1]) {
            swapReferences(arr, 2, 1);
        }

        return arr[1];
    }

    /**
     * PivotPick3: Return the median of five elements of the array
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     * @return pivot
     */
    public static double pivotPick3(double[] a, int left, int right) {

        double arr[] = {a[left], a[(3 * left + right) / 4], a[(left + right) / 2], a[(left + 3 * right) / 4], a[right]};

        return findMedianof5(arr);
    }

    /**
     * Return the median of five values of the array
     * assuming that it contains uniformly distributed values.
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     * @return pivot
     */
    public static double pivotPick4(double[] a, int left, int right) {

        // find min and max
        double min = -12000000000d;
        double max = 12000000000d;

        double mu = min + (a[left] + a[right]) * (max - min) / (2 * (a.length - 1));

        double arr[] = {mu, a[left], a[(2 * left + right) / 3], a[(left + 2 * right) / 3], a[right]};

        return findMedianof5(arr);
    }

    /**
     * Return the median of five values of the array
     * assuming that it contains normally distributed values.
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     * @return pivot
     */
    public static double pivotPick5(double[] a, int left, int right) {

        double gamma; // estimated median in normal distribution
        double mean = 0;
        double s = 3000000000d; //standard deviation

        // find gamma
        gamma = s * 4 * (((a[left] + a[right]) / (a.length - 1)) - 1) + mean;

        double arr[] = {gamma, a[left], a[(2 * left + right) / 3], a[(left + 2 * right) / 3], a[right]};

        return findMedianof5(arr);
    }

    /**
     * Return the median of five values of the array
     * assuming that it contains normally distributed values.
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     * @return pivot
     */
    public static double pivotPick6(double[] a, int left, int right) {

        double gamma; // estimated median in normal distribution
        double mean = 0;
        double s = 3000000000d; //standard deviation
        double quantile = 0;

        // quantile was calculated using the quantile ( (left + right) / 2(a.length-1) )
        // using "quantile.csv"
        if (right == 99) {
            quantile = -3.719016485;
        }
        if (right == 999) {
            quantile = -2.335448563;
        }
        if (right == 3999) {
            quantile = -2.660606739;
        }
        if (right == 15999) {
            quantile = -2.153747231;
        }
        if (right == 31999) {
            quantile = -1.862731867;
        }
        if (right == 63999) {
            quantile = -1.534120544;

        }
        if (right == 127999) {
            quantile = -1.15034938;

        }
        if (right == 255999) {
            quantile = -0.67448975;
        }
        if (right == 511999) {
            quantile = 0;
        }

        // find gamma
        gamma = (s * quantile) + mean;

        double arr[] = {gamma, a[left], a[(2 * left + right) / 3], a[(left + 2 * right) / 3], a[right]};

        return findMedianof5(arr);
    }

    /**
     * Find median of 5 numbers using 6 comparisons
     *
     * @param a an array of elements.
     * @return median
     */
    public static double findMedianof5(double[] a) {

        if (a.length != 5)
            return Double.MIN_VALUE;
        if (a[0] < a[1])
            swapReferences(a, 0, 1);
        if (a[2] < a[3])
            swapReferences(a, 2, 3);
        if (a[0] < a[2]) {
            swapReferences(a, 0, 2);
            swapReferences(a, 1, 3);
        }
        if (a[1] < a[4])
            swapReferences(a, 1, 4);
        if (a[1] > a[2])
            if (a[2] > a[4])
                return a[2];
            else
                return a[4];
        else if (a[1] > a[3])
            return a[1];
        else
            return a[3];
    }

    /**
     * Method to print the array as list
     *
     * @param array list of elements
     * @return all elements in the array as string
     */
    public static String print(double[] array) {
        String str = " ";

        for (int i = 0; i < array.length; i++) {
            str += array[i] + "   ";

        }
        return str;
    }
}
