//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE; //To store minimum outOfPlace element
        int max = Integer.MIN_VALUE; //To store maximum outOfPlace element

        int len = nums.length;

        for(int i=0;i<len;i++){
            int left = (i==0) ? Integer.MIN_VALUE:nums[i-1]; 
            int right = (i==len-1) ? Integer.MAX_VALUE:nums[i+1]; 

            if(nums[i] < left || nums[i] > right) {
                min = Math.min(min,nums[i]);
                max = Math.max(max,nums[i]);
            }
        }
        if(min==Integer.MAX_VALUE && max == Integer.MIN_VALUE) return 0;
        int i=0;
        for(;i<len;++i)
            if(nums[i]>min)
                break;
        
        int j=len-1;
        for(;j>=0;--j)
            if(nums[j]<max)
                break;

        return j-i+1;
    }
}
/* 
1 2 3 3 3
1 3 2 2 2

*/
