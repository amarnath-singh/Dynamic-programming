
class Gfg {
    public int isSubset(int[] arr, int sum, int N) {
        // Initialize DP table
        int t [][] = new int[N + 1][sum + 1];
        
        // Base condition: If sum is 0, subset is always possible (empty subset)
        for (int i = 0; i <= N; i++) {
            t[i][0] = 1;
        }
        
        // Base condition: If no elements and sum > 0, subset is not possible
        for (int j = 1; j <= sum; j++) {
            t[0][j] = 0;
        }
        
        // Fill DP table
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // Include or exclude the current element
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else {
                    // Exclude the current element
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        
        return t[N][sum];
    }

    public static void main(String[] args) {
       Gfg obj= new Gfg();
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 10;
        int N = arr.length;
        System.out.println (obj.isSubset(arr,sum,N));
    }
}
