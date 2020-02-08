package P4.S3;

import P2.S2.T3;
import P4.Utils.Tree;

import java.util.Stack;

/**
 * @Author ltx
 * @Date 19:36 2020/2/8
 *
 * 二叉树中和为某一值的路径
 */
public class T34 {

    public static void printTree(Tree<Integer> tree, int num){
        if (tree == null){
            return;
        }
        Stack<Integer> stack = new Stack<>();

        caculate(tree, stack, 0, num);
    }

    private static void caculate(Tree<Integer> tree, Stack<Integer> stack, int sum, int num){

        stack.push(tree.data);

        if (num == (sum+tree.data)){
            System.out.println(stack.toString());
        }

        if (tree.left != null){
            caculate(tree.left, stack, sum+tree.data, num);
            stack.pop();
        }

        if (tree.right != null){
            caculate(tree.right, stack, sum+tree.data, num);
            stack.pop();
        }

    }

    public static void main(String[] args) {
        T34 t = new T34();
        Tree<Integer> tree1 = new Tree<>(10);

        tree1.left = new Tree<>(5);
        tree1.right = new Tree<>(12);
        tree1.left.left = new Tree<>(4);
        tree1.left.right = new Tree<>(7);

        t.printTree(tree1, 22);
    }
}
