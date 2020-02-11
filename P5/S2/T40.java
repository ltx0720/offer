package P5.S2;

import P5.Utils.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ltx
 * @Date 17:27 2020/2/10
 *
 * 最小的k个数
 */
public class T40 {

    public static int[] getMinNums(int[] array, int k) throws Exception {
        if (array==null || array.length==0){
            throw new Exception("array illegal");
        }

        if (k <=0){
            return new int[]{};
        }

        if (k >= array.length){
            return array;
        }

        return partition(array, k, 0, array.length-1);
    }
    public static int[] partition(int[] array, int k, int start, int end){

        int num = array[start];
        int s = start;
        int e = end;

        while (s < e){
            while (s < e && array[e] > num){
                e--;
            }

            while (s < e && array[s] <= num){
                s++;
            }

            if (s < e){
                ArrayUtils.swap(array, s, e);
            }
        }

        ArrayUtils.swap(array, s, start);

        if (s == k-1){
            return Arrays.copyOf(array, k);
        }else if (s < k-1){
            return partition(array, k, s+1, end);
        }else {
            return partition(array, k, start, s-1);
        }
    }


    public static int[] heapGetMinNums(int[] array, int k) throws Exception {
        if (array==null || array.length==0){
            throw new Exception("array illegal");
        }
        if (k <=0){
            return new int[]{};
        }

        if (k >= array.length){
            return array;
        }

        int[] result = new int[k];
        for (int i=0; i<k; i++){
            result[i] = array[i];
        }
        buildHeap(result);
//0, 16, 15, 4, 12, 9, 10, 10, 2, 17
        for (int i=k; i<array.length; i++){
           if (array[i] < result[0]) {
               result[0] = array[i];
               adjustHeap(result, 0);
            }
        }

        return result;
    }

    public static void adjustHeap(int[] array, int start){
        int n = start;
        //调整堆
        while (n < array.length){
            int maxNumIndex = n;
            int left = n*2+1;
            int right = n*2+2;

            if (left < array.length){
                maxNumIndex = array[n]>array[left]?n:left;
            }
            if (right < array.length){
                maxNumIndex = array[right]>array[maxNumIndex]?right:maxNumIndex;
            }

            if (maxNumIndex == n){
                break;
            }
            ArrayUtils.swap(array, n, maxNumIndex);

            n = maxNumIndex;
        }
    }

    public static void buildHeap(int[] array){
        for (int i=(array.length)/2-1; i>=0 ;i--){
            adjustHeap(array, i);
        }
    }



    public static void main(String[] args) throws Exception {
        while (true){
            int[] array = ArrayUtils.getArray(100, 200);
//            array = new int[]{0, 16, 15, 4, 12, 9, 10, 10, 2, 17};
            int k = new Random().nextInt(array.length);
//             k = 8;
            int[] ints = heapGetMinNums(array, k);
            System.out.println(Arrays.toString(ints));

            if (!ArrayUtils.isMinNums(ints, array, k)){
                System.out.println(Arrays.toString(ints));
                System.out.println("fail");
                break;
            }
        }

    }
}
