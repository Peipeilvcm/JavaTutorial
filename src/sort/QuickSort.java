package sort;

/**
 * Created by Administrator on 2018/11/20.
 */
public class QuickSort {
    public static <T extends Comparable<T>> int partition(T[] array, int l, int r) {
        T pov = array[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && array[j].compareTo(pov) >= 0) {
                --j;
            }
            Sort.swap(array, i, j);
            while (i < j && array[i].compareTo(pov) <= 0) {
                ++i;
            }
            Sort.swap(array, i, j);
        }
        return i;
    }

    public static <T extends Comparable<T>> void slove(T[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        int k = partition(array, l, r);
        slove(array, l, k - 1);
        slove(array, k + 1, r);
    }

    public static <T extends Comparable<T>> void threeSlove(T[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        T pov = array[l];
        int lt = l - 1;
        int rt = r + 1;

        for (int i = l; i < rt;) {
            if (array[i] == pov) {
                ++i;
            } else if (array[i].compareTo(pov) > 0) {
                --rt;
                Sort.swap(array, i, rt);
            } else {
                ++lt;
                Sort.swap(array, i, lt);
            }
        }

        threeSlove(array, l, lt);
        threeSlove(array, rt, r);
    }
}
