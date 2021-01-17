import java.util.Arrays;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<m+n;i++)
        {
            if(i>(m-1)){
                for(int j=0;j<n;j++){
                    nums1[i]=nums2[j];
                    i++;
                }
            }
        }
        Arrays.sort(nums1);
    }
}
