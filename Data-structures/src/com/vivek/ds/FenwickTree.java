package com.vivek.ds;

public class FenwickTree {
	
	long[] tree;
	
	public FenwickTree(int size) {
		tree = new long[size];
	}
	
	public FenwickTree(long[] values) {
		if(values == null) throw new IllegalArgumentException("Values must not be null!");
		
		this.tree = values.clone();
		for(int i = 1; i < tree.length; i++) {
			int j = i + lsb(i);
			if(j < tree.length) tree[j] += tree[i];
		}
	}
	
	public int lsb(int i) {
		return Integer.lowestOneBit(i);
	}
	
	public long prefixSum(int i) {
		if(i > tree.length) throw new IllegalArgumentException();
		long sum = 0L;
		while(i != 0) {
			sum += tree[i];
			i -= lsb(i);
		}
		return sum;
	}
	
	/* Range sum i to j */
	public long sum(int i, int j) {
		if(i > j ) throw new IllegalArgumentException("First argument must be less than the second one!");
		return prefixSum(j) - prefixSum(i-1);
	}
	
	public void add(int i, long k) {
		while(i < tree.length) {
			tree[i] += k;
			i += lsb(i);
		}
	}
	
	public void set(int i, long k) {
		long value = sum(i,i);
		add(i, (k-value));
	}
	
	@Override
	public String toString() {
		return java.util.Arrays.toString(tree);
	}
}
