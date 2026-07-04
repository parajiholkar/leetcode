/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int ans = -1;

        int peak = findpeak(mountainArr, 0, mountainArr.length() - 1);
        ans = binarySearch(mountainArr, 0, peak, target);
        if(ans != -1){
            return ans;
        }

        return binarySearch(mountainArr, peak + 1, mountainArr.length() - 1, target);
        
    }

    int findpeak(MountainArray mountainArr, int start, int end){
        
        while(start<end){
            int mid = start + ( end - start) / 2;

            if(mountainArr.get(mid) > mountainArr.get(mid+1)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }

    int binarySearch(MountainArray mountainArr, int start, int end, int target){

        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);
        
        while(start<=end){
            int mid = start + ( end - start) / 2;

            if(isAsc){
                if(mountainArr.get(mid) > target){
                    end = mid - 1;
                }else if(mountainArr.get(mid) == target){
                    return mid;
                }else{
                    start = mid + 1;
                }
            }else{
                if(mountainArr.get(mid) < target){
                    end = mid - 1;
                }else if(mountainArr.get(mid) == target){
                    return mid;
                }else{
                    start = mid + 1;
                }
            }
        }

        return - 1;
    }
}