package sort;

/**
 * Created by Administrator on 2018/11/20.
 */
public class Sort {
    public static <T> boolean swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return true;
    }
}
