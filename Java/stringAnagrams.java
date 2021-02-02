static boolean isAnagram(String a, String b) {
        //not work in some test case (i,e:xyxy,xywz)
       /* if(a.length()!=b.length()){
            return false;
        }
        long count=0;
        a=a.toLowerCase();
        b=b.toLowerCase();
        for(int i=0;i<a.length();i++){
            count+=a.charAt(i);
        }
        for(int i=0;i<b.length();i++){
            count-=b.charAt(i);
        }
        if(count==0){
            return true;
        }else{
            return false;
        }*/
        
        //another way
        if (a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        int sum = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i=0; i<a.length(); i++) {
                if (a.charAt(i) == c) {
                    sum++;
                }
                if (b.charAt(i) == c) {
                    sum--;
                }
            }
            if (sum != 0) {
                return false;
            }
        }
        return true;
    }
