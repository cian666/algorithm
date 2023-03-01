package cn.cian.basic;

public class P1004_LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0,right = 0;
        int maxCount = 0;
        int countOnes = 0;
        for ( ; right < nums.length; right++){
            if(nums[right] == 1)
                countOnes++;
            if(right - left + 1 - countOnes > k){
                countOnes -= nums[left];
                left++;
            }
            maxCount = Math.max(maxCount,right - left + 1);
        }
        return maxCount;
    }
}
