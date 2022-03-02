package com.vivek.ds;

public class MinSparseMatrix {
	
	//matrix table to store the data
	private int dp[][];
	//max log value based on n
	private static int P;
	//total num of data 
	private static int n;
	// log2 array for each item;
	private int log2[];
	
	public static void main(String args []) {
		int [] data = {10, 1, 34, 2, -1, 15, 5, 20, 100, -3};
		MinSparseMatrix dp = new MinSparseMatrix(data);
		
		
		System.out.println("");
		System.out.println("min: "+dp.findMinInRange(1, 9));
	}
	
	
	public MinSparseMatrix(int[] data) {
		n = data.length;
		System.out.println("n = "+n);
		P = (int) ( Math.log(n) / Math.log(2));
		System.out.println("P = "+P);
		log2 = new int[n];
		
		
		dp = new int[P+1][n];
		for(int i = 0; i < n; i++) {
			dp[0][i] = data[i];
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(" "+dp[0][i]);
		}
		
		
		for(int i = 2; i < n ; i ++) {
			log2[i] = log2[i/2] + 1;
		}
		
		System.out.println("log2: ");
		for(int i = 0; i < n; i++) {
			System.out.print(" "+log2[i]);
		}
		System.out.println("");
		createDPMatrix(dp);
		
		
		System.out.println("dp: ");
		for(int i = 0; i <= P; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(" "+dp[i][j]);
			}
			System.out.println(" ");
		}
     }
	
	private void createDPMatrix(int dp[][]) {
		for(int p = 1; p <= P; p++) {
			for(int i = 0; (i + (1 << p)) <= n; i++) {
				dp[p][i] = Math.min(dp[p-1][i], dp[p-1][i+(1<<(p-1))]);
			}
		}
	}
	
	public int findMinInRange(int a, int b) {
		int min = Integer.MIN_VALUE;
		int len = b - a + 1;
		int p = log2[len];
		min = Math.min(dp[p][a-1], dp[p][b - (1 << p) + 1]);
		return min;
	}
}
