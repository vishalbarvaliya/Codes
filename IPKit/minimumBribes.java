 static void minimumBribes(int[] q) {
        boolean chaos=false;
        int bribes=0;
        for(int i=0;i<q.length;i++){
            if(q[i]-(i+1)>2) chaos=true;
            for(int j=Math.max(0,q[i]-2);j<i;j++){
                if(q[j]>q[i]) bribes++;
            }
        }
        if(chaos==true) 
            System.out.println("Too chaotic");
        else
            System.out.println(bribes);
        
    }
