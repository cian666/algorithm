package cn.cian.basic;

import org.junit.Test;

import java.util.LinkedList;

public class J59_MaxSlidingWindow {
    @Test
    public void test(){
        int[] arr = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(arr,3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0)
            return new int[0];
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int l = 0, r = 0;
        while(r < nums.length){
            //先把小于他的移出去
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[r]){
                queue.removeLast();
            }
            queue.addLast(r);
            //把坐标不符合的移出去
            while(!queue.isEmpty() && queue.getFirst() <= r - k){
                queue.removeFirst();
            }
            if(r++ >= k-1){
                ans[l++] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}
