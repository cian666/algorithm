package cn.cian.combination;


import cn.cian.utils.Utils;
import org.junit.Test;

import java.util.Arrays;

public class TestSort {

    @Test
    public void test(){
        BubleSort bubleSort = new BubleSort();
        ShellSort shellSort = new ShellSort();
        //QucikSort qucikSort = new QucikSort();
        int len = 100;
        int max = 1000;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int[] arr2 = copy(arr);
            bubleSort.bubleSort(arr);
            shellSort.shellSort(arr2);
            if (!compare(arr,arr2)) {
                Utils.print(arr);
                Utils.print(arr2);
                System.out.println("oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }

    private boolean compare(int[] arr, int[] arr2) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != arr2[i])
                return false;
        }
        return true;
    }

    private int[] copy(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }


}
