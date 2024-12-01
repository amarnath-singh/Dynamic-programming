class LcSubstring{
    static int Substring(String X,String Y,int n, int m,int[][]t){
        int maxLength=0;
       for(int i=0;i<n+1;i++){
        for(int j=0;j<m+1;j++){
            t[i][j] = 0;
        }
       }
       for (int i = 1; i < n+1; i++) {
         for (int j = 1; j < m+1; j++) {
        if(X.charAt(n-1)==Y.charAt(m-1)){
            t[i][j]= 1+ t[i-1][j-1];
            maxLength=Math.max(maxLength,t[i][j]);
        }
        else{
            t[i][j]=0;
        }
    }
}
        return maxLength;
    }
        public static void main(String[] args){
            String X ="abcef";
            String Y ="abdcfg";
            int n= X.length();
            int m= Y.length();
            int [][]t= new int[n+1][m+1];
            System.out.println("Number Of Continued Output "+Substring(X, Y, n, m, t));
        }
    }
