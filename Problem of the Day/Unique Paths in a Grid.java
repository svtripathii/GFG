//User function Template for Java

class Solution {
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        if(grid[0][0] == 0 || grid[n-1][m-1] == 0) return 0;
        long[][] dp = new long[n][m];
        for(long[] temp : dp){
            Arrays.fill(temp,-1);
        }
        long mod = 1000000000+7;
        return (int)(solve(0,0,n,m,grid,dp) % mod);

    }
    public static long solve(int i,int j,int n, int m, int[][] grid,long[][] dp){
        if(i == n-1 && j == m-1) return 1;
        if(i >= n || j >= m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        long count = 0,mod = 1000000000+7;
        if(i+1 < n && grid[i+1][j]==1){
            count += (solve(i+1,j,n,m,grid,dp)%mod);
        }
        if(j+1 < m && grid[i][j+1]==1){
            count += (solve(i,j+1,n,m,grid,dp)%mod);
        }
        return dp[i][j] = count % mod;
        
    }
};