package P4.S4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ltx
 * @Date 16:27 2020/2/9
 * <p>
 * 字符串的排列
 */
public class T38 {

    private static void permutation(String[] strings, int[] select, StringBuilder builder, List<String> list) {

        //abc, acb....
        if (builder.length() == strings.length) {
            list.add(builder.toString());
        }
        //a, b, c, ab, abc.....
        if (builder.length() != 0) {
            list.add(builder.toString());
        }

        for (int i = 0; i < select.length; i++) {
            if (select[i] == 1) {
                continue;
            }
            select[i] = 1;
            builder.append(strings[i]);
            permutation(strings, select, builder, list);
            select[i] = 0;
            builder.deleteCharAt(builder.length() - 1);
        }

    }

    public static List<String> permutation(String[] strings) {
        List<String> list = new ArrayList<>();

        if (strings == null) {
            return list;
        }
        int[] select = new int[strings.length];
        StringBuilder builder = new StringBuilder();
        permutation(strings, select, builder, list);

        return list;
    }


    public static void main(String[] args) {
        String s = "abc";
        String[] strings = s.split("");
        List<String> list = permutation(strings);
        list.stream().forEach(System.out::println);
    }
}
