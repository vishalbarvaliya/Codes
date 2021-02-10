 public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - k;
        List<Integer> list = new ArrayList<>();
        while(start < end) {
                int mid = start + (end - start) / 2;
                if(x > arr[mid]){
                        if(x - arr[mid] > arr[mid + k] - x){
                                start = mid + 1;
                        }
                        else
                                end = mid;
                } else {
                        end = mid;
                }        
        }
        int index = start;
        while (k != 0){
                list.add(arr[index++]);
                k--;
        }
               
        return list;
}
