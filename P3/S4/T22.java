package P3.S4;

import P3.Utils.Node;

/**
 * @Author ltx
 * @Date 16:43 2020/2/6
 *
 * 链表中倒数第K个节点
 */
public class T22 {

    //k>0,链表从1开始
    public static <T> Node<T> getDecNode(Node<T> head, int k){
        if (head == null || k <= 0){
            return null;
        }

        Node<T> fast = head;
        Node<T> slow = head;
        k-=1;

        while (k-- > 0 && fast.next != null){
            fast = fast.next;
        }
        //k 大于链表长度，报错
        if (k > 0){
            return null;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        int k = 1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        Node<Integer> node = getDecNode(node1, k);

        if (node!=null){
            System.out.println(node.data);
        }else {
            System.out.println("输入错误");
        }
    }
}
