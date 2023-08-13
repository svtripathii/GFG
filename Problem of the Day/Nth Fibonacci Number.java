//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int nthFibonacci(int n){
        //To avoid redundant calls 
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return fibo(n,dp) % 1000000007;
    }
    
    static int fibo(int n,int[] dp ){
        if(n==0 || n==1){
            return n;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = (fibo(n-1,dp)%1000000007+fibo(n-2,dp)%1000000007)%1000000007;
        return dp[n];
    }
}
