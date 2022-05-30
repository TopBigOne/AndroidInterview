package binary_search.search;

import java.util.Arrays;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-15 10:38
 * @Desc : 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] rawData = {12, 4, 6, 2, 7, 1, 3, 8};
        Arrays.sort(rawData);
        System.out.println(" after sort arr:" + Arrays.toString(rawData));
        BinarySearch binarySearch = new BinarySearch();

        int result = binarySearch.search(rawData, 12);

        System.out.println("result:" + result);
    }
    public int search(int [] nums,int target){
        int low = 0;
        int high = nums.length;
        while (low<=high){
            int mid = low+((high-low)>>1);
            int currentValue = nums[mid];
            if(currentValue==target){
                return mid;
            }else if(currentValue<nums[mid]){
                low =mid+1;
            }
            else if(currentValue>target){
                high = mid-1;
            }
        }
        return -1;
    }





}
