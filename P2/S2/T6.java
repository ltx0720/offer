package P2.S2;

/**
 * @Author ltx
 * @Date 15:18 2020/1/30
 *
 * 倒叙打印链表。运用栈
 */
public class T6 {

    //倒序输出链表
    public static void print(Node<Integer> head){
        if (head == null){
            return;
        }
        print(head.next);
        System.out.println(head.data);
    }

    public static Node<Integer> generic(int[] array){
        Node<Integer> head = new Node<>(array[0]);
        Node<Integer> bak = head;

        for (int i=1; i<array.length; i++){
            bak.next = new Node<>(array[i]);
            bak = bak.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};

        Node<Integer> node = generic(array);
        print(node);
    }
}
