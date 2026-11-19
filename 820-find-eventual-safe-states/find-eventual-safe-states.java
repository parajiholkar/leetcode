class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        boolean[] vis = new boolean[graph.length];
        ArrayList<Integer> safeNodes = new ArrayList<>();

        for(int i=0; i<graph.length; i++){
            if(graph[i].length == 0){
                vis[i] = true;
                safeNodes.add(i);
            }
        }

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                dfs(graph, vis, i, safeNodes);
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }

    public boolean dfs(int[][] graph, boolean[] vis, int curr, ArrayList<Integer> safeNodes){
        vis[curr] = true;

        int[] adjNode = graph[curr];

        for(int i=0; i<adjNode.length; i++){

            if(safeNodes.contains(adjNode[i])) continue;

            if(vis[adjNode[i]]) return false;

            boolean isAdjSafeNode = dfs(graph, vis, adjNode[i], safeNodes);

            if(!isAdjSafeNode) return false;
        }

        safeNodes.add(curr);

        return true;
    }
}