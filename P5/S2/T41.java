package P5.S2;

import P5.Utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Author ltx
 * @Date 20:24 2020/2/11
 *
 * 数据流中的中位数
 */
public class T41 {

    public static void partition(int[] array, int start, int end) {
        int num = array[start];

        int s = start;
        int e = end;

        while (s < e) {
            while (s < e && array[e] > num) {
                e--;
            }
            while (s < e && array[s] <= num) {
                s++;
            }

            if (s < e) {
                ArrayUtils.swap(array, s, e);
            }
        }

        ArrayUtils.swap(array, start, s);
        if (s == array.length / 2) {
            return;
        } else if (s < array.length / 2) {
            partition(array, s + 1, end);
        } else {
            partition(array, start, s - 1);
        }
    }

    public static int heap(int[] array) {
        int[] maxHeap = new int[array.length/2];
        int[] minHeap = new int[array.length - array.length/2];
        int maxHeapSize = 0;
        int minHeapSize = 0;
        for (int i=0; i<array.length; i++){
            if (i % 2 == 0){
                int num = array[i];
                if (i != 0 && array[i]>minHeap[0]){
                    num = minHeap[0];
                    insertToHeap(minHeap, array[i]);
                }
                insertToHeap(maxHeap, array[i]);
            }else {
                int num = array[i];
                if (array[i] < maxHeap[0]){
                    num = maxHeap[0];
                    insertToHeap(maxHeap, array[i]);
                }
                insertToHeap(minHeap, num);
            }
        }

        if (array.length % 2 == 0){
            return maxHeap[0];
        }

        return (maxHeap[0]+minHeap[0])/2;
    }

    public static void insertToHeap(int[] array, int num){


    }

    public static int getMedian(int[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("array illegal");
        }

        partition(array, 0, array.length - 1);
        int mid = array.length / 2;
        int median = mid % 2 == 0 ? (array[mid - 1] + array[mid]) / 2 : array[mid];

        return median;
    }

    public static void main(String[] args) throws Exception {
        while (true) {

            int[] array = ArrayUtils.getArray(53435, 543223);
            int[] clone = array.clone();
            Arrays.sort(clone);
//            System.out.println(Arrays.toString(array));

            int mid = array.length / 2;
            int median = mid % 2 == 0 ? (clone[mid - 1] + clone[mid]) / 2 : clone[mid];
            int median1 = getMedian(array);

//            System.out.println(Arrays.toString(array));
//            System.out.println(Arrays.toString(clone));
            System.out.println(median);
            System.out.println(median1);
            if (median != median1) {
                System.out.println("fail");
                break;
            }
        }


    }
}
