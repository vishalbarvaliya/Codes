class Solution {
    public int removeDuplicates(int[] nums) {
       int len=0;
        int n=nums.length;
        if (n == 0 || n == 1) 
            return n;
        for(int i=0;i<nums.length-1;i++){
           if(nums[i]!=nums[i+1])
               nums[len++]=nums[i];
        }
    nums[len++]=nums[nums.length-1];
    return len;
    }
}
