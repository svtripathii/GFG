//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
#define MAX 1000

// } Driver Code Ends
class Solution
{
    public:
    /*You are required to complete this method*/
    int findK(int a[MAX][MAX],int n,int m,int k)
    {
 		// Your code goes here.
 		int left=0,top=0;
 		int bot=n-1,right=m-1;
 		k--;//k value will be changed ,k is a copy of originl value so in main func. k will have same value
 		while(left<=right && top<=bot){
 		    
 		    for(int i=left;i<=right;i++){
 		        if(k==0){
 		            return a[top][i];
 		        }
 		        k--;
 		    }
 		    top++;
 		    for(int i=top;i<=bot;i++){
 		        if(k==0){
 		            return a[i][right];
 		        }
 		        k--;
 		    }
 		    right--;
 		    for(int i=right;i>=left;i--){
 		        if(k==0){
 		            return a[bot][i];
 		        }
 		        k--;
 		    }
 		    bot--;
 		    for(int i=bot;i>=top;i--){
 		        if(k==0){
 		            return a[i][left];
 		        }
 		        k--;
 		    }
 		    left++;
 		}
 		return -1;
 		
    }
};






//{ Driver Code Starts.
int main()
{
    int T;
    cin>>T;
  
    while(T--)
    {
        int n,m;
        int k=0;
        //cin>>k;
        cin>>n>>m>>k;
        int a[MAX][MAX];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                cin>>a[i][j];
            }
        }
        Solution ob;
        cout<<ob.findK(a,n,m,k)<<endl;
        
       
    }
}
// } Driver Code Ends
