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
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
       }
       out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] G)
    {
     int row = G.length ;
     int col = G[0].length ;
     int res = fun(G,row,col) ;
     return res ;
    }
    int fun(int [][]G,int row,int col){
        int []match= new int[col] ;
        for(int i = 0 ;i<col ;i++){
            match[i] = -1 ;
        }
        int res = 0 ;
        for(int u = 0 ;u<row ;u++){
            boolean []vis = new boolean[col] ;
            if(bpm(G,u,vis,match,row,col))
            res++ ;
        }
        return res ;
    }
    boolean bpm(int [][]G,int u, boolean []vis , int []match,int row,int col){
        for(int v = 0 ;v<col;v++){
            if(G[u][v]==1 && !vis[v])
            {
                vis[v]= true ;
                if(match[v]<0 || bpm(G,match[v],vis,match,row,col)){
                    match[v]= u ;
                    return true ;
                } 
            }
            
        }
        return false ;
    }
    
}
