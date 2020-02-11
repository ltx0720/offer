package P5.S2;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Author ltx
 * @Date 15:44 2020/2/11
 *
 * 把数组排成最小的数
 */
public class T45 {

    public static void main(String[] args) {
        int[] ints = new int[]{3,5,1,4,2};

        Optional<String> reduce = Arrays.stream(ints).mapToObj(x -> x + "")
                .sorted((str1, str2) -> (str1 + str2).compareTo(str2 + str1))
                .reduce((s1, s2) -> s1 + s2);

        System.out.println(reduce.get());
    }
}

