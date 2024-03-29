//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);
        for(int i=0;i<n;i++)
        {
            int sum=0-arr[i];
            int l=i+1,r=n-1;
            while(l<r)
            {
                if(arr[l]+arr[r]>sum)
                r--;
                else
                if(arr[l]+arr[r]<sum)
                l++;
                else
                if(arr[l]+arr[r]==sum)
                    return true;
            }
        }
        return false;
        //add code here.
    }
}
