package P6.S3;

import javax.crypto.spec.DESedeKeySpec;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * @Author LTX
 * @Date 23:06 2020/2/16
 *
 * 队列的最大值
 */
public class T59 {

    public static int[] getMaxArray(int[] array, int cwd){
        if (array == null || array.length == 0 || cwd <= 0){
            return new int[]{};
        }

        Deque<Integer> queue = new ArrayDeque<>(cwd);
        int[] result = new int[array.length-cwd+1];
        int size = 0;

        for (int i=0; i<array.length; i++){
            if (!queue.isEmpty() && (queue.size() == cwd || i-queue.peek()>2)){
                    queue.remove();
            }
            while (!queue.isEmpty() && array[i] > array[queue.getLast()]){
                queue.removeLast();
            }

            queue.addLast(i);
            if (i >= cwd-1){
                result[size++] = array[queue.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,7,4,0,6,2,4,1};
        int[] result = getMaxArray(array, 3);

        System.out.println(Arrays.toString(result));
    }
}
