class Solution {
    public static void main (String[] args) {
        int[] arr = {1,2,4,8,10,13,20};
        int target = 12;
        System.out.println(minDifference(arr, target));
    }
    public static int minDifference(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == arr[mid]) 
                return arr[mid];
            else if(target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }       
        return (Math.abs(arr[start] - target) > Math.abs(arr[end] - target))?arr[end]:arr[start];
    }
}
