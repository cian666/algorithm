package cn.cian.dijkstra;

import org.junit.Test;

import java.util.Arrays;

public class P743_NetworkDelayTime {
    @Test
    public void test(){
        int[][] arr =  {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(arr, 4, 2));

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dis = new int[n];
        int[][] graph = new int[n ][n];
        boolean[] visted = new boolean[n ];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i],Integer.MAX_VALUE/2);
        }
        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }
        for (int i = 0; i < times.length; i++) {
            graph[times[i][0]-1][times[i][1]-1] = times[i][2];
        }

        for (int i = 0; i < n; i++) {
            dis[i] = graph[k-1][i];
        }
        visted[k-1] = true;
        for (int i = 0; i < n-1; i++) {
            int min = -1;
            for (int j = 0; j < n; j++) {
                if(!visted[j] && (min == -1 || dis[min] > dis[j])){
                    min = j;
                }
            }
            visted[min] = true;
            for (int j = 0; j < n; j++) {
                dis[j] = Math.min(dis[j], dis[min] + graph[min][j]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(dis[i],max);
        }
        return max == Integer.MAX_VALUE? -1:max;
    }

    public int networkDelayTime2(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

}
