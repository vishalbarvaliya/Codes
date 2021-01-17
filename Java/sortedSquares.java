import java.util.Arrays;
class Solution {
    public int[] sortedSquares(int[] nums) {
        int temp=0,ex=0;
        for(int j=0;j<nums.length;j++){
            nums[j]=nums[j]*nums[j];
        }
         Arrays.sort(nums);        
        return nums;
    }
}
