package P3.S4;

import P4.Utils.Tree;

/**
 * @Author ltx
 * @Date 17:06 2020/2/7
 *
 * 树的子结构
 */
public class T26<T extends Comparable> {

    public boolean isSon(Tree<T> tree1,  Tree<T> tree2){
        if (tree1 == null){
            return false;
        }
        if (tree2 == null){
            return true;
        }

        return getStartList(tree1, tree2);
    }

    public boolean getStartList(Tree<T> tree1,  Tree<T> tree2){
        if (tree1 == null){
            return false;
        }

        if (tree1.data.compareTo(tree2.data) == 0 && isSonCore(tree1, tree2)){
            return true;
        }else {
            return getStartList(tree1.left, tree2)==true ? true:getStartList(tree1.right, tree2);
        }
    }

    public boolean isSonCore(Tree<T> tree1, Tree<T> tree2){
        if (tree1 == null && tree2==null || tree2==null){
            return true;
        }

        if (tree2 != null && tree1 == null){
            return false;
        }

        if (tree1.data.compareTo(tree2.data) != 0){
            return false;
        }

        return isSonCore(tree1.left, tree2.left)==false ? false:isSonCore(tree1.right, tree2.right);
    }

    public static void main(String[] args) {
        T26<Integer> t = new T26();
        Tree<Integer> tree2 = new Tree<>(8);
        Tree<Integer> tree1 = new Tree<>(8);

        tree1.left = new Tree<>(8);
        tree1.right = new Tree<>(7);
        tree1.left.left = new Tree<>(9);
        tree1.left.right = new Tree<>(2);
        tree1.left.right.left = new Tree<>(4);
        tree1.left.right.right = new Tree<>(7);


        tree2.left = new Tree<>(8);
        tree2.right = new Tree<>(7);
        System.out.println(t.isSon(tree1, tree2));
    }
}
