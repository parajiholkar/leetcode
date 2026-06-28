class Solution {
    public int maximumWealth(int[][] accounts) {

        int maxWealth = 0;

        for(int i=0; i<accounts.length; i++){
            int cusWealth = 0;
            for(int j=0; j<accounts[i].length; j++){
                cusWealth += accounts[i][j];
            }

            maxWealth = Math.max(maxWealth, cusWealth);
        }
        
        return maxWealth;
    }
}