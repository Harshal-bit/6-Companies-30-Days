//https://leetcode.com/problems/number-of-boomerangs/description/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int res = 0;
        for(int [] i:points){
            map.clear();
            for(int [] j :points){
                if(i == j ) continue;
                int d = getDistance(i,j);
                int size = map.getOrDefault(d,0);
                res+=size*2;
                map.put(d,size+1);
            }
        }
        return res;

    }
    private int getDistance(int[] point1, int[] point2){
        return (point1[0]-point2[0])*(point1[0]-point2[0]) + (point1[1]-point2[1])*(point1[1]-point2[1]);
    }
}
