class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        boolean[] vis = new boolean[graph.length];
        boolean[] safeNodes = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(graph[i].length == 0){
                vis[i] = true;
                safeNodes[i] = true;
            }
        }

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                dfs(graph, vis, i, safeNodes);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<graph.length; i++){
            if(safeNodes[i]){
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean dfs(int[][] graph, boolean[] vis, int curr, boolean[] safeNodes){
        vis[curr] = true;

        int[] adjNode = graph[curr];

        for(int i=0; i<adjNode.length; i++){

            if(safeNodes[adjNode[i]]) continue;

            if(vis[adjNode[i]]) return false;

            boolean isAdjSafeNode = dfs(graph, vis, adjNode[i], safeNodes);

            if(!isAdjSafeNode) return false;
        }

        safeNodes[curr] = true;

        return true;
    }
}