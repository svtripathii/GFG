//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {

    int numberOfEnclaves(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        
        for(int i=0;i<n;i++){
                if(grid[i][0]==1) dfs(grid,i,0,n,m);
                if(grid[i][m-1]==1) dfs(grid,i,m-1,n,m);
        }
        
        for(int i=0;i<m;i++){
                if(grid[0][i]==1) dfs(grid,0,i,n,m);
                if(grid[n-1][i]==1) dfs(grid,n-1,i,n,m);
        }
        
        int ans=0;
       for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) ans++;
            }
        }
        return ans;
    }
    
    void dfs(int[][] grid,int row,int col,int n,int m){
        if(row<0 || col<0 || row>=n || col>=m || grid[row][col]==0 || grid[row][col]==-1) return;
        
        grid[row][col]=-1;
        
        dfs(grid,row+1,col,n,m);
        dfs(grid,row-1,col,n,m);
        dfs(grid,row,col+1,n,m);
        dfs(grid,row,col-1,n,m);
        
    }
}
