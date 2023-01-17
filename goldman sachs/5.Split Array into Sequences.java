//https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
class Solution {
    public boolean isPossible(int[] nums) {
        //keep track of sequences with length more than 3 or equal to
        HashMap<Integer,Integer> vacancy = new HashMap<>();
        //keep track of sequences with length less than 3
        HashMap<Integer,Integer> waiting = new HashMap<>(); 
        for(int i:nums) waiting.put(i,waiting.getOrDefault(i,0)+1);

        for(int i = 0; i<nums.length ;i++){
            if(waiting.getOrDefault(nums[i],0) <= 0) continue;
            else if(vacancy.getOrDefault(nums[i],0) >= 1) {
                waiting.put(nums[i],waiting.getOrDefault(nums[i],0)-1);
                vacancy.put(nums[i],vacancy.get(nums[i])-1);
                vacancy.put(nums[i]+1,vacancy.getOrDefault(nums[i]+1,0)+1);
            } 
            else if( waiting.getOrDefault(nums[i],0) >=1 &&
                     waiting.getOrDefault(nums[i]+1,0) >=1 &&
                     waiting.getOrDefault(nums[i]+2,0) >=1 ){
                
                         waiting.put(nums[i],waiting.getOrDefault(nums[i],0)-1);
                         waiting.put(nums[i]+1,waiting.getOrDefault(nums[i]+1,0)-1);
                         waiting.put(nums[i]+2,waiting.getOrDefault(nums[i]+2,0)-1);
                         vacancy.put(nums[i]+3,vacancy.getOrDefault(nums[i]+3,0)+1);

            } else return false;
        }


    return true;

    }
}



// to hasin bareeshien, just ay yes
