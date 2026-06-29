class Solution {
    public int removeElement(int[] nums, int val) {

        if(nums.length==0){
            return 0;
        }

        if(nums.length == 1 && nums[0]==val){
            return 0;
        }

        int i=0, j=nums.length -1;
        int count = 0;

        while(i<=j){
            if(nums[j]==val){
                j--;
                count++;
            }else{
                if(nums[i]==val){
                    nums[i] = nums[j];
                    j--;
                    count++;
                }
                i++;
            }
        }

        return nums.length - count;
        
    }
}