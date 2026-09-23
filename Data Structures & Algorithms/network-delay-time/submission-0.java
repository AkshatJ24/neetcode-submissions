class Solution {
    static class Pair{
        int node;
        int time;
        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            int t = curr.time;
            if(dist[u] < t) continue;

            for(Pair nei : adj.get(u)){
                int v = nei.node;
                int w = nei.time;
                if(dist[v] > dist[u] + w){
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }

        int maxT = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxT = Math.max(maxT, dist[i]);
        }

        return maxT;
    }
}