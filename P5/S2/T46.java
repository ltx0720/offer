package P5.S2;

import java.util.Arrays;

/**
 * @Author ltx
 * @Date 15:10 2020/2/12
 *
 * 把数字翻译成字符串
 */
public class T46 {

    private static int getNum(int num){
        if (num < 0){
            return 0;
        }

      return getNum(Integer.toString(num));
    }
    //f(n) = f(n-1)+a[n] || f(n-2)+a[n]a[n-1]
    private static int getNum(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        if (str.length() == 1){
            return 1;
        }

        int[] result = new int[str.length()];
        int end = str.length()-1;
        result[end] = 1;
        result[end-1] = 1;
        if (str.charAt(end-1) <= '2'){
            result[end-1] = 2;
        }

        //从后往前计算，避免重复计算
        for (int i=end-2; i>=0; i--){
            int n1 = 0, n2 = 0;
            if (i<end){
                n1 = result[i+1];
            }

            if (str.charAt(i) <= '2'){
                n2 = result[i+2];
            }

            result[i] = n1 + n2;
        }

        System.out.println(Arrays.toString(result));
        return result[0];
    }


    public static void main(String[] args) {
        System.out.println(getNum(123121212));
    }
}
