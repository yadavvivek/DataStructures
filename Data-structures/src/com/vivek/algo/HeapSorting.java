package com.vivek.algo;


//Descending order sorting.........................

public class HeapSorting {
	
	public static void main(String args []) {
		int[] array = {4, 2, 1, 6, 7};
		HeapSorting hs = new HeapSorting();
		int[] a = hs.heapSort(array);
		for(int i : a) 
		System.out.print(" "+i);
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
			
			int smallest = leftChild;
			if(rightChild < arraySize && array[rightChild] < array[smallest]) {
				smallest = rightChild;
			}
			
			if(array[smallest] < array[i]) {
				swap(array, smallest, i);
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
			int smallest = leftChild;
			if(rightChild < size && array[leftChild] > array[rightChild])
				smallest = rightChild;
			swap(array, parent, smallest);
			parent = smallest;
		}
	}

}
