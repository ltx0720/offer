package P5.S3;

import P5.Utils.Node;

/**
 * @Author LTX
 * @Date 16:52 2020/2/13
 *
 * 两个链表的第一个公共节点
 */
public class T52 {


    public static <T extends Comparable> Node<T> getCommonNode(Node<T> node1, Node<T> node2){
        if (node1==null || node2==null){
            return null;
        }

        int length1 = 0;
        int length2 = 0;
        Node<T> n1 = node1;
        Node<T> n2 = node2;

        while (n1 != null){
            n1 = n1.next;
            length1++;
        }
        while (n2 != null){
            n2 = n2.next;
            length2++;
        }

        if (length1 == 0 || length2 == 0){
            return null;
        }

        if (length1 > length2) {
            int different = length1 - length2;
            while (different-- > 0){
                node1 = node1.next;
            }
        }
        if (length2 > length1) {
            int different = length2 - length1;
            while (different-- > 0){
                node2 = node2.next;
            }
        }

        while (node1!=null && node2!=null && node1.data.compareTo(node2.data) != 0){
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;

    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(5);
        Node<Integer> node2 = new Node<>(6);
        Node<Integer> common = new Node<>(4);

         node1.next = common;
         node1.next.next = new Node<>(3);

         node2.next = new Node<>(7);
         node2.next.next = common;

        Node<Integer> node = getCommonNode(node1, node2);
        if (node != null){
            System.out.println(node.data);
        }else {
            System.out.println("no common node");
        }
    }
}
