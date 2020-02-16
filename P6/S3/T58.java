package P6.S3;

import java.util.Arrays;

/**
 * @Author LTX
 * @Date 22:12 2020/2/16
 *
 * 反转字符串
 */
public class T58 {

    public static String reverse(String str) throws Exception {
        if (str == null){
            throw new Exception("str is null");
        }
        str = reverse(str, 0, str.length()-1);
        int start = 0;

        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) != ' '){
                continue;
            }else {
               str = reverse(str, start, i - 1);
               start = i+1;
            }
        }

        return str.toString();
    }

    private static String reverse(String string, int start, int end) throws Exception {
        if (string == null || start < 0 || end >= string.length()){
            throw new Exception("input illegal");
        }
        StringBuilder builder = new StringBuilder(string);

        while (start < end){
            char c1 = builder.charAt(start);
            char c2 = builder.charAt(end);
            builder.replace(start, start+1, String.valueOf(c2));
            builder.replace(end, end+1, String.valueOf(c1));
            start++;
            end--;
        }
//        String s = Arrays.toString(chars);
//        System.out.println(s);

        return builder.toString();
    }



    public static void main(String[] args) throws Exception {
        String s = "i am god.";
        System.out.println(reverse(s).toString());
    }
}
