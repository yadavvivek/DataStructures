package com.vivek;

import com.vivek.ds.FenwickTree;

public class FenwickTreeTest {
	
	
	public static void main(String args []) {
		long[] values = {0, 1L, 2L, 3L, 4L, 5L};
		FenwickTree ft = new FenwickTree(values);
		
		System.out.println("FT = "+ft);
		System.out.println("FT = "+ft.prefixSum(5));
		ft.add(1, 1L);
		System.out.println("FT = "+ft);
		System.out.println("FT = "+ft.sum(1, 1));
	}
}
