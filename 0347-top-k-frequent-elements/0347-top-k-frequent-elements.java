class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create a freq map
        // sort based on values
        // get the top k into result array
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        for (int i=0; i<k; i++){
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}