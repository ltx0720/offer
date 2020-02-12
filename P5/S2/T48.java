package P5.S2;

/**
 * @Author ltx
 * @Date 16:57 2020/2/12
 *
 * 最长不含重复字符的子字符串
 */
public class T48 {

    public static String longestStr(String str){
        if (str == null || str.length() == 0){
            return "";
        }

        int maxLength = 1;
        int preLength = 1;
        int end = 0;

        for (int i=1; i<str.length(); i++){
            int curch = str.charAt(i), d = 1;
            for (int j=i-1; j>=i-preLength; j--){
                if (str.charAt(j) == curch){
                    break;
                }
                d++;
            }
            if (d < preLength){
                preLength = d;
            }
            /**
             * 上面循环中，d最大只能等于preLength
             * d == preLength 可能存在两种情况
             * 1.preLength的最后一个与当前i位置上的字符相同 acaca
             * 2.不相同，即实际与当前字符相同的位置在更前面 acbca
             */
            if (curch != str.charAt(i-preLength)){
                preLength += 1;
            }

            if (preLength > maxLength){
                maxLength = preLength;
                end = i;
            }
        }

        return str.substring(end+1-maxLength, end+1);
    }

    public static void main(String[] args) {

        String s = "a";
        System.out.println(longestStr(s));

    }
}
