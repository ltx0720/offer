package P4.Utils;

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

    public Node() {
    }

    public static <T> void print(Node<T> node){
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
