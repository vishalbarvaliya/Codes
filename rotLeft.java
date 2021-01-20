static int[] rotLeft(int[] a, int d) {
     int temp=0,i=0;
     //by using new array..
    /* int[] a1=new int[a.length];
    
     for(i=d;i<a.length;i++)
            a1[temp++]=a[i];
            
     for(int j=0;j<d;j++)
            a1[temp++]=a[j];
        
     return a1;*/
     //In-place method(efficient one)
     while(d>0){
            temp=a[0];
            for(i=0;i<a.length-1;i++)
                 a[i]=a[i+1];
            a[i]=temp;
            d--;
        }
       
        return a;
}
