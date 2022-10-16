package cn.cian.combination;

import cn.cian.utils.Utils;

public class HeapSort {
    public void HeapSort(int[] nums){
        int len = nums.length;
        for (int i = len/2 -1; i >=0 ; i--){
            heapify(nums,i,len);
        }
        while(len > 0){
            Utils.swap(nums,0,--len);
            heapify(nums,0,len);
        }
    }
    public void heapInsert(int[] arr,int index){
        while(arr[index] > arr[(index - 1)/2]){
            Utils.swap(arr,index,(index-1)/2);
            index = (index-1) / 2;
        }
    }
    private void heapify(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && nums[left] < nums[left + 1] ? left+1:left;
            int largestIndex = nums[largest] > nums[index]? largest:index;
            if(largestIndex == index){
                break;
            }
            Utils.swap(nums,largestIndex,index);
            index = largestIndex;
            left = index * 2 + 1;
        }
    }
}
