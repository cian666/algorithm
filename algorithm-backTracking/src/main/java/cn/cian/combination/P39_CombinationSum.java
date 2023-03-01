package cn.cian.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P39_CombinationSum {

    List<List<Integer>> res  = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,0,target);
        return res;
    }

    private void backtracking(int[] candidates, int satrt,int sum) {
        if(sum == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = satrt; i < candidates.length; i++) {
            if(sum - candidates[i] < 0 )
                continue;
            path.addLast(candidates[i]);
            backtracking(candidates,i,sum-candidates[i]);
            path.removeLast();
        }
    }
}
