package P4.S4;

import P4.Utils.Tree;

/**
 * @Author ltx
 * @Date 17:22 2020/2/9
 *
 * 二叉搜索树与双向链表
 */
public class T36<T> {

    public Tree<T> getLeft(Tree<T> tree){
        if (tree==null){
            return null;
        }
        while (tree.left != null){
            tree = tree.left;
        }

        return tree;
    }

    /**
     *          10
     *        /    \
     *       6     14
     *     /   \  /   \
     *    4    8  12   16
     *
     *   4-6-8-10-12-14-16
     *
     *  思路:
     *  10.left = 左子树的最右，10.right = 右子树的最左
     *
     *
     *  对每个节点如此递归操作，只需要判断当前节点
     *  是其父亲的左孩子还是右孩子即可。
     *
     *  如果没有左子树或右子树，返回自己。即没有8的情况，6返回自己
     *
     */
    public Tree<T> treeToLink(Tree<T> tree, boolean left){
        if (tree == null){
            return null;
        }

        tree.left = treeToLink(tree.left, true);
        tree.right = treeToLink(tree.right, false);

        if (tree.left != null){
            tree.left.right = tree;
        }
        if ( tree.right != null){
            tree.right.left = tree;
        }

        return left==true ? (tree.right==null?tree:tree.right):(tree.left==null?tree:tree.left);
    }

    public static void main(String[] args) {
        T36<Integer> t = new T36();
        Tree<Integer> tree1 = new Tree<>(10);
        tree1.left = new Tree<>(6);
        tree1.right = new Tree<>(14);

        tree1.left.left = new Tree<>(4);
        tree1.left.right = new Tree<>(8);

        tree1.right.left = new Tree<>(12);
        tree1.right.right = new Tree<>(16);

        Tree<Integer> left = t.getLeft(tree1);
        t.treeToLink(tree1,true);
        System.out.println(left);
    }
}