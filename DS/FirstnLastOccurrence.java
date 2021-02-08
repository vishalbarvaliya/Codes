
public class Main{
    public static void main(String[] args) {
        int[] nums = {1,5,10,10,10,15,20};
        int value = 10;
        
        int firstOc = focSearch(nums, value);
        int lastOc = locSearch(nums, value);
        
        System.out.println("First Occurrence : "+firstOc);
        System.out.println("First Occurrence : "+lastOc);
    }
    static int focSearch(int[] arr, int value) {
        int res = -1;
        int start = 0;
        int end = arr.length-1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == value){
                res = mid;
                end = mid - 1;
            }
            else if (arr[mid] < value)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return res;
    }
    static int locSearch(int[] arr, int value) {
        int res = -1;
        int start = 0;
        int end = arr.length-1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == value){
                res = mid;
                start = mid + 1;
            }
            else if (arr[mid] < value)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return res;
    }
}


        
