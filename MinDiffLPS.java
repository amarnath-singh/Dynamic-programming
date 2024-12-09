class MinDiffLPS {
    static int LPS(String X,String Y ,int n,int m,int[][]t){
        for(int i=0;i<=n;i++){
           for(int j=0;j<=m;j++){
               if(i==0||j==0){
                   t[i][j]=0;
               }
           }
        }
 for(int i=1;i<=n;i++){
   for(int j=1;j<=m;j++){
       if(X.charAt(i-1)==Y.charAt(j-1)){
           t[i][j]=1+t[i-1][j-1];
       }else{
           t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
       }
   }
 }
 return t[n][m];
}
public static void main(String[] args) {
   String X="agbcba";
   String Y= new StringBuilder(X).reverse().toString();
   int n = X.length();
   int m= Y.length();
   int[][]t= new int[n+1][m+1];
   int Delete = X.length()-LPS(X, Y, n, m, t);
   System.out.println(Delete);
}
}


