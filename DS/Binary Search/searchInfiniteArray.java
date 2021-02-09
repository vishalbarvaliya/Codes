public class Main {
    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 7;
        int index = findel(arr, target);
        System.out.println(index);
    }
    static int findel(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while(target > arr[end]){
            start = end;
            end *= 2;
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid])
                return mid;
            else if(target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
