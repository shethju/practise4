package com.timbuchalka;

import java.util.Scanner;

public class AvgInArray {

    private static Scanner s = new Scanner(System.in);
    private static int[] baseData = new int[10];

    public static void main(String[] args) {
        String s = "abc";
        s.length();
    		System.out.println("Enter 10 integers:");
        getInput();
        printArray(baseData);
        resizeArray();
        System.out.println("Enter 12 integers:");
        getInput();
//        baseData[10] = 67;
//        baseData[11] = 34;
        printArray(baseData);
        Abc a = new Abc();
    }
    
    private void what() {
    		Abc a = new Abc();
    }

    private static void getInput()
    {
        for(int i = 0; i < baseData.length; i++)
            baseData[i] = s.nextInt();
    }

    private static void printArray(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void resizeArray()
    {
        int[] original = baseData;

        baseData = new int[12];
        for (int i = 0; i < original.length; i++)
            baseData[i] = original[i];
    }
    
    private class Abc {
    		public Abc() {}
    }

}
