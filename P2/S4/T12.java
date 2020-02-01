package P2.S2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

/**
 * @Author ltx
 * @Date 17:26 2020/2/1
 * <p>
 * 矩阵中的路径。回溯
 */
public class T12 {

    private static int length;
    private static String string;

    public static void hs(String[][] array, int[][] select, int x, int y, StringBuilder strs, List<String> result) {
        //越界判断、当前字符可用判断
        if (x >= 0 && x < array.length && y>=0 && y<array[0].length && select[x][y] == 0) {
            strs.append(array[x][y]);
            select[x][y] = 1;
        } else {
            return;
        }

        if (strs.length() == length) {
            if (strs.toString().equals(string)) {
                result.add(strs.toString());
            }
            strs.deleteCharAt(strs.length()-1);
            select[x][y] = 0;
            return;
        }

        //上下左右走
        hs(array, select, x-1, y, strs, result);
        hs(array, select, x+1, y, strs, result);
        hs(array, select, x, y-1, strs, result);
        hs(array, select, x, y+1, strs, result);

        strs.deleteCharAt(strs.length()-1);
        select[x][y] = 0;
    }

    private static location getIndex(String[][] strings, String target){
        for (int i=0; i<strings.length; i++){
            for (int j=0; j<strings[i].length; j++){
                if (target.equals(strings[i][j])){
                    return new location(i, j);
                }
            }
        }
        return new location();
    }

    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"a", "b", "t", "g"},
                {"c", "f", "c", "s"},
                {"j", "d", "e", "h"},
        };

        int[][] ints = new int[array.length][array[0].length];

        string = "fdehs";
        length = string.length();

        location location = getIndex(array, "f");
        int x = location.x;
        int y = location.y;

        List<String> result = new ArrayList<>();
        hs(array, ints, x, y, new StringBuilder(), result);

        result.forEach(System.out::println);
    }

    private static final class location{
        private int x;
        private int y;

        public location(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public location() {
        }

    }
}
