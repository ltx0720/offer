package twoP.twoS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ltx
 * @Date 15:48 2020/1/30
 *
 * 根据前序中序建树
 */
public class T7 {

    private static int[] a1;//前序
    private static int[] a2;//中序

    public static Tree<Integer> build(int s1, int e1, int s2, int e2){
        int value = a1[s1];
        Tree<Integer> p = new Tree<Integer>(value);

        int index = getIndex(a2, value);
        int llength = index - s2;
        int rlength = e2 - index;

        /**
         * 分成两块，中序的左右树，前序的左右树
         */
        int a1ls = s1+1;
        int a1le = s1+llength;
        int a1rs = a1le+1;
        int a1re = e1;

        int a2ls = s2;
        int a2le = index-1;
        int a2rs = index+1;
        int a2re = e2;

        if (llength != 0) {
            p.left = build(a1ls, a1le, a2ls, a2le);
        }
        if (rlength != 0) {
            p.right = build(a1rs, a1re, a2rs, a2re);
        }

        return p;
    }

    public static int getIndex(int[] array, int num){
        for (int i=0; i<array.length; i++){
            if (array[i] == num){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        a1 = new int[]{1,2,4,7,3,5,6,8};
        a2 = new int[]{4,7,2,1,5,3,6,8};
        int index = a1.length-1;
        Tree<Integer> build = build(0, index, 0, index);
//        build(4,7, 4,7, root);

        T7.inOrder(build);

    }

    public static void inOrder(Tree<Integer> node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);

    }


    public static void preOrder(Tree<Integer> node){
        if (node == null){
            return;
        }

        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);

    }

}
