package cn.cian.endTail;

import org.junit.Test;

import java.util.Arrays;

public class P611_TriangleNumber {
    @Test
    public void test(){
        int[] arr = {4,2,3,4};
        System.out.println(triangleNumber(arr));
    }
    /**
     双指针
     * */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n-2; i++) {
            int k = i;
            for (int j = i+1; j < n-1; j++) {
                while(k +1 < n && nums[k+1] < nums[i] + nums[j]){
                    k++;
                }
                ans += Math.max(k - j,0);
            }
        }
        return ans;
    }
    /**
     排序+二分
     * */
    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                int target = nums[j] + nums[i];
                int id = binarySearch(nums,target,j+1,n-1);
                ans +=  id - j;
            }
        }
        return ans;

    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] < target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return r;
    }
}
