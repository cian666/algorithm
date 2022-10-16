package cn.cian.linear;

import org.junit.Test;

import java.util.*;


public class P313_NthSuperUglyNumber {
    @Test
    public void test(){
        int[] arr = {2,7,13,19};
        System.out.println(nthSuperUglyNumber1(12, arr));
    }

    public int nthSuperUglyNumber1(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n-- > 0) {
            int x = q.poll();
            if (n == 0) return x;
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) q.add(k * x);
                System.out.print(k*x+" ");
                if (x % k == 0) break;
            }
        }
        return -1; // never
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int[] point = new int[primes.length];
        for (int i = 0; i < point.length; i++) {
            point[i] = 1;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < primes.length; i++) {
            queue.add(new int[]{primes[i],i,i});
        }
        for (int i = 2; i <= n; i++) {
            int[] peek = queue.peek();
            dp[i] = peek[0];
            System.out.print(dp[i]+" ");
            while(queue.peek()[0] == peek[0]){
                int[] poll = queue.poll();
                point[poll[1]]++;
                queue.add( new int[]{dp[point[poll[1]]] * primes[poll[2]],poll[1],poll[2]} );
            }
        }
        return dp[n];
    }

}
