public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        int size = s.length();
        int count=0,ex=0;
        long rep = n/size;
        long rem = n-(rep*size);
        
        if(size==1 && s.charAt(0)=='a') return n;
        
        for(int i=0;i<size;i++){
          if(s.charAt(i)=='a') ++count;
        }
        
        for(int i=0;i<rem;i++){
          if(s.charAt(i)=='a') ++ex;
        }
        return (rep*count)+ex;
   }
}
   
