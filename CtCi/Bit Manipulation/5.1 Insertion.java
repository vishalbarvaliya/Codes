// "static void main" must be defined in a public class.
public class Main {
    public static int setMintoN(int n,int m ,int j,int i){
      /*  int mask=n>>i;
        return (mask | m)<<i;*/
        //suppose i=2,j=4,n=100000001,m=111
        //8 bits
        int ones=~0;//11111111--
        int left=ones<<(j+1);//11100000
        int right=((1<<i)-1);//00000011
        int mask=left | right;//11100011
        int clear=n&mask;//100000000
        int addm=m<<i;//00011100
        
        return clear | addm;//100011100
        
    }
    public static void main(String[] args) {
        System.out.println(setMintoN(257,7,4,2));
    }
}
