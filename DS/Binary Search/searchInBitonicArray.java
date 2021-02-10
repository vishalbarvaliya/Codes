class Solution {
    public static void main (String[] args) {
        int[] arr = {9,10,4,3,2};
        int target = 9;
        int res = findElmt(arr, target);
        System.out.println(res);
    }
    
    static int findElmt(int[] arr, int target) {
        int index = findPeakElement(arr);
        int case1 = bSearchAsc(arr,0,index - 1,target);
        int case2 = bSearchDsc(arr,index,arr.length -1, target);
        return Math.max(case1, case2);
    }
    
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
                
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1])
                start = mid + 1;
            else 
                end = mid;
        }
        return start;
    }
    
    static int bSearchAsc(int[] arr, int start, int end, int target) {
        
        while (start <= end) {
            int mid  = start + (end - start) / 2;
            if(arr[mid] == target)
                return mid;
            else if(target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    static int bSearchDsc(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid  = start + (end - start) / 2;
            if(arr[mid] == target)
                return mid;
            else if(target > arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
