package com.vivek.algo;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	
	
	public static void main(String args []) {
		List<Integer> list = new ArrayList<Integer>();//10,11,1,13,
		list.add(0);
		list.add(11);
		list.add(1);
		list.add(13);
		list.add(0);
		list.add(25);
		list.add(3);
		quickSortAlgo(0, list.size(), list);
		System.out.println(list);
	}
	
	
	private static void quickSortAlgo(int l, int h, List<Integer> data) {
		if(l < h) {
			int j = partision(l, h, data);
			quickSortAlgo(l, j, data);
			quickSortAlgo(j+1, h, data);
		}
	}

	private static int partision(int l, int h, List<Integer> data) {
		int i = l;
		int j = h;
		int pivot = data.get(i);
		while (i < j) {
			do {
				i++;
			} while (i < data.size() && data.get(i) <= pivot); 

			do {
				j--;
			} while (data.get(j) > pivot);

			if (i < j) {
				swap(i, j, data);
			}
		}
		swap(l, j, data);
		return j;
	}

	private static void swap(int i, int j, List<Integer> data) {
		int temp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, temp);
	}
}
