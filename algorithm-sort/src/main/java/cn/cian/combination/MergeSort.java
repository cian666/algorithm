package cn.cian.combination;

public class MergeSort {
    //递归方式合并
    public static void mergerSort(int[] nums,int left,int right){
        if(left == right)
            return;
        int mid = left + (right - left) / 2;
        mergerSort(nums,left,mid);
        mergerSort(nums,mid+1,right);
        merger(nums,left,mid,right);
    }
    public static void merger(int[] nums, int left, int mid, int right){
        int[] res = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= right)
            res[i++] = nums[p1] <= nums[p2]? nums[p1++]:nums[p2++];
        while (p1 <= mid)
            res[i++] = nums[p1++];
        while (p2 <= right)
            res[i++] = nums[p2++];
        for (int j = 0; j < res.length; j++) {
            nums[left + j] = res[j];
        }
    }
    //非递归方式合并
// 非递归方法实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        // 步长
        int mergeSize = 1;
        while (mergeSize < N) { // log N
            // 当前左组的，第一个位置
            int L = 0;
            while (L < N) {
                if (mergeSize >= N - L) {
                    break;
                }
                int M = L + mergeSize - 1;
                int R = M + Math.min(mergeSize, N - M - 1);
                merger(arr, L, M, R);
                L = R + 1;
            }
            // 防止溢出
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }
}
