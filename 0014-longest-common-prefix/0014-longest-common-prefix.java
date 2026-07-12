class Solution {
    public String longestCommonPrefix(String[] strs) {
        /**
            ["flower","flow","flight"]
                                      ^
            longest = fl

            abc z ac az
            abc abcdz abd abe abf

            ab
            abz 

        */
        Arrays.sort(strs);
        int i = 0;
        String a = strs[0], b = strs[strs.length - 1];
        while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return a.substring(0,i);
    }
}