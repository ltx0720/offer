package P4.S4;

import P4.Utils.Tree;

/**
 * @Author ltx
 * @Date 16:52 2020/2/9
 *
 * 序列化二叉树
 */
public class T37 {


    private static int index = 0;
    public static Tree<String> build(String str){
        if (str == null) {
            return null;
        }

        String[] strings = str.split("");
        Tree<String> tree = null;
        Tree<String> tree1 = build(strings,  tree);

        return tree1;
    }
    public static Tree<String> build(String[] str, Tree<String> tree){
        if (index >= str.length || "$".equals(str[index])){
            index++;
            return null;
        }
        tree = new Tree<>(str[index]);
        index++;

        tree.left = build(str, tree.left);
        tree.right = build(str, tree.right);

        return tree;
    }

    public static void serialize(Tree<String> tree, StringBuilder builder){
        if (tree == null){
            builder.append("$");
            return;
        }
        builder.append(tree.data);
        serialize(tree.left, builder);
        serialize(tree.right, builder);
    }

    public static void printTree(Tree<String> tree){
        if (tree == null){
            return;
        }
        System.out.print(tree.data+" ");
        printTree(tree.left);
        printTree(tree.right);

    }
    public static void main(String[] args) {
        String s = "124$$$35$$6$$";

        Tree<String> tree1 = build(s);

        printTree(tree1);
        StringBuilder builder = new StringBuilder();

        System.out.println();
        serialize(tree1,builder);
        System.out.println(builder.toString());
    }
}
