package P5.S3;

import P5.Utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Author LTX
 * @Date 17:11 2020/2/13
 *
 * 数组中的逆序对
 */
public class T51 {

    private static int n = 0;

    public static int getDescNum(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }

        if (array.length == 2) {
             sort(array);
        }

        partition(array, 0, array.length - 1);

        return n;
    }

    public static int[] partition(int[] array, int start, int end) {
        if (end - start <= 1) {
            return Arrays.copyOfRange(array, start, end + 1);
        }

        int mid = (start + end) / 2;
        int[] array1 = partition(array, start, mid);
        int[] array2 = partition(array, mid + 1, end);

        sort(array1);
        sort(array2);

        return merge(array1, array2);
    }

    public static int[] merge(int[] array1, int[] array2) {
        int end1 = array1.length - 1;
        int end2 = array2.length - 1;
        int[] array = new int[array1.length + array2.length];
        int index = array.length - 1;

        while (end1 >= 0 && end2 >= 0) {
            if (array1[end1] > array2[end2]) {
                n = n + end2 + 1;
                array[index--] = array1[end1--];
            } else {
                array[index--] = array2[end2--];
            }
        }

        while (end1 >= 0) {
            array[index--] = array1[end1--];
        }
        while (end2 >= 0) {
            array[index--] = array2[end2--];
        }

        return array;
    }

    public static int[] sort(int[] array) {
        int start = 0;
        int end = array.length - 1;

        if (start == end) {
            return array;
        }

        if (array[start] > array[end]) {
            ArrayUtils.swap(array, start, end);
            n++;
        }

        return array;
    }

    public static void main(String[] args) {

        int[] array = new int[]{4,5,3,2,1};

        getDescNum(array);

        System.out.println(n);

    }
}
