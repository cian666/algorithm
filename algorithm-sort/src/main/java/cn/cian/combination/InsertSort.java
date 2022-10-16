package cn.cian.combination;

import cn.cian.utils.Utils;

public class InsertSort {
    public void insertSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while(j > 0 && nums[j] < nums[j-1]){
                Utils.swap(nums,j,j-1);
                j--;
            }
        }
    }
}
