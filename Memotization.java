class GfG{
    static int knapSackRec(int W, int[] wt, int[] val, int n, int[][] dp){
         
        if (n == 0 || W == 0)
        return 0;

         if(dp[n][W]!=-1)
            return dp[n][W];
        
       if (wt[n - 1] <=W)
           return dp[n][W]= 
           Math.max(knapSackRec(W-wt[n-1],wt, val,  n - 1)+
                   val[n-1],
           knapSackRec(W,wt, val, n-1,dp));
        
        else 
          return dp[n][W]=knapSackRec(W,wt, val, n -1, dp);
    }
    static int knapSackRec(int W,
     int []wt,
     int []val,
     int N)
    {

        // Declare the table dynamically
        int dp[][] = new int[N + 1][W + 1];

        // Loop to initially filled the
        // table with -1
        for (int i = 0; i < N + 1; i++)
            for (int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        return knapSackRec(W, wt, val, N, dp);
    
        
    }
    public static void main(String[] args) {
        int profit[]= new int[] { 40,21,52,41};
        int weight[]= new int[] { 70,12,32,43};
        int W=50;
        int N=profit.length;
        System.out.println (knapSackRec(W,weight,profit,N));
    }
}