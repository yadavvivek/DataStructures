package com.vivek.algo;

public class MergeSorting {

	public static void main(String args[]) {

		int[] arr = { 6, 2, 10, 4, 7, 3, 1, 9, 5, 8, 11, 13, 12 };

		MergeSorting ms = new MergeSorting();
		ms.mergeSort(arr, 0, arr.length - 1);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
	}
	
	private void mergeSort(int[] arr, int l, int h) {
		if(l<h) {
			int mid = (l+h)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, h);
			merge(arr, l, h);
		}
	}
	
	private void merge(int arr[], int l, int h) {
		int mid = (l+h)/2;
		
		int i = l, j = mid+1, k = 0;
		int [] tempArr = new int[h+1];
		
		while(i <= mid && j <= h) {
			if(arr[i] < arr[j]) {
				tempArr[k++] = arr[i++];
			} else {
				tempArr[k++] = arr[j++];
			}
		}
		
		while(i <= mid) {
			tempArr[k++] = arr[i++];
		}
		
		while(j <= h) {
			tempArr[k++] = arr[j++];
		}
		
		int z = 0;
		for(int x = l; x <= h; x++) {
		    arr[x] = tempArr[z];
		    z++;
		}
	}
}
