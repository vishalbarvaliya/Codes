class Solution {
    public int search(int[] arr, int target) {
        int index = countRotation(arr);
        int left = bSearch(arr,0,index - 1, target);
        int right = bSearch(arr, index, arr.length-1, target);
        /* if(right > 0){
            return right;
        }else
            return left;*/
         return Math.max(left,right);
    }
    static int bSearch(int[] arr, int start, int end,int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            else if (arr[mid] < target){
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return -1;
    }
   
    static int countRotation(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        
        while(start <= end){
            if(arr[start] <= arr[end])
                return start;
            int mid = start + (end - start) / 2;
            int prev = (mid + (arr.length-1)) % arr.length;
            int next = (mid + 1) % arr.length;
            
            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){
                 //return arr.length-mid;
                return mid;
            }
            if (arr[start] <= arr[mid])
                start = mid + 1;
            else if(arr[end] >= arr[mid])
                end = mid - 1;
               
        }
        return -1;
    }
}
//optimized code
static int circulerSearch(int[] arr,int target){
    int low = 0;
    int high = arr.length-1;
    while(start <= end){
        int mid = start + (end - start) / 2;
        
        //case 1
        if(arr[mid] == target){
            return mid;
        }
        
        //case 2 
        if(arr[mid] <= arr[end]){
            if(x >= arr[mid] && x < arr[end]) {
                start = mid + 1;    
            } else {
                end = mid - 1;
            }    
        }
        else{ // case 3
            if(x < arr[mid] && x >= arr[low]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
    return -1;
}
