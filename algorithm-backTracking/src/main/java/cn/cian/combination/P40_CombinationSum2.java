package cn.cian.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P40_CombinationSum2 {
    List<List<Integer>> res  = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] visted = new boolean[candidates.length];
        backtracking(candidates,0,target,visted);
        return res;
    }

    private void backtracking(int[] candidates, int satrt, int sum, boolean[] visted) {
        if(sum == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = satrt; i < candidates.length; i++) {
            if(sum - candidates[i] < 0 )
                continue;
            if(i > 0 && candidates[i] == candidates[i-1] && !visted[i])
                continue;
            visted[i] = true;
            path.addLast(candidates[i]);
            backtracking(candidates,i,sum-candidates[i], visted);
            path.removeLast();
            visted[i] = false;
        }
    }
}
