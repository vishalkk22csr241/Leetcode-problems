class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int k=0;
        int[] merg=new int[n+m];
        for(int i=0;i<n;i++)
        {
            merg[k++]=nums1[i];
        }
        for(int i=0;i<m;i++)
        {
            merg[k++]=nums2[i];
        }
        Arrays.sort(merg);
        int tot=merg.length;
        if(tot%2==1)
        {
            return (double)merg[tot/2];
        }
        else
        {
            int m1=merg[tot/2-1];
            int m2=merg[tot/2];
            return ((double)m1+(double)m2)/2.0;
        }
    }
}