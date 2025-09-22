class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int len = logs.size();
        int[] idStack = new int[len];
        int[] startStack = new int[len];
        int[] childStack = new int[len];
        int top = -1;
        int[] result = new int[n];

        for (String log : logs) {
            // manual parse: id:type:time
            int first = log.indexOf(':');
            int second = log.indexOf(':', first + 1);

            int id = fastParse(log, 0, first);
            boolean isStart = log.charAt(first + 1) == 's'; // "start"
            int time = fastParse(log, second + 1, log.length());

            if (isStart) {
                ++top;
                idStack[top] = id;
                startStack[top] = time;
                childStack[top] = 0;
            } else {
                int total = time - startStack[top] + 1;
                result[idStack[top]] += total - childStack[top];
                if (top > 0) childStack[top - 1] += total;
                --top;
            }
        }
        return result;
    }

    private int fastParse(String s, int start, int end) {
        int val = 0;
        for (int i = start; i < end; i++) {
            val = val * 10 + (s.charAt(i) - '0');
        }
        return val;
    }
}
