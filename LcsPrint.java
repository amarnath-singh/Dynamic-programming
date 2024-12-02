class LcsPrint{
    static int lcsmemo(String X, String Y, int n, int m,int [][]t){
   if(n==0||m==0){
       return 0;
   }
   if(t[n][m]!=-1){
       return t[n][m];
   }
   if(X.charAt(n-1)==Y.charAt(m-1)){
       t[n][m]= 1+lcsmemo(X,Y,n-1,m-1,t);
   }else{
       t[n][m]=Math.max(lcsmemo(X,Y,n-1,m,t),lcsmemo(X,Y,n,m-1,t));
   }
   return t[n][m];
        
    }
 
 static String PrintingLcs(String X,String Y,int n,int m,int[][]t){
     
     lcsmemo(X,Y,n,m,t);
     
     int i=n;
     int j=m;
     StringBuilder lcs = new StringBuilder();
     
     while(i>0 && j>0){
    if(X.charAt(i-1)==Y.charAt(j-1)){
        lcs.append(X.charAt(i-1));
         i--;
        j--;
    }else if(t[i-1][j]>t[i][j-1]) {
            i--;
            }else{
            j--;
        }
    }
 

    return lcs.reverse().toString();
}
 
 public static void main(String[] args) {
     String X="abcdaf";
     String Y="acbcf";
     int n= X.length();
     int m=Y.length();
     int [][]t= new int[n+1][m+1];
     for(int i=0;i<=n;i++){
    for(int j=0;j<=m;j++){
         t[i][j]=-1;
    }
    }
     System.out.println(PrintingLcs(X,Y,n,m,t));
 }
}
