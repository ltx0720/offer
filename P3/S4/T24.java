package P3.S4;

import P3.Utils.Node;

/**
 * @Author ltx
 * @Date 15:35 2020/2/6
 *
 * 反转链表 - 鲁棒性
 */
public class T24 {

    /**
     *   o<---o<---o<---o ,
     *                  ↑
     *          此时 current 指向最后一个
     *   此时 behind = current.next = null;
     *   所以不能再执行 behind = behind.next 了
     */
    public <T> Node<T> reverse(Node<T> head) throws NullPointerException{
        if (head == null){
            throw new NullPointerException("head is null");
        }

        Node<T> pre = null;
        Node<T> current = head;
        Node<T> behind = head.next;

        while (current != null){
            current.next = pre;
            if (behind == null){
                break;
            }
            pre = current;
            current = behind;
            behind = behind.next;
        }

        return current;
    }

    public static void main(String[] args) {
        T24 t = new T24();

//        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node1 = null;
//        node1.next = new Node<>(2);
//        node1.next.next = new Node<>(3);
//        node1.next.next.next = new Node<>(4);

        Node<Integer> reverse = t.reverse(node1);

        Node.print(reverse);
    }

}
