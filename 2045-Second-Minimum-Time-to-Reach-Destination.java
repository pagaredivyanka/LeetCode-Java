class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] d1 = new int[n+1];
        int[] d2 = new int[n+1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);
        d1[1]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{1,0});
        while(!pq.isEmpty()) {
            int[] curr = pq.remove();
            int node = curr[0];
            int d = curr[1];

            if(node == n && d2[n] != Integer.MAX_VALUE) {
                return d2[n];
            }
            if((d/change)%2==1) {
                d = ((d/change)+1)*change;
            }
            d += time;
            for(int nbr: adj.get(node)) {
                if(d < d1[nbr]) {
                    d2[nbr] = d1[nbr];
                    d1[nbr] = d;
                    pq.add(new int[] {nbr, d});
                } else if(d > d1[nbr] && d < d2[nbr]) {
                    d2[nbr] = d;
                    pq.add(new int[]{nbr, d});
                } 
            }
        }
        return -1;
    }
}
