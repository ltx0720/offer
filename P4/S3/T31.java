package P4.S3;

import java.util.Stack;

/**
 * @Author ltx
 * @Date 18:51 2020/2/8
 *
 * 栈的压入弹出序列
 */
public class T31 {


    public static boolean isLegal(int[] push, int[] pop){
        if ((push==null || push.length==0) && (pop.length!=0 && pop!=null)){
            return false;
        }

        if (pop.length==0 || pop==null){
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(push[0]);
        int pushIndex = 1;
        int popIndex = 0;

        while (pushIndex < push.length && popIndex < pop.length ){
            if (stack.peek() != pop[popIndex]){
                stack.push(push[pushIndex++]);
                continue;
            }else {
                stack.pop();
                popIndex++;
            }
        }

        if (popIndex < pop.length){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] push = new int[]{1,2,3,4};
        int[] pop = new int[]{2,4,3,1,5};

        System.out.println(isLegal(push, pop));
    }
}
