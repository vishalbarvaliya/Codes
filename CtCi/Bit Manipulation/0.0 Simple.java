public class Main{
    public static int getBits(int n,int pos){
        return ((n & (1<<pos))!=0)?1:0;
    }
    
    public static int setBits(int n,int pos){
        return (n | (1<<pos));
    }
    
    public static int clearBits(int n,int pos){
        int mask= ~(1<<pos);
        return n & mask;
    }
    public static int updateBits(int n,int pos,int bit){
        int mask=~(1<<pos);
        n = n & mask;
        return (n | (bit<<n));
    }
    public static int isPowerOf2(int n){
        if(n==0) return 0;
        return (((n & (n-1)))!=0)?0:1;
      
    }
    public static int countOnes(int n){
        int count=0;
        while(n>0){
            n = (n & n-1);
            count++;
        }
        return count;
    }
    public static void allSubset(int[] arr,int n){
        for(int i=0;i<1<<n;i++){
            for(int j=0;j<n;j++){
             //   if(((int)(i & 1<<j))){
                //    System.out.print(arr[j]+" ");
                //}
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println(countOnes(7));
    }
}
