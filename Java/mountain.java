class Solution {
    public boolean validMountainArray(int[] arr) {
        
        if (arr.length < 3) {
            return false;
        }
                
        boolean peakPass = false;
        int last = arr[0];
        if (last > arr[1]) {
        	return false;
        }
        for (int i = 1; i < arr.length; i++) {
            if (peakPass) {
                if (last <= arr[i]) {
                    return false;
                } else {
                    last = arr[i];
                }
            } else {
                if (last < arr[i]) {
                    last = arr[i];
                } else if (last == arr[i]) {
                    return false;
                } else {
                    last = arr[i];
                    peakPass = true;
                }
            }

        }
        
        return peakPass;
        
    }
}
