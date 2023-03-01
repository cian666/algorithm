package cn.cian.combination;

import cn.cian.utils.Utils;
import org.junit.Test;

public class BubleSort {
    public static void main(String[] args) {
        System.out.println("Hello Word");
    }

    @Test
    public void test(){
        int[] arr = {2,6,8,1,3,6,4,7};
        bubleSort(arr);
        Utils.print(arr);
    }

    /*
    * 核心思想：基于比较交换，每趟选择最大的放在最后。
    * 时间复杂度： 平均O(n^2) 最坏：O(n^2) 最好O(n)
    * */
    public void bubleSort(int[] arr){
        int flag = 0;
        int n = arr.length-1;
        for (int i = n; i > 0; i--) {
            //交换标志：如果此趟没有发生任何交换，则结束。
            flag = 0;
            for (int j = 0; j < n; j++) {
                if(arr[j+1] < arr[j]){
                    Utils.swap(arr,j,j+1);
                    flag = 1;
                }
            }
            if(flag == 0)
                break;
        }
    }
}
