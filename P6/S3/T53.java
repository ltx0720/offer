package P6.S3;

/**
 * @Author LTX
 * @Date 16:33 2020/2/15
 *
 * 在排序数组中查找数字
 */
public class T53 {


    public static int getFrequency(int[] array, int k){

        if (array == null || array.length == 0){
            return 0;
        }

        int first = getFirstIndex(array, 0, array.length-1, k);
        int last = getLastIndex(array, 0, array.length-1, k);

        if (last >= 0 && first >= 0){
            return last-first+1;
        }

        return 0;
    }

    public static int getFirstIndex(int[] array, int start, int end, int k){
        int mid = (start + end)/2;

        //数组中没有对应数字
        if (start == end && array[mid] != k){
            return -1;
        }

        if (array[mid] == k){
            if (mid > 0 && array[mid-1] == k){
                return getFirstIndex(array, start, mid-1, k);
            }else {
                return mid;
            }
        }

        if (array[mid] < k){
            return getFirstIndex(array, mid+1, end, k);
        }else {
            return getFirstIndex(array, start, mid-1, k);
        }

    }
    public static int getLastIndex(int[] array, int start, int end, int k){
        int mid = (start + end)/2;

        //数组中没有对应数字
        if (start == end && array[mid] != k){
            return -1;
        }

        if (array[mid] == k){
            if (mid < array.length-1 && array[mid+1] == k){
                return getLastIndex(array, mid+1, end, k);
            }else {
                return mid;
            }
        }

        if (array[mid] < k){
            return getLastIndex(array, mid+1, end, k);
        }else {
            return getLastIndex(array, start, mid-1, k);
        }
    }

    public static void main(String[] args) {
//        int[] array = new int[]{1,2,3,3,3,4,5};
        int[] array = new int[]{1};

        System.out.println(getFrequency(array, 1));

    }
}
