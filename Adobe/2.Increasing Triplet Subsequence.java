//https://leetcode.com/problems/increasing-triplet-subsequence/description/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int firstNum = Integer.MAX_VALUE, secondNum = Integer.MAX_VALUE;
        for(int num:nums){
            if(num <=firstNum) firstNum = num;
            else if (num <= secondNum) secondNum = num;
            else return true;
        }

        return false;
    }
}
