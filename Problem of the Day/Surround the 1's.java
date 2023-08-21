//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for(int i = 0 ; i<n ; i++)
        {
            for(int j = 0 ; j<m ; j++)
            {
                if(matrix[i][j]==1)
                { 
                    int z = countZeros(matrix,i,j) ;
                    if(z != 0 && z%2==0) count++ ;
                }
            }
        }
        return count;
    }
    private int countZeros(int [][] matrix , int r , int c)
    {
        if(matrix[r][c]==0)
        {
            return 0;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        int zeros = 0;
        
        if(r>0 && c>0)
        {
            if(matrix[r-1][c-1]==0) zeros++ ;
        }
        if(r > 0)
        {
            if(matrix[r-1][c]==0) zeros++ ;
        }
        if(r>0 && c<m-1)
        {
            if(matrix[r-1][c+1]==0) zeros++ ;
        }
        
        if(c>0)
        {
            if(matrix[r][c-1]==0) zeros++ ;
        }
        if(c<m-1)
        {
            if(matrix[r][c+1]==0) zeros++ ;
        }
        
        if(r<n-1 && c>0)
        {
            if(matrix[r+1][c-1]==0) zeros++ ;
        }
        if(r<n-1)
        {
            if(matrix[r+1][c]==0) zeros++ ;
        }
        if(r<n-1 && c<m-1)
        {
            if(matrix[r+1][c+1]==0) zeros++ ;
        }
        
        return zeros;
    }
}
