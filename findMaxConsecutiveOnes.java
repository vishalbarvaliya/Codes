class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0,temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                cnt=0;
            else{
                cnt++;
                temp=Math.max(temp,cnt);
            }                                
        }
        return temp;
    }
   
}
