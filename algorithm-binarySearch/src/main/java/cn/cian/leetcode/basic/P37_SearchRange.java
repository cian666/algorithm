package cn.cian.leetcode.basic;

public class P37_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = serchLeft(nums,target);
        int right = serchRight(nums,target);
        if(left >= nums.length || right < 0 || nums[left] != target || nums[right]!= target)
            return new int[]{-1,-1};
        return new int[]{left,right};
    }
    // l = r + 1
    private int serchRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while(l <= r){
            mid = l + (r - l)/2;
            if(nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return r;
    }

    private int serchLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while(l <= r){
            mid = l + (r - l)/2;
            if(nums[mid] >= target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}
