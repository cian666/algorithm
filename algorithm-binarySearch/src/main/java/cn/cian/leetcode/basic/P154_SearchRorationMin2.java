package cn.cian.leetcode.basic;

public class P154_SearchRorationMin2 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] > nums[r]){
                l = mid +1;
            }else if (nums[mid] < nums[r]){
                r = mid;
            }else {
                r = r -1;
            }
        }
        return nums[r];
    }
}
