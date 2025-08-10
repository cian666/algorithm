package cn.cian.endTail;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P15_ThreeSum {


    @Test
    public void test(){
        int[] arr = {-1,0,1,2,-1,-4};
        threeSum(arr);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1, r = nums.length-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    ans.add(list);
                    //去重
                    while(l < r && nums[l+1] == nums[l]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }else if(sum < 0){
                    l++;
                }else {
                    r--;
                }

            }
        }
        return ans;
    }
}
