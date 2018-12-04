package sort;

/**
 * Created by Administrator on 2018/11/20.
 */
public class MergeSort {
    public static <T extends Comparable<T>> void slove(T[] array, T[] temp, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            slove(array, temp, l, mid);
            slove(array, temp, mid + 1, r);
            merge(array, temp, l, mid, r);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] array, T[] temp, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int k = l;
        while (i <= m && j <= r) {
            if (array[i].compareTo(array[j]) < 0) {
                temp[k] = array[i];
                ++i;
            } else {
                temp[k] = array[j];
                ++j;
            }
            ++k;
        }
        while (j <= r) {
            temp[k] = array[j];
            ++j;
            ++k;
        }
        while (i <= m) {
            temp[k] = array[i];
            ++i;
            ++k;
        }

        for (k = l; k <= r; ++k) {
            array[k] = temp[k];
        }
    }
}
