package cn.cian.combination;

import cn.cian.utils.Utils;

public class SelectSort {
    //选择排序是不稳定的
    public void selectionSort(int[] nums){
        int minIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if(nums[j] < nums[minIndex])
                    minIndex = j;
            }
            Utils.swap(nums,i,minIndex);
        }
    }
}
