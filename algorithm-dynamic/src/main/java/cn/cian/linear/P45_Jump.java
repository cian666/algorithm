package cn.cian.linear;

public class P45_Jump {
    public int jump(int[] nums) {
        int next = 0;
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(next < i){
                ans++;
                next = cur;
            }
            cur = Math.max(nums[i]+i,cur);
        }
        return ans;
    }
}
