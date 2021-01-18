class Solution {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = search(arr[i] * 2, arr);
            if (index > -1 && index != i) {
                return true;
            }
        }
        return false;
    }
    
    public static int search(int value, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }
}
