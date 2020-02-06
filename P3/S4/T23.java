package P3.S4;

import P3.Utils.Node;

/**
 * @Author ltx
 * @Date 16:09 2020/2/6
 *
 * 链表找环 - 鲁棒性
 */
public class T23 {

    /**
     * 首先判断链表是否有环
     * 1.无环
     * 2.有环
     *  ① 先计算环的节点 n
     *  ② 让快指针走 n 步
     *  ③ 快慢指针各走一步，相交时的节点即为环入口
     *
     *  快指针每步比慢指针多走1步，有环则必重合且多走了n步
     */

    public static <T> int circleNum(Node<T> node){
        if (node.next == null){
            return -1;
        }

        Node<T> slow = node.next;
        Node<T> fast = slow.next;
        int n = 1;

        while (fast != null){
            if (fast == slow){
                return n;
            }
            slow = slow.next;
            fast = fast.next.next;
            n++;
        }

        return -1;
    }

    public static <T> Node<T> getEntry(Node<T> node){
        if (node == null){
            return null;
        }

        int circleNum = circleNum(node);
        if (circleNum == -1){
            return null;
        }

        Node<T> entry = getEntryCore(node, circleNum);
        return entry;
    }

    public static <T> Node<T> getEntryCore(Node<T> node, int num){
        Node<T> slow = node;
        Node<T> fast = node;

        while (num-- > 0){
            fast = fast.next;
        }

        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
//
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        Node<Integer> entry = getEntry(node1);

        if (entry!=null){
            System.out.println(entry.data);
        }else {
            System.out.println("无环");
        }
    }
}
