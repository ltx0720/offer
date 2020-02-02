package P2.S4;

/**
 * @Author ltx
 * @Date 15:16 2020/2/2
 *
 * 机器人的运动范围  回溯
 */
public class T13 {

    private static int k;
    private static int num = 0;

    public static void getAccessNum(int[][] array, int x, int y){
        if (x<0 || x>=array.length || y<0 || y>=array[x].length || array[x][y]!=0 || getCoordinateNum(x, y)>k){
            return;
        }

        array[x][y] = 1;
        num++;

        getAccessNum(getArrayCloneAndSet(array), x-1, y);
        getAccessNum(getArrayCloneAndSet(array), x+1, y);
        getAccessNum(getArrayCloneAndSet(array), x, y-1);
        getAccessNum(getArrayCloneAndSet(array), x, y+1);
    }

    public static int getCoordinateNum(int x, int y){
        int n1=0, n2=0;
        while (x != 0){
            n1 += x%10;
            x/=10;
        }
        while (y != 0){
            n2 += y%10;
            y/=10;
        }

        return n1+n2;
    }

    public static int[][] getArrayCloneAndSet(int[][] array){

        return array.clone();
    }

    public static void main(String[] args) {
        int[][] array = new int[5][1];
        k = 3;

        getAccessNum(array, 0, 0);
        System.out.println(num);
    }
}
