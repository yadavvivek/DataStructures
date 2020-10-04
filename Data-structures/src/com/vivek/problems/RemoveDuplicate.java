package com.vivek.problems;

public class RemoveDuplicate {
	
	public static void main(String args []) {
		Solution1 s = new Solution1();
		int [] nums =  {0,0,1,1,1,2,2,3,3,4};
		s.removeDuplicates(nums);
	}

}

class Solution1 {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        int result = nums.length;
        int temp = 0;
        
        //{0,0,1,1,1,2,2,3,3,4}
        for(int i=0; i < result; i++) {
            if(i==0) {
                temp = nums[i];
                continue;
            } else {
                if(temp == nums[i]) {
                    for(int j = i; j < result - 1; j++) {
                        nums[j] = nums[j+1];
                    }
                    result--;
                    i--;
                } else {
                    temp = nums[i];
                }
            }
        }
        for(int num : nums) {
        	System.out.print(" "+num );
        }
        System.out.println(" result"+result );
        return result;
    }
}