package P2.S4;

/**
 * @Author ltx
 * @Date 19:13 2020/2/1
 *
 * 旋转数组中最小的数，旋转数组：把数组前n个数挪到后面。该数组原本是递增的。
 */
public class T11 {

    public static int getMin(int[] array){
//        if (array.length == 0){
//            return
//        }
        //把数组的前0个旋转，即没旋转
        if (array[0] < array[array.length-1]){
            return array[0];
        }

        return dichotomy(array, 0, array.length-1);
    }

    public static int dichotomy(int[] array, int start, int end){
        if (start == end){
            return array[start];
        }

        int mid = (start+end)/2;
        int num = array[mid];
        if (array[start] == array[mid] && array[mid]==array[end]){
            return inOrder(array);
        }

        // <= ,根据特殊情况判断得到<= 2,1,1
        if (num <= array[end]){
            return dichotomy(array, start, mid);
        }else {
            return dichotomy(array, mid+1, end);
        }
    }

    public static int inOrder(int[] array){
        int num = array[0];

        for (int i=1; i<array[i]; i++){
            if (array[i] < num){
                num = array[i];
            }
        }

        return num;
    }

    public static void main(String[] args) {
//        int[] array = new int[]{7,1,2,2,2,3,4,5,6};
//        int[] array = new int[]{7,1,2,2,2,3,4,5,6};
        int[] array = new int[]{2,3,1};
        System.out.println(getMin(array));
    }

}
