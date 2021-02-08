
public class Main{
    public static void main(String[] args) {
        int[] nums = {11,12,15,18,2,5,6,8};
        int count = countRotation(nums);
        count = (count > 0) ? count : 0;
        System.out.println("Rotation : " + count);
        
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

        
