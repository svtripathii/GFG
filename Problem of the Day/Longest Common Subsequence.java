//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //recursive
    static int solve(int i,int j,String s1,String s2,int n,int m){
        if(i>=n || j>=m)return 0;
        
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+solve(i+1,j+1,s1,s2,n,m);
        }else{
            ans=Math.max(solve(i+1,j,s1,s2,n,m),solve(i,j+1,s1,s2,n,m));
        }
        
        return ans;
    }
    //DP
    static int solve_DP(int i,int j,int[][] dp,String s1,String s2,int n,int m){
        if(i>=n || j>=m)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+solve_DP(i+1,j+1,dp,s1,s2,n,m);
        }else{
            ans=Math.max(solve_DP(i+1,j,dp,s1,s2,n,m),solve_DP(i,j+1,dp,s1,s2,n,m));
        }
        
        return dp[i][j]=ans;
    }
    //Bottom UP dp
    static int solve_Tab(int n, int m, String s1, String s2){
        int[][] dp=new int[n+1][m+1];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int ans=0;
                if(s1.charAt(i)==s2.charAt(j)){
                    ans=1+dp[i+1][j+1];
                }else{
                    ans=Math.max(dp[i+1][j],dp[i][j+1]);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }
    //Space optimazation
    static int solve_Space(int n1, int n2, String a, String b){
        //space complexity is min(n,m);
        int[] currRow = new int[n2 + 1];
        int[] nextRow = new int[n2 + 1];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int ans = 0;

                if (a.charAt(i) == b.charAt(j))
                    ans = 1 + nextRow[j + 1];
                else
                    ans = Math.max(nextRow[j], currRow[j + 1]);

                currRow[j] = ans;
            }

            System.arraycopy(currRow, 0, nextRow, 0, n2 + 1);
        }

        return nextRow[0];
    }
    static int lcs(int n, int m, String s1, String s2)
    {
        // recursive
        //return solve(0,0,s1,s2,n,m);
        
        //DP
        // int[][] dp=new int[n][m];
        // for(int[] d:dp)Arrays.fill(d,-1);
        // return solve_DP(0,0,dp,s1,s2,n,m);
        
        //Bottom UP
        // return solve_Tab(n,m,s1,s2);
        
        //space optimize
        return solve_Space(n,m,s1,s2);
        
    }
    
}
