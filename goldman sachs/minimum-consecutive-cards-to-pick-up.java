//https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //map to get last index of a[i]
        int minDistance=Integer.MAX_VALUE;
        
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                minDistance = Math.min(minDistance,(i-map.get(cards[i])));
            }
               map.put(cards[i],i);
        }
        return  minDistance ==  Integer.MAX_VALUE ? -1:minDistance+1;


    }
}

