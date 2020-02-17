package P6.S5;

/**
 * @Author LTX
 * @Date 17:16 2020/2/17
 *
 * 不用加减乘除做加法
 */
public class T65 {

    public static int getSum(int a1, int a2){
        int n1 = a1 ^ a2;
        int n2 = (a1 & a2) << 1;

        while (n2 != 0){
            int res = n1 ^ n2;
            n2 = (n1 & n2) << 1;
            n1 = res;
        }

        return n1;
    }

    public static void main(String[] args) {
        System.out.println(getSum(43, 7154));
    }
}
