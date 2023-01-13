class Solution {
    public int maxPoints(int[][] points) {
        int totalPoints = points.length;
        int max = 0;
        Set<String> set = new HashSet<>();
        if(totalPoints <= 2) return totalPoints;  
        for(int i = 0;i<=totalPoints-2;i++){
            int [] point1 = points[i];
            
            Set<String> temp = new HashSet<>();
            
            HashMap<String,Integer> map = new HashMap<>();
            
            for(int j = i+1;j<=totalPoints-1;j++){
                int [] point2 = points[j];
                String key = lineGenerator(point1,point2);
                // System.out.println("x1 :"+point1[0]+" y1 :"+point1[1]);
                // System.out.println("x2 :"+point2[0]+" y2 :"+point2[1]);
                // System.out.println(key);

                if(set.contains(key)) continue;
                if(map.containsKey(key)) {
                    map.put(key,map.get(key)+1);
                } else {
                    map.put(key,2);
                }
                max=Math.max(max,map.get(key));
                temp.add(key);
            }
            set = temp;
           //System.out.println("");
        }
        return max;
    }
    private String lineGenerator(int [] arr1,int [] arr2){
        int xdiff = arr2[0]-arr1[0];
        int ydiff = arr2[1]-arr1[1];

        if(xdiff == 0) return "mINFc"+(double)arr1[0]; // when slope is infinity
        if(ydiff == 0) return "m0"+(double)arr1[1]; // when slope is zero
        float m = (float)ydiff/xdiff;
        float c = arr1[1]-m*arr1[0];
        return "m"+m+"c"+c;

    }
}
