package com.vivek.problems;
import java.util.*;

public class ProblemSummation {

	public static void main(String args[]) {
		ProblemSummation ps = new ProblemSummation();
		int [] arr = {4,3,10,9,8};
		ps.minSubsequence(arr);
	}

	public List<Integer> minSubsequence(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		int pointer = nums.length - 1;
		List<Integer> result = new ArrayList<>();
		result.add(nums[pointer]);
		int seqSum = nums[pointer];
		for (int i = pointer - 1; i >= 0; i--) {
			sum += nums[i];
			if (sum > seqSum || sum == seqSum) {
				result.add(nums[--pointer]);
				seqSum += nums[pointer];
				i = pointer;
				sum = 0;
			}
		}
		return result;
	}
}
