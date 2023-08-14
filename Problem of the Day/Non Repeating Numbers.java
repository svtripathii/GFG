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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int n = 0;
        
        for(int elem : nums) {
            n = n^elem;
        }
        
        int r = n&-n;
        int a = 0;
        int b = 0;
        
        for(int elem : nums) {
            if((r&elem) == 0) {
                a = a^elem;
            } else {
                b = b^elem;
            }
        }
        int [] arr = {a,b};
        Arrays.sort(arr);
        return arr;
    }
}
