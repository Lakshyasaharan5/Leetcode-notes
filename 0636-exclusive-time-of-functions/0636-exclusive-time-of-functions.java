class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[][] stack = new int[logs.size()][3];
        int top = -1;
        int[] result = new int[n];

        for (String func : logs) {
            String[] arr = func.split(":");
            int id = Integer.parseInt(arr[0]);
            int time = Integer.parseInt(arr[2]);
            if (arr[1].equals("start")) {
                stack[++top] = new int[] { id, time, 0 };
            } else {
                int[] currFunc = stack[top--];
                int timeSpent = time - currFunc[1] + 1;
                result[id] += timeSpent + (currFunc[2] != -1 ? -currFunc[2] : 0);
                if (top >= 0) {
                    stack[top][2] += timeSpent;
                }
            }
        }

        return result;
    }
}