package P5.S2;

import P5.Utils.ArrayUtils;

/**
 * @Author ltx
 * @Date 16:42 2020/2/10
 *
 * 数组中出现次数超过一半的数字
 */
public class T39 {

    public static int partition(int[] array) throws Exception {

        if (array.length==0 || array==null){
            throw new Exception("array illegal");
        }

        int num = partition(array, 0, array.length - 1);

        if (!isMoreThanHalf(array, num)){
            throw new Exception("no value");
        }

        return num;
    }
    private static int partition(int[] array, int start, int end){

        int num = array[start];
        int s = start;
        int e = end;

        while (s < e){
            while (num < array[e] && s < e){
                e--;
            }

            while (num >= array[s] && s < e){
                s++;
            }

            if (s < e){
                ArrayUtils.swap(array, e, s);
            }
        }

        ArrayUtils.swap(array, start, s);

        if (s == array.length/2){
            return array[s];
        }else if (s < array.length/2){
            return partition(array, s+1, end);
        }else {
            return partition(array, start, s-1);
        }
    }

    public static boolean isMoreThanHalf(int[] array, int num){
        int n = 0;
        int index = 0;
        while (index < array.length){
            if (array[index] == num){
                n++;
            }
            index++;
        }

        return n>array.length/2;
    }

    public static void main(String[] args) {
        int[] array = new int[]{21,4,54,1,1,1,1};

        try {
            System.out.println(partition(array));
        } catch (Exception e) {
            System.out.println("fail");
            e.printStackTrace();
        }
    }
}
