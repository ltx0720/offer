package P6.Utils;

/**
 * @Author ltx
 * @Date 15:53 2020/1/30
 */
public class Tree<T> {
    public Tree<T> left;
    public Tree<T> right;
    public T data;

    public Tree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
