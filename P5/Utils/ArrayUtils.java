package P5.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ltx
 * @Date 16:45 2020/2/10
 */
public class ArrayUtils {

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    //前k个最小的数
    public static boolean isMinNums(int[] result, int[] oldarray, int k){
        Arrays.sort(oldarray);
        for (int i=0; i<result.length; i++){
            boolean b = false;
            for (int j=0; j<k; j++){
                if (result[i] == oldarray[j]){
                    b = true;
                }
            }
            if (!b){
                return false;
            }
        }
        return true;
    }

    public static int[] getArray(int num, int max){
        Random random = new Random();
        int[] array = new int[num];

        for (int i=0; i<num; i++){
            array[i] = random.nextInt(max);
        }

        return array;
    }


}
