package P6.S5;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @Author LTX
 * @Date 15:54 2020/2/17
 *
 * 求1+2+...+n
 */
public class T64 {

    public static void main(String[] args) {
        int n = 100;
        Integer integer = Stream.iterate(0, num -> num + 1).limit(n).reduce((a, b) -> a + b).get();
        System.out.println(integer);
    }
}
