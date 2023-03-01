package cn.cian.utils;

public class Utils {
    public static void main(String[] args) {
        System.out.println("Hello Word");
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(int[] arr){
        System.out.println("==========遍历结果=====================");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("======================================");
    }
}
