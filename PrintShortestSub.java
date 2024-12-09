class PrintShortestSub {
    static int PrintingSS(String X, String Y, int n, int m, int[][] t) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        int lcslength = t[n][m];
        return n + m - lcslength; // Length of Shortest Common Supersequence
    }

    static String PrintingLs(String X, String Y, int n, int m, int[][] t) {
        // Ensure the DP table is correctly filled before constructing the SCS
        PrintingSS(X, Y, n, m, t);

        // Start constructing the Shortest Common Supersequence
        int i = n, j = m;
        StringBuilder scs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                scs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (t[i - 1][j] > t[i][j - 1]) {
                scs.append(X.charAt(i - 1));
                i--;
            } else {
                scs.append(Y.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters from X or Y
        while (i > 0) {
            scs.append(X.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            scs.append(Y.charAt(j - 1));
            j--;
        }

        return scs.reverse().toString();
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int n = X.length();
        int m = Y.length();
        int[][] t = new int[n + 1][m + 1];

        // Get the Shortest Common Supersequence
        String result = PrintingLs(X, Y, n, m, t);
        System.out.println("Shortest Common Supersequence: " + result);

        // Length of the Shortest Common Supersequence
        System.out.println("Length of Shortest Common Supersequence: " + PrintingSS(X, Y, n, m, t));
    }
}
