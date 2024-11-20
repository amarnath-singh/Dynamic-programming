class Solution {
    public int solve(int[] arr) {
        int sum = 0;
        int N = arr.length;
        
        for (int i = 0; i < N; i++)
            sum += arr[i];
        
        boolean[][] t = new boolean[N + 1][sum + 1];
        
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) 
                    t[i][j] = false;
                
                
                if (j == 0) 
                    t[i][j] = true;
                else if (arr[i - 1] <= j) 
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
                 else 
                    t[i][j] = t[i - 1][j];
                
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            int first = i;
            int second = sum - i;
            if (t[N][i]== true&& min > Math.abs(first - second)) {
                min = Math.abs(first - second);
            }
        }
        return min;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 6, 4, 8, 4, 8};
        System.out.println(solution.solve(arr));
    }
}
