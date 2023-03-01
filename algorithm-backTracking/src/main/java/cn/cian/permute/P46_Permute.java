package cn.cian.permute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P46_Permute {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path  = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return res;
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtracking(nums,used);
            path.removeLast();
            used[i] = false;
        }
    }
}
