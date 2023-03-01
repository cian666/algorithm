package cn.cian.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P216_CombinationSum3 {

    List<List<Integer>> res  = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(1,k,n);
        return res;
    }
    private void backtracking(int satrt, int k,int sum) {
        if(path.size() > k)
            return;
        if(sum == 0){
            if(path.size() == k){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = satrt; i <= 9 && (10-i) >= (k - path.size()); i++) {
            if(sum - i < 0)
                continue;
            path.addLast(i);
            backtracking(i+1,k,sum - i);
            path.removeLast();
        }
    }
}
