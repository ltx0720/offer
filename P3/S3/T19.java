package P3.S3;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Arrays;

/**
 * @Author ltx
 * @Date 15:12 2020/2/5
 *
 * 正则表达式匹配
 */
public class T19 {

    public static boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, pattern, 0, 0);
    }


    public static boolean matchCore(String str, String pattern, int strIndex, int patternIndex) {

        //处理str为空的情况
        if (str == "") {
            if (pattern == "") {
                return true;
            }

            if (nextIsStar(pattern, patternIndex)) {
                if (isEnd(pattern, patternIndex + 1)) {
                    return true;
                }
                return matchCore(str, pattern, strIndex, patternIndex + 2);
            }

            return false;
        }

        char s = str.charAt(strIndex);
        char p = pattern.charAt(patternIndex);
        p = p == '.' ? s : p;
        boolean nextIsStar = nextIsStar(pattern, patternIndex);

        if (isEnd(str, strIndex)) {
            if (isEnd(pattern, patternIndex)) {
                return p == s;
            }
            //如果此时的pattern的 *后面没有元素了  a a*
            if (nextIsStar && isEnd(pattern, patternIndex + 1)) {
                return true;
            }
            return false;
        }



        if (p == s && !nextIsStar) {
            return matchCore(str, pattern, strIndex + 1, patternIndex + 1);
        }

        /**
         * aaa  a*a
         * 若模式串为*，有2种选择，
         * 1.忽略该*，即字符串与*匹配0次, pattern往后走
         * 2.不忽略，字符串若往后走1步，模式串有2中选择
         *   ①不动。
         *   ②往后走。
         *
         */
        if (nextIsStar) {
            return matchCore(str, pattern, strIndex + 1, patternIndex) ||
                    matchCore(str, pattern, strIndex + 1, patternIndex + 2) ||
                    matchCore(str, pattern, strIndex, patternIndex + 2);
        }


        return false;
    }

    public static boolean nextIsStar(String str, int index) {
        if (index == str.length() - 1) {
            return false;
        }
        return str.charAt(index + 1) == '*';
    }

    public static boolean isEnd(String str, int index) {
        return index == str.length() - 1;
    }

    public static void main(String[] args) {
        String str = "aaabb";
//        String str1 = "";
//        char[] chars = str1.toCharArray();
//        System.out.println(Arrays.toString(chars));
        String pattern = "a*aaaa*b*";

        System.out.println(match(str, pattern));
    }
}
