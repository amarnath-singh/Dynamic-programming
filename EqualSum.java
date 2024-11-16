class Gfg{
    public static Boolean isSubset(int[] arr,int N,int sum){
        if(sum==0){
            return true;
        }
         if(N==0){
            return false;
         }
         
         if(arr[N-1]>sum){
          return isSubset(arr,N-1,sum);
             
         }
             return isSubset(arr,N-1,sum)||
           isSubset(arr,N-1,sum- arr[N-1]);
         }
        public static boolean Equalpartition(int[]arr){
            int sum=0;
            for (int i=0;i<arr.length ;i++ ){ 
            sum=sum+arr[i];
            }
           
            if(sum%2!=0){
            return false;}
            
            return isSubset(arr,arr.length,sum/2);
        }
        public static void main (String[] args) {
            int []arr={7,8,9,6,3};
            if(Equalpartition(arr)){
                System.out.println("true");
            }else{
            System.out.println("false");
        }}
    }
