    static void countSwaps(int[] a) {
        int numSwaps=0;
        int lastElmt=0,firstElmt=0;
        boolean flag=true;
        
        while(flag){
            flag=false;
            for(int i=0;i<a.length-1;i++){
                if(a[i]>a[i+1]){
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    numSwaps++;
                    flag=true;
                }
      }
  }
