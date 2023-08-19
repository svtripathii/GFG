class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> al = new ArrayList<>();
        int temp1 = 1; 
        int i = 0;
        int sum = 0;
        for( ; i<n; i++) {
            sum += arr[i];
            while(sum > s && s > 0) {
                sum -= arr[temp1-1];
                temp1 +=1;
            }
            
            if(sum == s) {
                al.add(temp1);
                al.add(i+1);
              return al;
            }
        }
        
        if(al.size() == 0) al.add(-1);
      return al;
    }
}
