package cn.cian.combination;

import java.util.ArrayList;
import java.util.HashMap;

public class Structure {
    int n = 10;
    //第一种 二维数组存储
    //适用于边多
    class graphArray{
        int[][] graph = new int[n][n];
        //如果是字母  加一个映射 key为点，v为坐标。
        HashMap<Character,Integer> vex = new HashMap<>();
        //n 定点数
        //e边数
    }


    class Node{
        ArrayList<Integer> next = new ArrayList<>();
    }
    class graphList{
        ArrayList<Node> list = new ArrayList<>();
        HashMap<Node,Integer> vex = new HashMap<>();
    }
}
