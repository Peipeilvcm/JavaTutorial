package oj.swordtooffer;

/**
 * Created by Administrator on 2018/11/23.
 * 旋转数组找最小值
 */
public class STO2_RotateArray {
    public int minNumInRotateAarr(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low < high){
            mid = low + (high - low)/2;
            if(arr[mid] > arr[high]){
                low = mid + 1;
            }else if(arr[mid] == arr[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}
