//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        Queue<Triplet> q=new LinkedList<>();
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        boolean[][] visit=new boolean[N][M];
        q.offer(new Triplet(0,0,0));
        visit[0][0]=true;
        while(!q.isEmpty()){
            Triplet curr=q.poll();
            if(curr.row==X && curr.col==Y) return curr.price;
            for(int i=0;i<4;i++){
                int newRow=curr.row+dx[i];
                int newCol=curr.col+dy[i];
                if(newRow>=0 && newRow<N && newCol>=0 && newCol<M && !visit[newRow][newCol] && A[newRow][newCol]==1){
                    visit[newRow][newCol]=true;
                    q.offer(new Triplet(newRow,newCol,curr.price+1));
                }
            }
        }
        return -1;
    }
    
    class Triplet{
        int row,col,price;
        Triplet(int row,int col,int price){
            this.row=row;
            this.col=col;
            this.price=price;
        }
    }
};
