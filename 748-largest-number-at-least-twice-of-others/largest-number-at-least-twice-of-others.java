class Solution {
    public int dominantIndex(int[] nums) {

        int maxIndex = 0, maxNum = nums[0];

        for(int i=0; i<nums.length; i++){
            if(nums[i] > maxNum){
                maxNum = nums[i];
                maxIndex = i;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(maxNum != nums[i] && maxNum < nums[i] * 2){
                return -1;
            }
        }

        return maxIndex;
    }
}