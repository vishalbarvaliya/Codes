public class Solution{
    static int  maxSum(int arr[],int n,int k){
        if(n<k) return -1;
        int max_sum=0;
        for(int i=0;i<k;i++)
            max_sum+=arr[i];
        
        int n_sum=max_sum;
        for(int i=k;i<n;i++){
            n_sum+=arr[i]-arr[i-k];
            max_sum=Math.max(max_sum,n_sum);
        }
        return max_sum;
    }
    public static void main(String [] args){
        int[] arr ={1,4,3,6,7,4,5,7};
        int len=arr.length;
        int k=3;
        System.out.println(maxSum(arr,len,k));
    }
    
}
