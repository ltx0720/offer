package P6.S3;

import P4.Utils.Tree;

/**
 * @Author LTX
 * @Date 16:58 2020/2/15
 *
 * 二叉树的深度
 */
public class T55 {


    public static <T extends Comparable> int getDeep(Tree<T> node){
        if (node == null){
            return 0;
        }

        int ldeep = getDeep(node.left);
        int rdeep = getDeep(node.right);

        int length = Math.max(ldeep, rdeep) + 1;

        return length;
    }

    public static void main(String[] args) {

        Tree<Integer> tree1 = new Tree<>(10);
//        tree1.left = new Tree<>(6);
//        tree1.right = new Tree<>(14);
//
//        tree1.left.left = new Tree<>(4);
//        tree1.left.right = new Tree<>(8);

//        tree1.right.left = new Tree<>(12);
//        tree1.right.right = new Tree<>(16);

        int deep = T55.getDeep(null);
        System.out.println(deep);
    }
}
