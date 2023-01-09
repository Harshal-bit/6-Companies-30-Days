// https://leetcode.com/problems/combination-sum-iii/
class Solution {
    List<List<Integer>> list = new LinkedList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        generator(1,k,n,new LinkedList<>());
        return list;
    }
    public void generator(int i, int k, int n, LinkedList<Integer> ls){
        if(i>10) return;
        if(k == 0 && n == 0){
            list.add(new LinkedList<>(ls));
        }
        // pick condition
        if(n-i >= 0){
            ls.add(i);
            generator(i+1,k-1,n-i,ls);
            ls.remove(ls.size()-1);
        }
        if(n-i < 0){
            return;
        }
        // non pick condition
        generator(i+1,k,n,ls);

    }
}
