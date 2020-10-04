package com.vivek.algo;

public class HeapSortingAscending {

	public static void main(String args []) {
		int[] array = {40, 20, 10, 60, 70, 50};
		HeapSortingAscending hs = new HeapSortingAscending();
		int[] a = hs.heapSort(array);
		System.out.println();
		for(int i : a) 
		 System.out.print(" "+i);
		System.out.println();
		System.out.println();
	}
	
	public int[] heapSort(int[] array) {
		heapify(array);
		sort(array);
		return array;
	}
	
	private void heapify(int[] array) {
		int arraySize = array.length;
		for(int i = arraySize - 1; i >= 0; i--) {
			int leftChild = 2*i + 1;
			int rightChild = 2*i + 2;
			
			if(leftChild >= arraySize) continue;
			
			int largest = leftChild;
			if(rightChild < arraySize && array[rightChild] > array[largest]) {
				largest = rightChild;
			}
			
			if(array[largest] > array[i]) {
				swap(array, largest, i);
			}
		}
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private void sort(int[] array) {
		int arraySize = array.length;
		for(int j = arraySize - 1; j >= 0; j--) {
			swap(array, 0, j);
			sink(array, j);
		}
	}
	
	private void sink(int[] array, int size) {
		int parent = 0;
		while(true) {
			int leftChild = 2*parent + 1;
			int rightChild = 2*parent +2;
			if(leftChild >= size) break;
			int largest = leftChild;
			if(rightChild < size && array[leftChild] < array[rightChild])
				largest = rightChild;
			swap(array, parent, largest);
			parent = largest;
		}
	}
}
