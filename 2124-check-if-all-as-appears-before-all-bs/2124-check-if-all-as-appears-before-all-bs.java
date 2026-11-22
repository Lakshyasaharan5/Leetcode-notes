class Solution {
    public boolean checkString(String s) {
        int firstIndexOfB = s.indexOf('b');
        int lastIndexOfA = s.lastIndexOf('a');
        if (firstIndexOfB == -1 || lastIndexOfA == -1) {
            return true;
        }
        return firstIndexOfB > lastIndexOfA;
    }
}