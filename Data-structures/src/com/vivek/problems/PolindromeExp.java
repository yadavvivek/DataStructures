package com.vivek.problems;

import java.util.*;

public class PolindromeExp {
	
	public static void main(String args []) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		System.out.println("Is "+str + " polindrmome ? :"+ isPoli(str));
	}
	
	private static boolean isPoli(String str) {
		int i = 0, j = str.length() -1;
		while(i < j) {
			if(str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}

}
