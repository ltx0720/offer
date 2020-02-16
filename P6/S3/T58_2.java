package P6.S3;

/**
 * @Author LTX
 * @Date 22:29 2020/2/16
 *
 * 左旋转字符串
 */
public class T58_2 {

    public static String rotate(String str, int k) throws Exception {
        str = reverse(str, 0, str.length());

        str = reverse(str, 0, str.length()-k);
        str = reverse(str, str.length()-k, k);

        return str;
    }

    private static String reverse(String string, int start, int length) throws Exception {
        if (string == null || start < 0 || length < 0){
            throw new Exception("input illegal");
        }
        int end = start + length - 1;
        if (end >= string.length()){
            end = string.length()-1;
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

        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        String s = "123456";
        String rotate = rotate(s, 2);
        System.out.println(rotate);
    }
}
