class LongestReaptingSubsequence {
    static int LRS(String X,int n,int[][]t){
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                t[i][j]=0;
            }
        }
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(X.charAt(i-1)==X.charAt(j-1)&&i!=j){
                t[i][j]=1+t[i-1][j-1];
            }else{
                t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
            }
        }
    }
    return t[n][n];
}
public static void main(String[] args) {
    String X="AABCBEDD";
   
    int n =X.length();
  
    int t[][]=new int[n+1][n+1];
    System.out.println(LRS(X, n, t));
}
}
