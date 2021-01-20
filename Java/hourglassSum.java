public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] nums) {
        int total=-64;
         for(int i=0;i<=3;i++){
         
          for(int j=0;j<=3;j++){
          
              int sum=nums[i][j]+nums[i][j+1]+nums[i][j+2];
              sum+=nums[i+1][j+1];
              sum+=nums[i+2][j]+nums[i+2][j+1]+nums[i+2][j+2];
              
              if(total<sum)
                  total=sum;
          }
            
      } 
  return total;
  }
}
