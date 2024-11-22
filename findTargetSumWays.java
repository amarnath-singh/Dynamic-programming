class Solution {
    public int findTargetSumWays(int[] arr, int diff) {
        int N=arr.length;
        int sum=0;
        for(int i=0;i<N;i++){
            sum+= arr[i];
        }
        if(diff > sum||(diff + sum) % 2 !=0){
            return 0;
        }
         int s2 = (sum + diff) / 2;
         int[][] t= new int [N+1][s2+1];
        for(int i=0;i<=N;i++){
           t[i][0]=1;
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
public static void main(String[]args){
    Solution obj =new Solution();

    int[] arr1={1,1,1,1,1};
    int target1=3;
    
    System.out.println(obj.findTargetSumWays(arr1,target1));

    int[] arr2 ={1};

    int target2 =1;
    
    System.out.println(obj.findTargetSumWays(arr2,target2));
}}
