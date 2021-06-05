package ru.strelchm.eldo.challenge;

import java.util.*;

public class Gruz {

    static   <T> void printAllRecursive(
            int n, T[] elements, char delimiter) {

        if(n == 1) {
            printArray(elements, delimiter);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements, delimiter);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements, delimiter);
        }
    }

    static private<T> void swap(T[] input, int a, int b) {
        T tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    static private<T> void printArray(T[] input) {
        System.out.print('\n');
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        int sum = 0;
        List<Integer> gruzArr = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        String str = sc.nextLine();              //reads string

        String[] splitArr = str.split(",");

        System.out.println(Arrays.toString(splitArr));


        int[] intArr = new int[splitArr.length];

        int length = intArr.length;

        for (int i = 0; i < length; i++) {
            intArr[i] = Integer.parseInt(splitArr[i]);
        }

        HashSet

        int i = 0;
        while (i < length) {
            if (intArr[i] < i) {
                swap(intArr, i % 2 == 0 ?  0: intArr[i], i);
                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }


        System.out.println(sum);  // write the answer
    }
}