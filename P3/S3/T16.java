package P3.S3;

/**
 * @Author ltx
 * @Date 16:53 2020/2/4
 *
 * 数值的整数次方
 */
public class T16 {

    /**
     * 首先判断参数的范围
     *  base可以是正数、负数、0，exponent也一样
     *  根据幂数可以把结果分为三类
     *    >0     <0     =0
     *  base^n 1/base base^0=1
     *           ↓
     *     此时 base!=0，得做特殊判断
     */
    public static double power(double base, int exponent) {
        boolean m = true;
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            m = false;
    }

        int exponent1 = exponent;
        double base1 = base;
        while ((exponent1 /= 2) != 0) {
            base1 *= base1;
        }

        if (exponent % 2 != 0) {
            base *= base1;
        }
        base = m ? base : 1/base;

        return base;
    }

    public static void main(String[] args) {

        System.out.println(power(-2,-3));

    }
}
