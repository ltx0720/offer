package P4.S2;

/**
 * @Author ltx
 * @Date 16:14 2020/2/7
 *
 * 顺时针打印矩阵
 */
public class T29 {

    private static int n = 0;

    public static void print(int[][] array, int x, int y, int num){
        if (array.length == 0){
            return;
        }
        int maxX = array.length-1;
        int minX = x;
        int maxY = array[0].length-1;
        int minY = y;

        while (true){
            if (n == num){
                break;
            }
            right(array, x, y, maxY);
            minX++; x++; y = maxY;

            if (n == num){
                break;
            }
            down(array, x, y, maxX);
            maxY--; y--; x = maxX;

            if (n == num){
                break;
            }
            left(array, x, y, minY);
            maxX--; x--; y = minY;

            if (n == num){
                break;
            }
            up(array, x, y, minX);
            minY++; y++; x=minX;
        }
    }

    public static void left(int[][] array, int x, int y, int minY){
        for (int i=y; i>=minY; i--){
            System.out.print(array[x][i]+",");
            n++;
        }
    }
    public static void right(int[][] array, int x, int y, int maxY){
        for (int i=y; i<=maxY; i++){
            System.out.print(array[x][i]+",");
            n++;
        }
    }
    public static void up(int[][] array, int x, int y, int minX){
        for (int i=x; i>=minX; i--){
            System.out.print(array[i][y]+",");
            n++;
        }
    }
    public static void down(int[][] array, int x, int y, int maxX){
        for (int i=x; i<=maxX; i++){
            System.out.print(array[i][y]+",");
            n++;
        }
    }


    public static void main(String[] args) {
//        int[][] ins = new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10,11,12},
//                {13,14,15,16},
//        };
        int[][] ins = new int[][]{
                {1,2,3}
//                {2},
//                {3},
        };

        print(ins, 0, 0, 3);
    }
}
