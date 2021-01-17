class Solution {
    public void duplicateZeros(int[] nums) {
     
       for(int i = 0; i < nums.length - 1 ; i++){
            if(nums[i] == 0){

                for(int j = nums.length - 1 ; j > i; j--){
                    nums[j] = nums[j - 1];
                }

                nums[i + 1] = 0;
                i++;
            }

        }
     }
   
}
