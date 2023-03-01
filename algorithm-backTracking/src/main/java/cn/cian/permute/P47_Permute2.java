package cn.cian.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P47_Permute2 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        backtracking(nums,flag);
        return res;
    }

    public void backtracking(int[] nums, boolean[] flag) {
        if(path.size() == nums.length){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && flag[i - 1] == false) {
                continue;
            }
            if(!flag[i] ){
                flag[i] = true;
                path.addLast(nums[i]);
                backtracking(nums,flag);
                path.removeLast();
                flag[i] = false;
            }
        }
    }
}
