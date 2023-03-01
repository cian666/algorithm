package cn.cian.leetcode;

public class LC04_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 1){
            return getK(nums1,nums2,len/2);
        }
        return (getK(nums1,nums2,len/2) + getK(nums1,nums2,len/2-1))/2.0;
    }
    public int getK(int[] nums1, int[] nums2,int k){
        int n1 = 0, n2 = 0;
        while(n1 < nums1.length && n2 < nums2.length){
            if(n1 + n2 == k)
                return nums1[n1] < nums2[n2]? nums1[n1]:nums2[n2];
            int i = nums1[n1] < nums2[n2] ? n1++ : n2++;
        }
        if(n1 < nums1.length)
            return nums1[k-nums2.length];
        else
            return nums2[k-nums1.length];
    }
}
