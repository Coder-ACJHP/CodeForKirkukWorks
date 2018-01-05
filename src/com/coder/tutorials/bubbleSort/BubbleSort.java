/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coder.tutorials.bubbleSort;

/**
 *
 * @author dell-pc
 */
public class BubbleSort {
    
    public static void main(String[] args) {

        sortTheArray(new int[]{23,4,42,15,16,8});
    }
    
    private static void sortTheArray(int[] arr) {
        
        if(arr.length <= 0) {
            System.err.println("Array cannot to be empty!");
            System.exit(0);
        }

        int temp = 0;
        for(int i=0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        for (int i : arr) {
            System.err.println(i);
        }
    }
}
