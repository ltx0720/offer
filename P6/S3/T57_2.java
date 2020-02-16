package P6.S3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LTX
 * @Date 21:43 2020/2/16
 *
 * 和为 S 的连续正数序列
 */
public class T57_2 {


    public static List<List<Integer>> find(int S) {
        List<List<Integer>> lists = new ArrayList<>();

        if (S <= 0) {
            return lists;
        }

        if (S < 3){
            List<Integer> list = new ArrayList<>();
            list.add(S);
            lists.add(list);
            return lists;
        }

        int head = 1;
        int tail = 2;
        int sum = 3;
        int maxIdnex = S/2+1;

        while (head <= maxIdnex && tail <= maxIdnex){
            if (sum < S){
                tail++;
                sum += tail;
            }else if (sum > S){
                sum -= head;
                head++;
            }else {
                List<Integer> list = new ArrayList<>();
                for (int i=head; i<=tail; i++){
                    list.add(i);
                }
                lists.add(list);
                tail++;
                sum += tail;
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = find(15);
        lists.forEach(t -> {
            t.forEach(num -> System.out.print(num+" "));
            System.out.println();
        });
    }
}
