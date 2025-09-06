package stack;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        int[] a = {-2,0,-3};
        UsingOneStack stack = new UsingOneStack();
        for(int s : a){
            stack.push(s);
        }
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getTop());
         System.out.println(stack.getMin());
    }
}

class UsingOneStack{
    private Stack<int[]> stack;
    public UsingOneStack(){
        stack = new Stack<>();
    }

    public int getMin(){
        return stack.peek()[1];
    }

    public int getTop(){
        return stack.peek()[0];
    }

    public void pop(){
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }

    public void push(int ele){
        if(stack.isEmpty()){
            stack.push(new int[]{ele,ele});
            return;
        }

        int[] temp = stack.peek();
        if(temp[0] > ele && temp[1] > ele){
            
           
            stack.push(new int[]{ele,ele});
            return;
        }
        stack.push(new int[]{ele,temp[1]});
        return;
    }
}
