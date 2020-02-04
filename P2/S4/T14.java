package P2.S4;

/**
 * @Author ltx
 * @Date 16:32 2020/2/2
 * <p>
 * 剪绳子 动归
 */
public class T14 {

    private static int[] result;

    //从上至下的，会重复计算一些重回的数据
    public static int cut1(int n) {
        if (n == 0) {
            return 1;
        }

        int num = n;
        for (int i = 1; i <= n / 2; i++) {
            int tmp = cut2(i) * cut2(n - i);

            num = num < tmp ? tmp : num;
        }

        return num;
    }

    //优化，类似fib，从下至上，保存结果值
    public static int cut2(int n) {
        if (n == 0) {
            return 1;
        }
        if (result[n] != 0) {
            return result[n];
        }

        int num = n;
        for (int i = 1; i <= n / 2; i++) {
            int tmp = cut1(i) * cut1(n - i);

            num = num < tmp ? tmp : num;
        }

        result[n] = num;
        return num;
    }

    public static void main(String[] args) {
        System.out.println(-4>>1);
        int n = 32;

        result = new int[n + 1];

        System.out.println(cut1(n));
        System.out.println(cut2(n));
    }
}
