package P6;

import java.util.Arrays;

/**
 * @Author LTX
 * @Date 17:08 2020/2/15
 *
 * 数组中数字出现的次数
 */
public class T56 {


    /**
     * 存在两个不相等的数，异或完肯定不为0，即一定存在某位为 1。
     * 对于这一位来说，这两个不相等的数在这一位上肯定时不一样的，一个为0，一个为1
     * 那么就根据这一位，把数组分开，一部分为这一位上为 1 的，另一部分为0的
     * 分别对这两部分异或，得出结果。
     */
    public static void getNum(int[] array){
        if (array == null || array.length == 0){
            System.out.println("array is illegal");
        }

        int XOR = Arrays.stream(array).reduce((a, b) -> a ^ b).getAsInt();

        //找出异或的结果的第一位1。 XOR= 1010 -> num= 2
        int result = XOR, num = 1;
        while ((result & 1) != 1){
            result = result >> 1;
            num = num << 1;
        }

        int p = 0, q = array.length-1;
        while (p != q){

            while ((array[q] & num) == 0 && p < q){
                q--;
            }
            while ((array[p] & num) != 0 && p < q){
                p++;
            }

            swap(array, p, q);
        }
        int mid = 0;
        if ((array[q] & num) == 0){
            mid = q;
        }else {
            mid = q+1;
        }

        int n1 = Arrays.stream(array).limit(mid).reduce((a, b) -> a ^ b).getAsInt();
        int n2 = n1 ^ XOR;

        System.out.println(n1 +"-"+n2);
    }

    private static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,1,4,2,3,2,3,5};
        getNum(array);
    }
}
