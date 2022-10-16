package cn.cian.combination;

public class ShellSort {

    public void shellSort(int[] nums){
        int len = nums.length;
        for (int step = len / 2; step >= 1 ; step = step / 2) {
            for (int i = step; i < len; i += step) {
                int temp = nums[i];
                int j = i - step;
                while(j >= 0 && nums[j] > temp){
                    nums[j+step] = nums[j];
                    j -= step;
                }
                nums[j + step] = temp;
            }
        }
    }
}
