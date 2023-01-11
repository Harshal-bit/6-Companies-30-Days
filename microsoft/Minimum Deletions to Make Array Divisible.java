// https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        
        
        int gcd=numsDivide[0];
        for(int i=1; i < numsDivide.length;i++){
            if(numsDivide[i] == numsDivide[i-1]) continue;
            gcd=gcd(gcd,numsDivide[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(gcd%nums[i] == 0) return i;
        }
        return -1;

    }
    private int gcd(int num1,int num2){ 
        if(num1<num2) return gcd(num2,num1);
        if(num2 == 0) return num1;
        return gcd(num2,num1%num2);
    }
}
