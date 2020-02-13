package P5.S3;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @Author LTX
 * @Date 16:30 2020/2/13
 *
 * 第一个只出现一次的字符
 */
public class T50 {


    public static char getFrstOnce(String string){
        if (string == null || string.length() == 0){
            return '\0';
        }

        int[] restlt = new int[256];

        Arrays.stream(string.split("")).forEach(c -> restlt[(int)(c.charAt(0))]++);

        for (int i=0; i<restlt.length; i++){
            if (restlt[i] == 1){
                return (char)i;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(getFrstOnce(s));
    }
}
