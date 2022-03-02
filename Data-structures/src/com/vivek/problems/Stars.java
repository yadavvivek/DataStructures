package com.vivek.problems;

public class Stars {
	public static void main(String args []) {
		int layer = 4;
		for(int i = layer-1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			int stars = layer-i;
			for(int k = 0; k < stars; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
   }
}