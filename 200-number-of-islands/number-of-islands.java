class Solution {
    int m;
    int n;

    int ans = 0;

    int[][] moves = { {0,1},{1,0},{0,-1},{-1,0}};

    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<m && j<n;
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    ans += dfs(grid, vis, i, j);
                }
            }
        }

        return ans;
        
    }

    public int dfs(char[][] grid, boolean[][] vis, int i, int j) {

        vis[i][j] = true;

        for(int x=0;x<moves.length; x++){
            int f = moves[x][0] + i;
            int s = moves[x][1] + j;
            if(!isValid(f,s) || grid[f][s] == '0' || vis[f][s]) {
                continue;
            }

            dfs(grid, vis, f, s);
        }

        return 1;
    }
}