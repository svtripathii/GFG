class Solution{
public:
    int inSequence(int A, int B, int C){
        // code here
        if(C==0) {
            return A==B;
        }
        return (B-A) % C==0 and (B-A)/C>(-1);
    }
};