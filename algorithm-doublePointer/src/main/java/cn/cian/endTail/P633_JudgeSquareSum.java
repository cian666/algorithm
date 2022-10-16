package cn.cian.endTail;

import org.junit.Test;

public class P633_JudgeSquareSum {

    @Test
    public void test(){
        judgeSquareSum(4);
    }
    public boolean judgeSquareSum(int c) {
        long l = 0, r = (long) Math.sqrt(c);
        while(l <= r){
            long res = l*l + r*r;
            if(res ==  c){
                break;
            }
            if(res < c){
                l++;
            }else {
                r--;
            }
        }
        return l <= r;
    }
}
