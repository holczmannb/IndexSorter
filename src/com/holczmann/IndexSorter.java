package com.holczmann;

import java.util.Arrays;
import java.util.Random;

public class IndexSorter {
	
	/**
	 * Java implemented quick sort
	 * @param a: array as in/out parameter
	 * @return runtime of the sorting
	 */
	public static long guicksort(int[] a) {
		long startTime = System.nanoTime();
	
		Arrays.sort(a);
		
		long finishTime = System.nanoTime();
		long runTime = finishTime - startTime;
		return runTime;
	}
	
	/**
	 * Index Sorter
	 * @param a: array as in/out parameter
	 * @return runtime of the sorting
	 */
	public static long indexsort(int[] a) {
		long startTime = System.nanoTime();

		// Search for the maximal number in the array
		int maxItem = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > maxItem) maxItem = a[i];
		}
				
		// Create helper array. Size is the maximal number from the input.
		// Use the number form input array as index and set true by this index in the helper array. 
		boolean[] b = new boolean[maxItem + 1];
		for (int i = 0; i < a.length; i++) {
			b[a[i]] = true;
		}
		
		
		// Loop over the helper array and use the index as value and set back into the original array.
		int pointer = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i]) {
				a[pointer] = i;
				pointer++;
			}
		}
		
		long finishTime = System.nanoTime();
		long runTime = finishTime - startTime;
	
		return runTime;
	}
	
	/**
	 * Fill array with random unique numbers
	 * @param a: array as in/out parameter
	 * @param range: interval of natural numeric number 
	 */
	private static void generateSample(int[] a, int range) {
		Random rand = new Random();
		int i = 0;
		boolean done = false;
		while (!done) {
			int number = rand.nextInt(range);
			boolean found = false;
			for (int j = 0; j < i && !found; j++) {
				if (a[j] == number) {
					found = true;
				}
			}
			if(!found) {
				a[i] = number;
				i++;
				if (i == a.length) done = true;
			}
		}
	}

	/**
	 * IndexSorter vs QuickSorter test application
	 * @param args: size of the array as int; range of sortable number as int 
	 */
	public static void main(String[] args) {
		// Default size and range
		int size = 1000;
		int range = 10000;
		
		// Read the input parameters
		if (args.length > 0) {
		    try {
		        size = Integer.parseInt(args[0]);
		        range = Integer.parseInt(args[1]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument" + args[0] + " must be an integer.");
		        System.exit(1);
		    }
		}
		
		
		// Sample Generation
		int[] originalSample = new int[size];
		IndexSorter.generateSample(originalSample, range);
		System.out.println("Sample (size:" + size + " / intervall: " + range + "):"  + Arrays.toString(originalSample));
		
		// QuickSort
		int[] a = originalSample.clone();
		
		long runTimeQuick = IndexSorter.guicksort(a);
		
		System.out.println("QuickSort (" + runTimeQuick +"ns)"  + Arrays.toString(a));
	
		// IndexSort
		a = originalSample.clone();
		
		long runTimeIndex = IndexSorter.indexsort(a);
		
		System.out.println("IndexSort (" + runTimeIndex +"ns)" + Arrays.toString(a));
		long percentage = ((runTimeQuick - runTimeIndex) * 100) / runTimeQuick;
		System.out.println("Runtime reduction (QuickSort - IndexSort / QuickSort) : " + percentage + "%");
	}

}
