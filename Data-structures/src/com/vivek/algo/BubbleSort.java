package com.vivek.algo;

public class BubbleSort {
	
	public static void main(String args []) {
		int[] arr = {4,5,3,2,10,1};
		
		for(int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	    for(int i = 0; i < arr.length; i++) {
	    	System.out.print(arr[i]+" ");
	    }
	    
	    //or 
	    int [] arr2  = {8, 7, 6, 5, 4, 3, 2, 1};
	    for(int i = 0; i < arr2.length - 1; i++) {
	    	for (int j = 0; j < arr2.length - i - 1; j++) {
	    		if(arr2[j] > arr2[j+1]) {
					int temp = arr2[j];
					arr2[j] = arr2[j+1];
					arr2[j+1] = temp;
				}
	    	}
	    }
	    System.out.println();
	    for(int i = 0; i < arr2.length; i++) {
	    	System.out.print(arr2[i]+" ");
	    }
	}

}
