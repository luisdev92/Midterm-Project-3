// Luis Santander
// Assignment: Midterm Project 3
// Professor Nima

public class App {

	// Chained Matrix Multiplication 
	public static int MatrixChainedOrder(int n, int[] d) {
		int[][] dp = new int[n][n]; 
		int i, j, k, L, q; 
		
		for (i = 0; i < n; i++) {
			dp[i][i] = 0; 
		}
		
		for (L = 2; L < n; L++) {
			for (i = 1; i < n - L + 1; i++) {
				j = i + L - 1; 
				
				dp[i][j] = Integer.MAX_VALUE;
				
				for (k = i; k <= j - 1; k++) {
					q = dp[i][k] + dp[k + 1][j] + d[i - 1] * d[k] * d[j];
					
					if (q < dp[i][j])
						dp[i][j] = q; 
				}
			}
		}
		
		return dp[1][n - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 4, 2 ,3 };
		
		int result = MatrixChainedOrder(arr.length, arr); 
		
		
		System.out.print(result);
	}
}
