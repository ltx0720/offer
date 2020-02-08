package P4.S3;

import P4.Utils.Tree;
import java.util.Stack;

/**
 * @Author ltx
 * @Date 17:07 2020/2/8
 *
 * 之字形打印二叉树
 */
public class T32_3<T extends Comparable> {

    public void z_shapePrint(Tree<T> tree){
        if (tree == null){
            return;
        }

        Stack<Tree<T>> stack = new Stack<>();
        stack.push(tree);
        z_shapePrint(stack, 1);
    }
    private void z_shapePrint(Stack<Tree<T>> stack, int num){

        boolean isEvenNumber = num%2==0;
        Stack<Tree<T>> stack1 = new Stack<>();

        while (!stack.isEmpty()){
            Tree<T> tree = stack.pop();
            System.out.print(tree.data+" ");

            if (isEvenNumber){

                if (tree.right != null){
                    stack1.push(tree.right);
                }
                if (tree.left != null){
                    stack1.push(tree.left);
                }


            }else {
                if (tree.left != null){
                    stack1.push(tree.left);
                }
                if (tree.right != null){
                    stack1.push(tree.right);
                }

            }
        }
        if (stack1.empty()){
            return;
        }
        System.out.println();
        z_shapePrint(stack1, ++num);
    }

    public static void main(String[] args) {
        T32_3<Integer> t = new T32_3();
        Tree<Integer> tree1 = new Tree<>(1);

        tree1.left = new Tree<>(2);
//        tree1.right = new Tree<>(3);
        tree1.left.left = new Tree<>(4);
//        tree1.left.right = new Tree<>(5);
//        tree1.right.left = new Tree<>(6);
//        tree1.right.right = new Tree<>(7);


        t.z_shapePrint(tree1);
    }
}
