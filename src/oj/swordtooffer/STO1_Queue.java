package oj.swordtooffer;

import java.util.Stack;

/**
 * Created by Administrator on 2018/11/23.
 * 两个栈实现一个队列
 */
public class STO1_Queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(Integer node){
        stack1.push(node);
    }

    public Integer pop(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            if(stack2.isEmpty()){
                return null;
            }
        }
        return stack2.pop();
    }
}
