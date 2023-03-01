package cn.cian.leetcode.basic;

public class P275_HIndex {
    public int hIndex(int[] citations) {
        int l = 0 ,r = citations.length - 1;
        int count = citations.length;
        while(l <= r){
            int mid = l + ( r - l) /2;
            if(citations[mid] < count - mid){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return count - l;
    }
}
