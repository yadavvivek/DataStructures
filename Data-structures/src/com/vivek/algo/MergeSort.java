package com.vivek.algo;

import java.util.*;

public class MergeSort {
	
	private int[] mArr;
	
	public List<Integer> mergeSort(List<Integer> list1, List<Integer> list2) {
		
		int i = 0;
		int j = 0;
		List<Integer> resultList = new ArrayList<Integer>();
		
		while(i < list1.size() && j < list2.size()) {
			if(list1.get(i) < list2.get(j)) {
				resultList.add(list1.get(i++));
			} else {
				resultList.add(list2.get(j++));
			}
		}
		
		for(; i < list1.size(); i++) {
			resultList.add(list1.get(i));
		}
		
		for(; j < list2.size(); j++) {
			resultList.add(list2.get(j));
		}
		
		return resultList;
	}
	
	public int[] mergeArray(int[] arr1, int[] arr2) {
		int[] resultArray = new int[arr1.length + arr2.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] < arr2[j]) {
				resultArray[k++] = arr1[i++];
			} else {
				resultArray[k++] = arr2[j++];
			}
		}
		
		for(; i < arr1.length; i++) {
			resultArray[k++] = arr1[i];
		}
		
		for(; j < arr2.length; j++) {
			resultArray[k++] = arr1[j];
		}
		
		return resultArray;
 	}
	
	
	public void mergeSortAlgo(int[] arr, int l, int h) {
		if(l < h) {
			int mid = (l + h)/2;
			mergeSortAlgo(arr, l, mid);
			mergeSortAlgo(arr, mid+1, h);
			mergeSort(arr, l, mid, h);
		}
	}
	
	private void mergeSort(int[] arr, int l, int mid, int h) {
		int i = l;
		int j = mid + 1;
		int k = l;
		int[] resultArr = new int[arr.length];
		while(i <= mid && j <= h) {
			if(arr[i] < arr[j]) {
				resultArr[k++] = arr[i++];
			} else {
				resultArr[k++] = arr[j++];
			}
		}
		
		for(; i <= mid; i++) {
			resultArr[k++] = arr[i];
		}
		
		for(; j <= h; j++) {
			resultArr[k++] = arr[j];
		}
		for(int x = l; x <= h; x++) {
			arr[x] = resultArr[x];
		}
		mArr = arr;
	}
	
	public int[] getSortedArray() {
		return mArr;
	}

}
