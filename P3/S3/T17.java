package P3.S3;

/**
 * @Author ltx
 * @Date 14:44 2020/2/4
 *
 * 打印从1到最大的n位数
 */
public class T17 {

    private static String[] strings = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    /**
     * n位数，先从第n位开始。0xxxx
     * 进行递归，把第n位(当前位数)之前的数保存下来。
     * 输出方式为 pre(上一次递归中print的输出) + str[i](println输出)
     * 注意代码中的 print println
     */
    public static void print(int curr, StringBuilder builder){
        if (curr <= 0){
            builder.deleteCharAt(builder.length()-1);
            return;
        }

        String s = builder.toString();

        for (int i=0; i<10; i++){
            System.out.print(strings[i]);
            print(curr-1, builder.append(strings[i]));

            if (i < 9){
                System.out.println();
                System.out.print(s);
            }
        }

        if (builder.length() > 0){
            builder.deleteCharAt(builder.length()-1);
        }
    }

    public static void print1(int curr, StringBuilder builder){
        if (curr <= 0){
            if (builder.length() > 0){
                builder.deleteCharAt(builder.length()-1);
            }
            return;
        }

        String s = builder.toString();

        for (int i=0; i<10; i++){
            System.out.println(s+strings[i]);
            print1(curr-1, builder.append(strings[i]));

        }

        if (builder.length() > 0){
            builder.deleteCharAt(builder.length()-1);
        }
    }

    public static void main(String[] args) {

        print(3, new StringBuilder());
    }
}
