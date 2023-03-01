package cn.cian.combination;

import org.junit.Test;

public class BinarySearch {
    @Test
    public void test(){
        int[] arr = {1,2,3,4,5};
        System.out.println(binartSearch2(arr, 1));
    }
    //循环l <=  r  那么结束的时候 就是  l = r +1
    //有两种极端的情况  l = len   r = -1 需要加以注意

    public int binartSearch(int[] arr,int target){
        int l = 0, r = arr.length -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }


    //循环条件 l < r  r初始位nums.length  区间为[l,r)
    //此条件能更好的搜索所有边界。
    public int binartSearch2(int[] arr,int target){
        int l = 0, r = arr.length;
        while(l < r){
            int mid = l + (r - l)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return arr[l] == target? l:-1;
    }
}
