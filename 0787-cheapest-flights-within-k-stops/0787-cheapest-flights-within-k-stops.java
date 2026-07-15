import java.util.*;

class Solution {
    public int findCheapestPrice(
        int n,
        int[][] flights,
        int src,
        int dst,
        int k
    ) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph[from].add(new int[]{to, price});
        }

        int maxFlights = k + 1;
        int inf = Integer.MAX_VALUE;

        // dist[node][flightsUsed]
        int[][] dist = new int[n][maxFlights + 1];

        for (int[] row : dist) {
            Arrays.fill(row, inf);
        }

        // {cost, node, flightsUsed}
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(state -> state[0]));

        dist[src][0] = 0;
        minHeap.offer(new int[]{0, src, 0});

        while (!minHeap.isEmpty()) {
            int[] state = minHeap.poll();

            int cost = state[0];
            int node = state[1];
            int flightsUsed = state[2];

            if (cost != dist[node][flightsUsed]) {
                continue;
            }

            if (node == dst) {
                return cost;
            }

            if (flightsUsed == maxFlights) {
                continue;
            }

            for (int[] edge : graph[node]) {
                int neighbor = edge[0];
                int price = edge[1];

                int nextCost = cost + price;
                int nextFlightsUsed = flightsUsed + 1;

                if (nextCost < dist[neighbor][nextFlightsUsed]) {
                    dist[neighbor][nextFlightsUsed] = nextCost;

                    minHeap.offer(new int[]{
                        nextCost,
                        neighbor,
                        nextFlightsUsed
                    });
                }
            }
        }

        return -1;
    }
}