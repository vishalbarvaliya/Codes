
public class Main{
    public static void main(String[] args) {
        int[] arr = {5,10,30,20,40};
        int key = 30;
        int index = nearlySorted(arr,key);
        System.out.println(index);
    }
    static int nearlySorted(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid - 1] >= start && arr[mid - 1] == target)
                return mid - 1;
            else if(arr[mid + 1] <= end && arr[mid + 1] == target)
                return mid + 1;
            
            if(target < arr[mid])
                end = mid - 2;
            else
                start = mid + 2;
        }
        return -1;
    }
}
