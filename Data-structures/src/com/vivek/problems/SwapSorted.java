package com.vivek.problems;

public class SwapSorted {
	
	public static void main(String args []) {
		int[] arr =  {3,2,1};
		arr = sortedArrary(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	private static int[] sortedArrary(int[] a) {
	    int _1stEleIndex = -1, _2ndEleIndex = -1;
	    for(int i = 0; i < a.length - 1; i++) {
	        if(_1stEleIndex == -1 && a[i] > a[i+1]) {
	            _1stEleIndex = i;
	            _2ndEleIndex = i+1;
	        } else if( _2ndEleIndex != -1 && a[i+1] < a[_2ndEleIndex]){
	            _2ndEleIndex = i + 1;
	        }
	    }
	     
	    int temp = a[_2ndEleIndex];
	    a[_2ndEleIndex] = a[_1stEleIndex];
	    a[_1stEleIndex] = temp;
	    return a;
	}

}
