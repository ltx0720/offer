package P6.S3;

/**
 * @Author LTX
 * @Date 21:34 2020/2/16
 *
 * 和为 S 的数字
 */
public class T57 {

    public static void find(int[] array, int S) throws Exception {
        if (array == null || array.length == 0){
            throw new Exception("array is illegal");
        }
        int head = 0;
        int tail = array.length-1;

        while (head < tail){
            if (array[head] + array[tail] > S){
                tail--;
            }else if (array[head] + array[tail] < S){
                head++;
            }else {
                System.out.println(array[head]+"-"+array[tail]);
                return;
            }
        }

        throw new Exception("can not find");
    }

    public static void main(String[] args) throws Exception {

        int[] array = new int[]{1,2,4,7,11,15};
        find(array, 14);
    }
}

