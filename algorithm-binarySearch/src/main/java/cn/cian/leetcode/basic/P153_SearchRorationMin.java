package cn.cian.leetcode.basic;

public class P153_SearchRorationMin {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] >= nums[r]){
                l = mid +1;
            }else {
                r = mid;
            }
        }
        return nums[r];
    }
}
