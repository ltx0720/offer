package P3.S4;

import P3.Utils.Node;

/**
 * @Author ltx
 * @Date 17:12 2020/2/6
 *
 * 合并两个排序链表
 */
public class T25 {

    public static <T extends Comparable> Node<T> merge(Node<T> node1, Node<T> node2){
        if (node1==null && node2==null){
            return null;
        }
        if (node1==null || node2==null){
            return node1==null ? node2:node1;
        }

        Node<T> n1 = node1;
        Node<T> n2 = node2;
        Node<T> root = new Node<>();
        Node<T> n3 = root;

        if (n1.data.compareTo(n2.data) > 0){
            root.data = n2.data;
            n2 = n2.next;
        }else {
            root.data = n1.data;
            n1 = n1.next;
        }

        while (n1 != null && n2 != null){
            if (n1.data.compareTo(n2.data) < 0){
                n3.next = new Node<>(n1.data);
                n1 = n1.next;
            }else {
                n3.next = new Node<>(n1.data);
                n2 = n2.next;
            }
            n3 = n3.next;
        }

        while (n1 != null){
            n3.next = new Node<>(n1.data);
            n1 = n1.next;
            n3 = n3.next;
        }

        while (n2 != null){
            n3.next = new Node<>(n2.data);
            n2 = n2.next;
            n3 = n3.next;
        }

        return root;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(1);
        Node<Integer> node3 = new Node<>(1);
        Node<Integer> node4 = new Node<>(1);
        node2.next = node3;
        node3.next = node4;
//        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node = merge(node1, node2);
        Node.print(node);
    }
}
