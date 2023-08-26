//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int start=0;
        int n=s.length();
        int max=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(map.size()==k){
                max=Math.max(max,i-start+1);
            }
            while(map.size()>k && start<=i){
                if(map.get(s.charAt(start))==1){
                    map.remove(s.charAt(start));
                }
                else{
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                }
                start++;
            }
        }
        return max;
    }
}
