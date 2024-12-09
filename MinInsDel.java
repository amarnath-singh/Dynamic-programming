class MinInsDel {
    static int Findlcs(String X, String Y, int n, int m,int[][]t){
        
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
    static void MiniInserDel(String X, String Y) {
      
        int n=X.length();
        int m=Y.length();
        int [][]t =new int[n+1][m+1];
        int lcsLL= Findlcs(X, Y, n, m, t);
        int Insertion =n-lcsLL; //Insertions =  𝑚− LCS length m−LCS length: Add characters from Y not in the LCS to X
        int Deletion=m-lcsLL;// Deletions = 𝑛− LCS length n−LCS length: Remove characters in X not in the LCS
        System.out.println("Number Of Insertion "+Insertion);
        System.out.println("Number Of Deletion "+ Deletion);
        
    } 
    public static void main(String[] args) {
        String X="heap";
        String Y="pea";
        MiniInserDel(X, Y);
    }
    }
    