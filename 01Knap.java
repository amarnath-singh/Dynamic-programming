class GfG {
    // Corrected knapSack method
    static int knapSack(int wt[], int val[], int W, int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If the weight of the nth item is less than or equal to W, 
        // consider including it in the knapsack
        if (wt[n - 1] <= W) {
            return Math.max(
                val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1),
                knapSack(wt, val, W, n - 1)
            );
        } else {
            // If the weight of the nth item is greater than W, don't include it
            return knapSack(wt, val, W, n - 1);
        }
    }

    public static void main(String[] args) {
        int profit[] = new int[] { 40,21,52,41};
        int weight[] = new int[] { 70, 12, 32, 43 };
        int W = 50;  // Capacity of the knapsack
        int n = profit.length;  // Number of items

        System.out.println(knapSack(weight, profit, W, n));
    }
}
