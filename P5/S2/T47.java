package P5.S2;

/**
 * @Author ltx
 * @Date 17:38 2020/2/12
 * <p>
 * 礼物的最大价值
 */
public class T47 {

    public static int maxValue(int[][] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int[][] result = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            result[i] = new int[array[i].length];
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int up = 0, left = 0;
                if (i > 0) {
                    up = result[i - 1][j];
                }
                if (j > 0) {
                    left = result[i][j - 1];
                }

                result[i][j] = Math.max(up, left) + array[i][j];
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        return result[array.length - 1][array[array.length - 1].length - 1];
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5},
        };

        System.out.println(maxValue(ints));
    }
}
