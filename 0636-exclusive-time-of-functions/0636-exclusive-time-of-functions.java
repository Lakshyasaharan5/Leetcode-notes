class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int len = logs.size();
        int[] idStack = new int[len];
        int[] startStack = new int[len];
        int[] childStack = new int[len];
        int top = -1;

        int[] result = new int[n];

        for (String log : logs) {
            int first = log.indexOf(':');
            int second = log.indexOf(':', first + 1);

            int id = Integer.parseInt(log.substring(0, first));
            String type = log.substring(first + 1, second);
            int time = Integer.parseInt(log.substring(second + 1));

            if (type.equals("start")) {
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
}
