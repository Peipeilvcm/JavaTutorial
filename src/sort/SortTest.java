package sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/11/20.
 */
public class SortTest {
    public static void exec(){
        Integer[] array = {4,3,2,1,6,5,4};
//        QuickSort.slove(array, 0, array.length-1);//quicksort
        Integer[] temp = new Integer[array.length];//mergesort
        try {
            MergeSort.slove(array, temp, 0, array.length - 1);
            System.out.println(Arrays.toString(array));
        } catch (NullPointerException e) {
            //TODO: handle exception
            System.out.println(e.toString());
        }
    }
}
