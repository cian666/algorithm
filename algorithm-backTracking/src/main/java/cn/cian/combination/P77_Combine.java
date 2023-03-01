package cn.cian.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P77_Combine {

    List<List<Integer>> res  = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(1,k,n);
        return res;
    }

    private void backtracking(int satrt, int k,int end) {
        if(path.size() == k){
            ArrayList<Integer> list = new ArrayList<>(path);
            res.add(list);
            return;
        }
        for (int i = satrt; i <= end && (end-i+1) >= (k - path.size()); i++) {
            path.addLast(i);
            backtracking(i+1,k,end);
            path.removeLast();
        }
    }
}
