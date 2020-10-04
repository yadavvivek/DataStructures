package com.vivek.algo;

public class MatrixChainMultiplicationDM {
	
	public static void main(String args []) {
		int n = 5;
		int[][] C = new int[n][n];
		int[][] K = new int[n][n];
		int [] dim = {5,4,6,2,7};
		int j, cost, min;
		
		for(int d = 1; d < n-1; d++) {
			for(int i = 1; i < n-d; i ++) {
				j = i + d;
				min = Integer.MAX_VALUE;
				for(int k = i; k < j; k++) {
					cost = C[i][k] + C[k+1][ j] + dim[i-1]*dim[k]*dim[j];
					if(cost < min) {
						K[i][j] = k;
						min = cost;
					}
				}
				C[i][j] = min;
			}
		}
		
		System.out.println("min cost : "+C[1][n-1]+", k : "+K[1][n-1]);
	}

}
