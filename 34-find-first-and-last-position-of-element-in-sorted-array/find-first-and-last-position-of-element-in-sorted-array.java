class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        int first = binarySearch(nums, target, true);
        int second = binarySearch(nums, target, false);

        ans[0] = first;
        ans[1] = second;

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