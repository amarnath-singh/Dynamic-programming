class Hfh{
    public static int isDiff(int[] arr, int diff){
        int sum=0;
        int N=arr.length;
        for(int i=0;i<N;i++){
            sum = sum+ arr[i];
        }
            if(diff>sum){
                return 0;
            }
            if((diff+sum) % 2!=0){
                return 0;
            }
            int s2 =(diff+sum)/2;
            int [][] t=new int[N+1][s2+1];
            for(int i=0;i<=N;i++){
            t[i][0] =1;
        }
        for(int i=1;i<=N;i++){
        for(int j=0;j<=s2;j++){
        if(arr[i-1]<=j){
            t[i][j]=t[i-1][j]+t[i-1][j-arr[i-1]];
        }else{
        t[i][j]=t[i-1][j];
            } 
            
        }
            
        }       
    return t[N][s2];
    }
    public static void main(String[] args) { // Correct entry point method 
    Hfh obj = new Hfh();
    int[] arr1 = {5, 2, 6, 4};
    int diff1 = 3;
    System.out.println(obj.isDiff(arr1, diff1)); 
    }
    }
    
