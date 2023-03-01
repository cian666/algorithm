package cn.cian.two;

import org.junit.Test;

public class P209_MinSubArrayLen {
    @Test
    public void test(){
        int[] arr = {2, 3, 1, 2, 4, 3};
        minSubArrayLen(7,arr);
    }
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0,r = 0,sum = 0,min = Integer.MAX_VALUE;
        while(r < nums.length){
            sum += nums[r++];
            while(sum >= target){
                min = Math.min(r-l,min);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE? 0:min;
    }
}
