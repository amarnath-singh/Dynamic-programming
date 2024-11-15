
class Gfg {
    public Boolean isSubset(int[] arr, int sum, int N) {
        // Initialize DP table
        Boolean[][] t = new Boolean[N + 1][sum + 1];
        
        // Base condition: If sum is 0, subset is always possible (empty subset)
        for (int i = 0; i <= N; i++) {
            t[i][0] = true;
        }
        
        // Base condition: If no elements and sum > 0, subset is not possible
        for (int j = 1; j <= sum; j++) {
            t[0][j] = false;
        }
        
        // Fill DP table
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // Include or exclude the current element
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
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
        int sum = 7;
        int N = arr.length;
        
        if (obj.isSubset(arr, sum, N)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
