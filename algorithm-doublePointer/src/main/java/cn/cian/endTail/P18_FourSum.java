package cn.cian.endTail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length - 2; j++) {
                if(j > i +1 && nums[j] == nums[j-1]) continue;
                int l = j+1, r = nums.length -1;
                while(l < r){
                    long sum = nums[l] + nums[r] + nums[i] + nums[j];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[l], nums[r], nums[i],nums[j]));
                        while(l < r && nums[l+1] == nums[l]) l++;
                        while(l < r && nums[r-1] == nums[r]) r--;
                        l++;
                        r--;
                    }else if(sum < target){
                        l++;
                    }else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
