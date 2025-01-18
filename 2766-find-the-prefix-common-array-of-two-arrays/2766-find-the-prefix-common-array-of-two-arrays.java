class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set_A = new HashSet<>();
        Set<Integer> set_B = new HashSet<>();
        Set<Integer> set_common = new HashSet<>();

        int[] result = new int[A.length];

        // 2,3,1
        // 3,1,2
        //   i
        // [0, ]
        // A (2,3)
        // B (3,1)
        // common (2,3,1)

        for(int i=0; i<A.length; i++){
            set_A.add(A[i]);
            set_B.add(B[i]);
            set_common.add(A[i]);
            set_common.add(B[i]);
            result[i] = set_A.size() + set_B.size() - set_common.size();
        }

        return result;
    }
}