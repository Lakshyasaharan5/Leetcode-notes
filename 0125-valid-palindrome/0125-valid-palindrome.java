class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !alphaNum(s.charAt(i)))
                i++;

            while (i < j && !alphaNum(s.charAt(j)))
                j--;

            if (lowerCase(s.charAt(i)) != lowerCase(s.charAt(j)))
                return false;

            i++;
            j--;
        }

        return true;
    }

    boolean alphaNum(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }

    char lowerCase(char c) {
        if ('A' <= c && c <= 'Z')
            return (char) (c + 32);
        return c;
    }
}