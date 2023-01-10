// https://leetcode.com/problems/largest-divisible-subset/description/

class Solution {
    List<Integer> list = new LinkedList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        generator(nums);
        
        return list;
    }
    private void generator(int [] arr){
        int []dp = new int[arr.length]; // array to store the length of subset ending with arr[i]
        int []prev =  new int[arr.length]; // store the index of previous element
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);

        // Construct dp array with dp[i] representing number of element in 
        // largest divisible subset ending with nums[i]
        int maxindex = 0;
        for(int i = 1;i<arr.length;i++){   
            for(int j=i-1;j>=0;j--){

                if(arr[i]%arr[j] == 0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            
            if(dp[i] > dp[maxindex]) {
                maxindex = i;
            }
        }

        while(maxindex >= 0){
            list.add(arr[maxindex]);
            maxindex = prev[maxindex];
        }
    }


}
