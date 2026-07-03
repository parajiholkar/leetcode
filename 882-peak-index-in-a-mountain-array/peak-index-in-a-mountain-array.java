class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        if(arr.length == 0 || arr.length == 1){
            return 0;
        }

        int start = 0, end = arr.length-1;

        while(start<=end){

            int mid = start + ( end - start) / 2;

            if((mid!=0 && arr[mid] > arr[mid-1]) && (mid!=arr.length-1 && arr[mid] > arr[mid+1])){
                return mid;
            }else if(!(mid!=arr.length-1 && arr[mid] < arr[mid+1])){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return end;
    }
}