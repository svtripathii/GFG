class Solution:
    def nBlocks(self, w : int) -> int:
        # code here
        count=0
        while w>0:
            p=0
            while 2**(p+1) <=w:
                p+=1
            count +=1
            w-=2**p
        return count


#{ 
#  Driver Code Starts
if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        w = int(input())
        
        obj = Solution()
        res = obj.nBlocks(w)
        
        print(res)
        

# } Driver Code Ends