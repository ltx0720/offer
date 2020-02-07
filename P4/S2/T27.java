package P4.S2;

import P4.Utils.Tree;

/**
 * @Author ltx
 * @Date 16:51 2020/2/7
 *
 * 二叉树的镜像
 */
public class T27<T extends Comparable> {

    public boolean isMirror(Tree<T> tree1, Tree<T> tree2){
        if (tree1==null && tree2!=null || tree1!=null && tree2==null){
            return false;
        }
        if (tree1 == null && tree2==null){
            return true;
        }
        if (tree1.data.compareTo(tree2.data) != 0){
            return false;
        }

        if (!isMirror(tree1.left, tree2.right)){
            return false;
        }

        return isMirror(tree1.right, tree2.left);
    }

    public static void main(String[] args) {
        T27<Integer> t = new T27();
        Tree<Integer> tree1 = new Tree<>(8);
        Tree<Integer> tree2 = new Tree<>(8);

        tree1.left = new Tree<>(6);
//        tree1.right = new Tree<>(10);
//
//        tree2.left = new Tree<>(10);
        tree2.right = new Tree<>(6);
//
        tree1.left.left = new Tree<>(7);
        tree2.right.right = new Tree<>(7);

        System.out.println(t.isMirror(tree1, tree2));
    }
}
