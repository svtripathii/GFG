class Solution {

    static long solve(int N, int K, ArrayList<Long> GeekNum) {
        int n=N-K;

        long sum=0;

        if(N <= K){

            return GeekNum.get(N-1);

        }

        //count intital sum
        for(int i=0; i<K; i++){
            sum=sum+GeekNum.get(i);
        }

        //sliding window
        int low=0;

        for(int i=0; i<n-1; i++){
            //append
            GeekNum.add(sum);

            //subtract from front
            sum=sum-GeekNum.get(low++);

            //calc new sum
            sum=sum+GeekNum.get(GeekNum.size()-1);
        }
        return sum;
    }
}