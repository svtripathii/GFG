class Solution:
    def missingNumber(self,array,n):
        # code here
        array.sort()
        for i in range(n-1):
            if array[i]!=i+1:
                return i+1
        return n    
#{ 
 # Driver Code Starts
#Initial Template for Python 3




t=int(input())
for _ in range(0,t):
    n=int(input())
    a=list(map(int,input().split()))
    s=Solution().missingNumber(a,n)
    print(s)
