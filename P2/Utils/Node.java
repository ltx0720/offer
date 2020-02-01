package P2.Utils;

/**
 * @Author ltx
 * @Date 18:23 2019/12/28
 */
public class Node<T> {

    public Node<T> next;
    public T data;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
