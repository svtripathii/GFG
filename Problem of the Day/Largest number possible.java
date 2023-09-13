//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
//Edge cases 
        if(9*N < S || S == 0 && N > 1) return "-1";
//Declaring StringBuilder 
        StringBuilder sb = new StringBuilder();

//if S is of single digit then first digit should be equal to S rest all would be zero
        if(S <= 9){
            sb.append(S);
            for(int i = 2; i <= N; i++){
                sb.append(0);
            }
            return sb.toString();
        }
//else
//in order to get maximum number 9 should be added firstly
//then the remainder obtained
// then rest would be zero
        int d = S/9;
        int r = S%9;
        while(d!=0){
            sb.append(9);
            d--;
            N--;
        }
        if(N>0){
            sb.append(r);
            N--;
        }
        while(N>0){
            sb.append(0);
            N--;
        }
        return sb.toString();
    }
}
