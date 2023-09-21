//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{   
    public int FindMaxSum(int arr[], int n)
    {   
        int d1 = 0;
        int d2 = 0;
        
        for(int i = n-1; i>=0; i--){
            int take = arr[i] + d2;
            int notTake = d1;
            
            d2 = d1;
            d1= Math.max(take , notTake);
        }
        return d1;
    }
}
