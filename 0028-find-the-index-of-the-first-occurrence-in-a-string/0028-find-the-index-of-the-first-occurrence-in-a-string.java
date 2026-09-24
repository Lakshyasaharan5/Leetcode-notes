class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length())
            return -1;
        
        // spadbutsakdsad  res_index=10
        //              ^
        // sad
        //   ^
        
        // mississippi  res_index=1
        //      ^    
        // issip
        //     ^    
        int itr_hay=0;
        int itr_need=0;
        int res_index=-1;
        while(itr_hay<haystack.length()){
            if(haystack.charAt(itr_hay)==needle.charAt(itr_need)){
                if(itr_need==0){
                    res_index=itr_hay;
                }
                if(itr_need==needle.length()-1){
                    return res_index;
                }
                itr_hay++;
                itr_need++;
            }else{
                if(itr_need>0){
                    itr_need=0;    
                    itr_hay=res_index+1;
                }else{    
                    itr_hay++;
                }
                res_index=-1;              
            }
        }
        return -1;
    }
}