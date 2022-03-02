package com.vivek.practice;

public class FenwickTree {
	
	public static void main(String args []) {
		int[] values = {0,1,2,3,4,5};
		FenwickTree ft = new FenwickTree(values);
		ft.printFT();
		System.out.println("15: sum[1..5] = "+ft.prefixSum(5));
		System.out.println("sum 3 to 5(12) = "+ft.rangeSum(3, 5));
		ft.add(3, 3);
		ft.printFT();
	}
	
    private int [] tree;
	
	public FenwickTree(int [] values) {
		tree = values.clone();
		
		for(int i = 1; i < values.length; i++) {
			int j = i + lsb(i);
			if(j < values.length)
			    tree[j] += tree[i];
		}
	}
	
	public int prefixSum(int i) {
		int sum = 0;
		while(i != 0) {
			sum += tree[i];
			i -= lsb(i);
		}
		return sum;
	}
	
	public int rangeSum(int i, int j) {
		return prefixSum(j) - prefixSum(i -1);
	}
	
	public void printFT() {
		for(int i = 1; i < tree.length; i++) {
			System.out.print(tree[i]+" ");
		}
	}
	
	
	private int lsb(int i) {
		return i & -i;
	}
	
	private void add(int x, int i) {
		while(i < tree.length) {
			tree[i] += x;
			i = i + lsb(i);
		}
	}

}
