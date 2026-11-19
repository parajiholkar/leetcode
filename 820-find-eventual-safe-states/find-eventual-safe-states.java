class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        boolean[] vis = new boolean[graph.length];
        boolean[] safeNodes = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(graph[i].length == 0){
                vis[i] = true;
                safeNodes[i] = true;
            }
        }

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                dfs(graph, vis, i, safeNodes, stack);
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

    public boolean dfs(int[][] graph, boolean[] vis, int curr, boolean[] safeNodes, boolean[] stack){

        if(stack[curr]) return false;

        if(vis[curr]) return safeNodes[curr];

        vis[curr] = true;
        stack[curr] = true;


        int[] adjNode = graph[curr];

        for(int nob: adjNode){

            if(!dfs(graph, vis, nob, safeNodes, stack)){
                stack[nob] = false;
                return false;
            }

        }

        safeNodes[curr] = true;
        stack[curr] = false;

        return true;
    }
}