package com.vivek.problems;

public class MatrixRotation {
	
	int[][] dyArr;
	int Imax, Jmax;
	
	public MatrixRotation (int i, int j, int[] arr) {
	   dyArr = new int [i][j]; 
	   Imax = i;
	   Jmax = j;
	   
	   fillData(arr);
	}
	
	private void fillData(int [] arr) {
		int k = arr.length;
		int z = k;
		for(int i = 0; i < Imax; i++) {
			for(int j = 0; j < Jmax; j++) {
				dyArr[i][j] = arr[k-z];
				z--;
			}
		}
	}

	public int[][] getConvertedMatrix() {
		int [][] conArray = new int[Jmax] [Imax];
		/* convert columns into rows like: first column into first row*/
		for(int j = 0; j < Jmax; j++) {
			for(int i = Imax-1; i >=0; i--) {
				conArray [j][Imax-1-i] = dyArr[i][j];
			}
		}
		dyArr = conArray;
		int temp = Imax;
		Imax = Jmax;
		Jmax = temp;
		return dyArr;
	}
	
	public static void main(String args [] ) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		MatrixRotation mr = new MatrixRotation(3, 2, arr);
		System.out.println(" original dynamic arr : "+mr.dyArr.toString() );
		for(int i = 0; i < mr.Imax; i ++) {
			for(int j = 0; j < mr.Jmax; j++) {
				System.out.print(mr.dyArr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("====================================");
		System.out.println(" converted dynamic arr : "+mr.getConvertedMatrix().toString() );
		for(int i = 0; i < mr.Imax; i ++) {
			for(int j = 0; j < mr.Jmax; j++) {
				System.out.print(mr.dyArr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
