// https://leetcode.com/problems/perfect-rectangle/description/
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<>(); 
        
        double tArea =0; // To Store the sum of areas of each rectangle
        int minx1 = rectangles[0][0]; // least bottom-left x cordinate
        int miny1 = rectangles[0][1]; // least bottom-left y cordinate
        int maxx2 = rectangles[0][2]; // max top-right x cordinate
        int maxy2 = rectangles[0][3]; // max top-right y cordinate
        
        /* 
        using set as a hashmap(kind of)
        the rectangle are overlapping if finally the set contains more than four co-ordinates
        or
        If the area of maxRectagle != the sum of areas of each rectangle
        or
        if the set contains different coordinates than the corners of the rectangle
        */

        for(int [] rect : rectangles){
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];
            minx1 = Math.min(minx1,x1);
            miny1 = Math.min(miny1,y1);
            maxx2 = Math.max(maxx2,x2);
            maxy2 = Math.max(maxy2,y2);
            tArea+=Math.abs((x1-x2)*(y1-y2)*0.5);

            if(!set.add(x1+","+y1)) set.remove(x1+","+y1);
            if(!set.add(x1+","+y2)) set.remove(x1+","+y2);
            if(!set.add(x2+","+y1)) set.remove(x2+","+y1);
            if(!set.add(x2+","+y2)) set.remove(x2+","+y2);
        }

        if(set.size() != 4) return false;
        if(tArea != Math.abs((maxx2-minx1)*(maxy2-miny1)*0.5)) return false;
        if(!set.contains(minx1+","+miny1) || 
           !set.contains(minx1+","+maxy2) || 
           !set.contains(maxx2+","+miny1) ||
           !set.contains(maxx2+","+maxy2)) return false;


        
        return true ;


    }
}
