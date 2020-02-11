package P5.S2;

/**
 * @Author ltx
 * @Date 18:53 2020/2/11
 *
 * 连续子数组的最大和
 */
public class T42 {

    public static int getMaxSum1(int[] array) throws Exception {

        if (array == null || array.length == 0){
            throw new Exception("array illegal");
        }
        int num = array[0];
        int max = array[0];

        for (int i=1; i<array.length; i++){
            if (num + array[i] > array[i]){
                num = num + array[i];
            }else {
                num = array[i];
            }
            max = max > num?max:num;
        }
        return max;
    }


    public static void main(String[] args) throws Exception {
        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(getMaxSum1(array));
    }
}
