package cn.cian.combination;

public class QucikSort {
    public void quickSort(int[] nums){
        if(nums.length < 2)
            return;
        process(nums, 0, nums.length - 1);
    }
    public void process(int[] nums,int left,int right){
        if(left < right){
            int index = part(nums,left,right);
            process(nums,left,index-1);
            process(nums,index+1,right);
        }
    }
    public int part(int[] nums,int left,int right){
        int tar = nums[left];
        while(left < right){
            while(left < right && nums[right] > tar){
                right--;
            }
            if(left < right){
                nums[left++] = nums[right];
            }
            while(left < right && nums[left] <= tar){
                left++;
            }
            if(left < right){
                nums[right--] = nums[left];
            }
        }
        nums[left] = tar;
        return left;
    }
}
