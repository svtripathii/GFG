class Solution {
    public static void convertToWave(int n, int[] arr) {
        // code here
        if(n == 1)
            return;
        else if(n == 2){
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        
        else if(n%2 == 1){
            for(int i = 0; i<n-1; i += 2){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        
        else{
            for(int i = 0; i<n; i += 2){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        
        return;
    }
}
