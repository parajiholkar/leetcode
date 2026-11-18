public class Solution {

    int m;
    int n;

    int[][] ch = { {0,1}, {1,0}, {0,-1}, {-1, 0} };

    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i < m && j < n;
    }


    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] lev = new int[m][n];
        boolean isFresh = false;
        boolean[][] vis = new boolean[m][n];

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j] == 2){
                    q.add(new Pair<>(i,j));
                    vis[i][j] = true;
                }else if(grid[i][j] == 1){
                    isFresh = true;
                }
            }
        }

        if(!isFresh){
            return 0;
        }

        int ans = 0;

        while(!q.isEmpty()){
            Pair<Integer, Integer> curr = q.remove();

            int i = curr.getKey();   
            int j = curr.getValue();

            for(int[] chs: ch){
                int a = chs[0] + i;
                int b = chs[1] + j;
                if(!isValid(a,b) || grid[a][b] != 1) continue;
                lev[a][b] = lev[i][j] + 1;
                grid[a][b] = 2;
                q.add(new Pair<>(a,b));
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }

                ans = Math.max(ans, lev[i][j]);
            }
        }
        
        return ans;
        
    }
}
