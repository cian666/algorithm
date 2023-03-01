package cn.cian.basic;

public class P209_MinSubArr {
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
