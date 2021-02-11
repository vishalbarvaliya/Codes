class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int start = weights[0];
        int end = 0;
        int n = weights.length;
        int res = -1;
        if(n < D)
            return -1;
        for(int i = 0; i < n; i++) {
            end = end + weights[i];
            if(start < weights[i])
                start = weights[i];
        }
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(isValid(weights, n, D, mid) == true){
                res = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return res;
    }
    static boolean isValid(int[] arr, int n, int D, int mid) {
        int day = 1;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if(sum > mid){
                day++;
                sum = arr[i];
            }            
            if(day > D)
                return false;                    
        }
        return true;
    }
}
