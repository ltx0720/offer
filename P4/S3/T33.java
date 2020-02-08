package P4.S3;

/**
 * @Author ltx
 * @Date 15:54 2020/2/8
 *
 * 二叉搜索树的遍历序列
 */
public class T33<T extends Comparable> {

    public boolean isBST(T[] array) {
        if (array.length == 0) {
            return false;
        }

        return isBSTCore(array, 0, array.length);
    }

    /**
     * f(stat, end) 考虑优化为 f(start, length)
     * 在计算左子树结束位置(也是右子树开始位置)的时候，
     * 同时计算出了左右子树的长度
     */
    private boolean isBSTCore(T[] array, int start, int length) {
        if (length == 0) {
            return true;
        }

        T rootData = array[start + length - 1];
        int leftLength = 0;

        for (int i = start; i < start + length - 1; i++, leftLength++) {
            if (array[i].compareTo(rootData) > 0) {
                break;
            }
        }

        int rightLength = 0;
        for (int i = start + leftLength; i < start + length - 1; i++, rightLength++) {
            if (array[i].compareTo(rootData) <= 0) {
                return false;
            }
        }

        return isBSTCore(array, start, leftLength) && isBSTCore(array, start + leftLength, rightLength);
    }

    public static void main(String[] args) {
        T33<Integer> t = new T33<>();

        Integer[] array = new Integer[]{1};
        System.out.println(t.isBST(array));
    }
}
