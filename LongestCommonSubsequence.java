public class LongestCommonSubsequence {

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int LCSComputation(String x, String y) {
        int m = x.length();
        int n = y.length();

 
        int[][] LCS = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    LCS[i][j] = 0;
                else if (x.charAt(i - 1) == y.charAt(j - 1))
                    LCS[i][j] = 1 + LCS[i - 1][j - 1];
                else
                    LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1]);
            }
        }

        return LCS[m][n];
    }

    public static void main(String[] args) {
        String x = "ABCBDAB";
        String y = "BDCAB";
        
        int lcsLength = LCSComputation(x, y);
        System.out.println("Length of Longest Common Subsequence: " + lcsLength);
    }
}


