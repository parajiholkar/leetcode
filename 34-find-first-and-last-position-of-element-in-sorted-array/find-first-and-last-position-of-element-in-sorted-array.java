class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        ans[0] = binarySearch(nums, target, true);
        if(ans[0] != -1){
            ans[1] = binarySearch(nums, target, false);
        }

        return ans;
    }

    int binarySearch(int[] nums, int target, boolean isFirstPosition){

        int ans = -1;

        int start = 0, end = nums.length - 1;

        while(start<=end){

            int mid = start + ( end - start) / 2;

            if(target < nums[mid]){
                end = mid - 1;
            }else if(target > nums[mid]){
                start = mid + 1;
            }else{
                ans = mid;
                if(isFirstPosition){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}