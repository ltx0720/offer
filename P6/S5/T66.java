package P6.S5;

import java.util.Arrays;

/**
 * @Author LTX
 * @Date 17:07 2020/2/17
 *
 * 构建乘积数组
 */
public class T66 {

    public static int[] getMultiply(int[] array){
        if (array == null || array.length == 0){
            return new int[]{};
        }

        int[] b = new int[array.length];
        int[] c = new int[array.length];
        int[] d = new int[array.length];
        c[0] = 1;
        d[array.length-1] = 1;

        for (int i=1; i<array.length; i++){
            c[i] = c[i-1]*array[i-1];
        }

        for (int i=array.length-2; i>=0; i--){
            d[i] = d[i+1]*array[i+1];
        }

        for (int i=0; i<array.length; i++){
            b[i] = c[i]*d[i];
        }

        return b;
    }

    public static void main(String[] args) {
        int[] ints = {};
        int[] multiply = getMultiply(ints);
        System.out.println(Arrays.toString(multiply));
    }
}
