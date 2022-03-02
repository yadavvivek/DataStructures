package com.vivek.problems;

public class TwiceDigitSum {
	
	public int getTwiceDigitSum(int n) {
		int digitSum = dgSum(n);
		int temp = n + 1;
		
		while(true) {
			int tempDigitSum = dgSum(temp);
			if(tempDigitSum == 2*digitSum) {
				return temp;
			}
			temp++;
		}
	}
	
	private int dgSum(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n%10;
			n = n/10;
		}
		return sum;
	}
	
	public static void main(String args []) {
		TwiceDigitSum tds = new TwiceDigitSum();
		System.out.println("14 -> "+tds.getTwiceDigitSum(14));
		System.out.println("99 -> "+tds.getTwiceDigitSum(99));
		System.out.println("10 -> "+tds.getTwiceDigitSum(10));
	}

}
