package cn.cian.two;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class P340_LengthOfLongestSubstringKDistinct {
    @Test
    public void test(){
        String s = "aaacb";
        System.out.println(lengthOfLongestSubstringKDistinct(2, s));
    }

    public int lengthOfLongestSubstringKDistinct(int k,String s){
        int l = 0, r = 0, count = 0,ans = 1;
        int[] arr = new int[256];
        Arrays.fill(arr,0);
        while(r < s.length()){
            if(arr[s.charAt(r)] == 0){
                count++;
            }
            arr[s.charAt(r)]++;
            while(count > k){
                count -= --arr[s.charAt(l++)] == 0? 1:0;
            }
            ans = Math.max(r - l + 1,ans);
            r++;
        }
        return ans;
    }

    public int lengthOfLongestSubstringKDistinct02(int k,String s){
        int start = 0,max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size() > k){
                char left = s.charAt(start);
                map.put(left,map.get(left)-1);
                if(map.get(left) == 0){
                    map.remove(left);
                }
                start++;
            }
            max = Math.max(max,end - start + 1);
        }
        return max;
    }
}
