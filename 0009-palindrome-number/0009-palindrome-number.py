class Solution:
    def reverse(self, n, ans) -> int:
        if(n==0):
            return ans
        
        ans = ans*10 + n%10
        return reverse(n//10, ans)
    
    def isPalindrome(self, x: int) -> bool:
        if x<0:
            return False
        
        rev = 0
        n=x
        while(n>0):
            rev = rev*10 + n%10
            n=n//10
        
        return x==rev