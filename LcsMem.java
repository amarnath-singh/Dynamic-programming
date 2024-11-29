class LcsMem{
    static int Lcs(String X, String Y,int n,int m,int[][]t){
        if(n==0||m==0) return 0;
        
        if(t[n][m] !=-1) return t[n][m];
        
        if(X.charAt(n-1)==Y.charAt(m-1)){
            return t[n][m] = 1+ Lcs(X,Y,n-1,m-1,t);
            }
        else{
            return t[n][m] = Math.max(Lcs(X,Y,n-1,m,t),
                                      Lcs(X,Y,n,m-1,t));
        }
    }
    
    public static void main(String[] args){
        
        String X = "ABCER";
        String Y = "ABDFG";
        int n= X.length();
        int m= Y.length();
        int [][]t = new int [n+1][m+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                 t[i][j] = -1;
            }
        }
        System.out.println("Number Of Output " + Lcs(X,Y,n,m,t));
    }
}
