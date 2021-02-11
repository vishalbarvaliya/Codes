class Solution {
	public static void main (String[] args) {
		int[][] arr = {{10,20,30,40},
		              {15,25,35,40},
		              {27,29,37,45},
		              {32,33,39,50}};
		int m = 4;
		int n = 4;
		int target = 40;
		int[] index = search2DArray(arr, target, n, m);
		System.out.println(index[0] + " " + index[1]);
	}
	static int[] search2DArray(int[][] arr, int target, int n, int m) {
	    int i = 0;
	    int j = m - 1;
	    int[] indices = {-1,-1}
	    
	    while(i >= 0 && i < n && j >= 0 && j < m){
	        if(arr[i][j] == target){
	            indices[0] = i;
	            indices[1] = j;
	            return indices;
	        }
	        else if(arr[i][j] > target){
	            j--;
	        }
	        else
	            i++;
	    }
	    return indices;
	}
}
