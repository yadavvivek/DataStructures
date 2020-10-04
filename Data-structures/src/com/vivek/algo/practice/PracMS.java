package com.vivek.algo.practice;

import com.vivek.algo.MergeSort;
import java.util.*;

public class PracMS {
	
	public static void main(String args []) {
		MergeSort ms = new MergeSort();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(7);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);
		list2.add(10);
		list2.add(12);
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(ms.mergeSort(list1, list2));
		
		int[] arr1 = {1, 3, 5, 7, 9, 11};
		int[] arr2 = {2, 4, 6};
		
		
		int[] result = ms.mergeArray(arr1, arr2);
		for(int i = 0; i < result.length ; i++) {
			System.out.print(result[i]+ " - ");
		}
		System.out.println();
		int [] arr = {3, 1, 4, 2, 100, 99, 98, 32, 33, 0, 1};
		
		ms.mergeSortAlgo(arr, 0, arr.length-1);
		int[] mrSort = ms.getSortedArray();
		for(int i = 0; i < mrSort.length; i++)
			System.out.print(mrSort[i]+" > ");
		
	}

}
