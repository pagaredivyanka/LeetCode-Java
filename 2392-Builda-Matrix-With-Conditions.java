class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, Set<Integer>> rG = new HashMap<>();
        Map<Integer, Set<Integer>> cG = new HashMap<>();
        int[] rIndegree = new int[k];
        int[] cIndegree = new int[k];

        for (int i = 1; i <= k; i++) {
            rG.put(i, new HashSet<>());
            cG.put(i, new HashSet<>());
        }

        for (int[] c : rowConditions) {
            int x = c[0];
            int y = c[1];
            if(rG.get(x).add(y)) {
                rIndegree[y-1]++;
            }
        }

        for (int[] c : colConditions) {
            int x = c[0];
            int y = c[1];
            if(cG.get(x).add(y)) {
                cIndegree[y-1]++;
            }
        }

        List<Integer> rO = topologicalSort(k, rG, rIndegree);
        if(rO.size() != k) {
            return new int[0][0];
        }

        List<Integer> cO = topologicalSort(k, cG, cIndegree);
        if(cO.size() != k) {
            return new int[0][0];
        }

        int[][] res = new int[k][k];
        Map<Integer, Integer> cLocs = new HashMap<>();
        for(int i = 0; i < cO.size(); i++) {
            cLocs.put(cO.get(i), i);
        }

        for (int i = 0; i < rO.size(); i++) {
            res[i][cLocs.get(rO.get(i))] = rO.get(i);
        }
        
        return res;
    }

    private List<Integer> topologicalSort(int k, Map<Integer, Set<Integer>> graph, int[] indegrees) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> bfs = new LinkedList<>();

        for(int i = 0; i < k; i++) {
            if(indegrees[i] == 0) {
                bfs.add(i + 1);
            }
        } 

        while (!bfs.isEmpty()) {
            int node = bfs.poll();
            order.add(node);
            for (int child : graph.get(node)) {
                indegrees[child -1]--;
                if (indegrees[child - 1] == 0) {
                    bfs.add(child);
                }
            }
        }
        return order;
    }
}
