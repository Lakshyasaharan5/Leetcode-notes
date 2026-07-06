class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int l = 0, r = people.length - 1;
        while (l < r) {
            if (people[l] + people[r] <= limit) {                
                l++;
                r--;
            } else {
                r--;
            }
            boats++;
        }
        if (l == r) boats++;
        return boats;
        /**
            [1,2,2,3] limit = 3
               l
               r
            boats = 3
            [2,2,3,4,5] limit = 5
             l
                     r
            boat = 3
            while l < r {}            
            if (l == r) boat++;
        */
    }
}