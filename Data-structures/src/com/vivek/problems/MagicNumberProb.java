package com.vivek.problems;

import java.util.*;

public class MagicNumberProb {
	
	public static void main(String args []) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter num:");
		int num = s.nextInt();
		
		int sum = 0;
		
		while(num > 9) {
			while(num > 0) {
				sum += num%10;
				num = num/10;
			}
			num = sum;
			sum = 0;
		}
		
		System.out.println("Is magic num ?: "+ (num == 1));
	}

}
