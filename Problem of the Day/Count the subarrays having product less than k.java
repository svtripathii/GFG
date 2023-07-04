//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


class Solution {
    
    public int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        int count = 0;
        long prod = 1;
        int start = 0 ;
        int end = 0;
        for(;end<n;end++){
            prod *= a[end];
            while(start<end && prod>=k){
                prod /= a[start];
                start++;
            }
            if(prod < k)
            count += end - start + 1;
        }
        return count;
    }
}
