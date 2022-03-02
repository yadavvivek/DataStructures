package com.vivek.algo;

public class InsertionSort {
	
	/**
	 * @param args
	 */
	public static void main(String args []) {
		int[] a = {3, 4, 1, 10, 8, 7, 2, 6};
		
		int n = a.length;
		
		for (int i = 1; i < n; i++) {
			int j = i-1;
			int key = a[i];
			
			while(j >= 0 && a[j] > key) {
			    a[j+1] = a[j];
			    j--;
			}
			
			a[j+1] = key;
		}
		
		  for(int i = 0; i < n; i++) {
		    	System.out.print(a[i]+" ");
		    }
	}

}
