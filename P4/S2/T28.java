package P4.S2;

import P4.Utils.Tree;

/**
 * @Author ltx
 * @Date 18:39 2020/2/7
 *
 * 对称的二叉树
 */
public class T28<T extends Comparable> {

    public boolean isSymmetric(Tree<T> tree){
        if (tree == null){
            return false;
        }
        Tree<T> p = tree;
        Tree<T> q = tree;

        return Core(p, q);
    }

    public boolean Core(Tree<T> t1, Tree<T> t2){

        if (t1==null && t2==null){
            return true;
        }else if (t1 == null || t2 == null){
            return false;
        }

        if (t1.data.compareTo(t2.data) != 0){
            return false;
        }

        return Core(t1.left, t2.right)==false ? false:Core(t1.right, t2.left);
    }


    public static void main(String[] args) {
        T28<Integer> t = new T28();
        Tree<Integer> tree1 = new Tree<>(8);

        tree1.left = new Tree<>(6);
//        tree1.right = new Tree<>(6);

//        tree1.left.left = new Tree<>(5);
//        tree1.left.right = new Tree<>(7);
//
//        tree1.right.left = new Tree<>(7);
//        tree1.right.right = new Tree<>(5);
//        tree1.right.right.right = new Tree<>(5);


        System.out.println(t.isSymmetric(tree1));
    }
}
