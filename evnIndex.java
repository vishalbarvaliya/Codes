class Solution {
    public int findNumbers(int[] nums) {
        int result=0,count=0;
        int temp=0,ex=0;
        for(int i=0;i<nums.length;i++){
            count=0;
            while(nums[i]>0){
                temp=nums[i]%10;
                nums[i]=nums[i]/10;
                count++;
            }
            if(count%2==0)
                ex++;
        }
        return ex;
   }
}
