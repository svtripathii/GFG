//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String arr){
        //code here
        int ans=0,i=0;
        int cntO=0;
        
        for(int j=0;j<n;j++)
        {
            if(arr.charAt(j)=='O') cntO++;
            
            while(i<j && cntO>m)
            {
                if(arr.charAt(i)=='O') cntO--;
                i++;
            }
            
            ans=Math.max(ans,(j-i+1));
        }
        
            return ans;
    }
}
