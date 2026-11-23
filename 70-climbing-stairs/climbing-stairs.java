class Solution {
    public int climbStairs(int n) {

        int[] dp = new int[n+1];

        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }

        return climbDP(n, dp);
    }

    public int climbDP(int n, int[] dp){
        if(n==1 || n==2 || n==3) return n;

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = climbDP(n-1, dp) + climbDP(n-2, dp);
    }
}