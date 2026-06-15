class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> ratios = new HashMap<>();
        for (int[] rect : rectangles) {
            int w = rect[0], h = rect[1];
            double ratio = (double)w/h;
            ratios.put(ratio, ratios.getOrDefault(ratio, 0) + 1);
        }
        long res = 0;
        for (int f : ratios.values()) {
            f--;
            if (f > 0)
                res += ((f) * (long)(2 + (f - 1) * 1))/2;
        }
        return res;
    }
}