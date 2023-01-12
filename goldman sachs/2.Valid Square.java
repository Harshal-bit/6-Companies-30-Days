//https://leetcode.com/problems/valid-square/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int []arr = new int[6];
        arr[0] = len(p1,p2);
        arr[1] = len(p2,p3);
        arr[2] = len(p3,p4);
        arr[3] = len(p4,p1);
        arr[4] = len(p1,p3);
        arr[5] = len(p2,p4);
        Arrays.sort(arr);
        
        if(arr[5] != arr[4]) return false;
        if(arr[5] != 2*arr[0]) return false;
        if(arr[3] == arr[4]) return false;
        return true;
    }
    int len(int [] p1,int [] p2){
        return (p2[1]-p1[1])*(p2[1]-p1[1])+(p2[0]-p1[0])*(p2[0]-p1[0]);
    }

}
