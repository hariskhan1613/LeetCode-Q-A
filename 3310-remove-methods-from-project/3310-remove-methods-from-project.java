class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        
        for (int[] inv : invocations) {
            graph[inv[0]].add(inv[1]);
        }
        
        boolean[] isSuspicious = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        isSuspicious[k] = true;
        
        List<Integer> suspiciousList = new ArrayList<>();
        suspiciousList.add(k);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                if (!isSuspicious[next]) {
                    isSuspicious[next] = true;
                    queue.offer(next);
                    suspiciousList.add(next);
                }
            }
        }
        boolean isValidRemoval = true;
        for (int[] inv : invocations) {
            int u = inv[0], v = inv[1];
            if (!isSuspicious[u] && isSuspicious[v]) {
                isValidRemoval = false;
                break;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isValidRemoval || !isSuspicious[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}
