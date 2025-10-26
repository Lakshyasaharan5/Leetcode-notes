class Solution {
    
    public List<List<String>> partition(String s) {
        List<List<String>> finalRes = new ArrayList<>();
        helper(s, 0, new ArrayList<String>(), finalRes);        
        return finalRes;
    }

    public void helper(String s, int start, List<String> currRes, List<List<String>> finalRes){
        if(start>=s.length()){            
            finalRes.add(new ArrayList<>(currRes)); 
            return;
        }
        for(int i=start; i<s.length(); i++){
            String currStr = s.substring(start,i+1);
            if(!isPalindrome(currStr))continue;
            currRes.add(currStr);            
            helper(s, i+1, currRes, finalRes);
            currRes.remove(currRes.size() - 1);
        }
    }

    public boolean isPalindrome(String s){
        int l=0, r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }
}