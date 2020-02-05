package P3.S3;

import P3.Utils.Node;

/**
 * @Author ltx
 * @Date 15:14 2020/2/4
 *
 * 删除有序链表中的重复节点
 */
public class T18_1<T> {


    public Node<T> deleteRepetition(Node<T> head){
        Node<T> current = head;
        Node<T> pre = new Node<>();
        pre.next = head;

        while (current!=null && current.next != null){
            if (current.data.equals(current.next.data)){
                while (current.next!=null && current.data.equals(current.next.data)){
                    current = current.next;
                }
                //如果head与后面节点相同，则删除节点的同时，移动head
                if (head == pre.next){
                    head = current.next;
                }

                //保持pre在current前面
                pre.next = current.next;
            }
            pre = current;
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {

        T18_1<Integer> t = new T18_1<>();

        /**
         * 0011
         * 0012334
         * null
         * 011
         */
        Node<Integer> n1 = new Node<>(0);
        n1.next = new Node<>(1);
//        n1.next.next = new Node<>(1);
//        n1.next.next.next = new Node<>(2);
//        n1.next.next.next.next= new Node<>(3);
//        n1.next.next.next.next.next = new Node<>(3);
//        n1.next.next.next.next.next.next = new Node<>(4);
        Node<Integer> node = t.deleteRepetition(n1);

        Node.print(node);

    }
}
