package P5.S3;

/**
 * @Author LTX
 * @Date 15:57 2020/2/13
 *
 * 丑数
 */
public class T49 {


    public static int getUgly(int num){
        if (num <= 0){
            return 0;
        }

        int[] ugly = new int[num];
        ugly[0] = 1;
        int index = 0;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        while (index < num-1) {
            int num2 = 2*ugly[index2];
            int num3 = 3*ugly[index3];
            int num5 = 5*ugly[index5];

            int n = Math.min(Math.min(num2, num3), num5);
            ugly[++index] = n;

            //1 2 3 5 6, 3的时候，3*2=6，已经用过了
            //当前的乘积小于尾的数，说明已经遍历过了
            while (ugly[index2]*2 <= n){
                index2++;
            }
            while (ugly[index3]*3 <= n){
                index3++;
            }
            while (ugly[index5]*5 <= n){
                index5++;
            }
        }

        return ugly[num-1];
    }

    public static void main(String[] args) {

//        int[] array = new int[]{};
        System.out.println(getUgly(1500));

        for (int i=0; i<10; i++){

        }
    }
}
