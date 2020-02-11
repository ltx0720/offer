package P5.S2;

/**
 * @Author ltx
 * @Date 17:04 2020/2/11
 *
 * 数字序列中某一位的数字
 */
public class T44 {

    public static int getNum(int n) {
        int stage = 0;
        int num = 0;

        while (true) {
            int num1 = (int) (9 * Math.pow(10, stage) * (stage + 1));
            if (n <= num1) {
                break;
            }

            num += num1;
            stage++;
        }

        int gs = (n - num - 1) / (stage + 1);//前面存在的数的个数
        int ys = (n - num) % (stage + 1);//所余位数 个数
        int szsz = (int) (Math.pow(10, stage) + gs); //所在数字

        int sjws = ys == 0 ? 0 : stage + 1 - ys;//缩减位数
        while (sjws-- > 0) {
            szsz /= 10;
        }


        return (int) szsz % 10;
    }

    public static void main(String[] args) {

        System.out.println(getNum(13));

    }
}
