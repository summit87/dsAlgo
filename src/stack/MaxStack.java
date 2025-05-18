package stack;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

public class MaxStack {
    public static void main(String[] args) {
      /**
       * Logic to create the max stack
       * 1. create a tree map which will sort the key in assending order
       * 2. create list which will store the value based on sequnce of element
       *   
       * 
       */
      String[]s = {"MaxStack","push","push","push","top","popMax","top","peekMax","pop","top"};
      int[] a = {5,1,5};
     MaxStack2 mx = new MaxStack2(); ;
     int i=0;
      for(String s1 : s){
        if(s1.equals("MaxStack")){
          mx = new MaxStack2();
        }else if(s1.equals("push")){
          mx.push(a[i]);
          i++;
        }else if(s1.equals("top")){
          System.out.println("TOP : "+mx.top());
        }else if(s1.equals("peekMax")){
          System.out.println("Peek MAX "+mx.peekMax());
        }else if(s1.equals("popMax")){
          System.out.println("POP max "+mx.popMax());
        }else{
          System.out.println("POP "+mx.pop() );
        }
      }



      


    }
}

class MaxStack2 {

  PriorityQueue<StackNode> set;
  StackNode head;
  StackNode tail;
  int cnt = 0;

  public MaxStack2(){
    Comparator<StackNode> c = (a,b) ->{
      return a.val - b.val == 0 ? b.index - a.index : b.val-a.val;
    };
    set = new PriorityQueue<>(c);
    head = new StackNode(-1,-1);
    tail = new StackNode(-1,-1);
    head.next = tail;
    tail.prev = head;
    cnt = 0;
  }

  public void push(int x){
    StackNode node = new StackNode(x,cnt);
    node.next = head.next;
    head.next.prev = node;
    node.prev = head;
    head.next = node;
    set.add(node);
    cnt++;
  }

  public int pop(){
    StackNode node = head.next;
    node.next.prev = head;
    head.next = node.next.prev;
    set.remove(node);
    return node.val;
  }

  public int top(){
    return head.next.val;
  }

  public int peekMax(){
    return set.peek().val;
  }

  public int popMax(){
    StackNode st = set.poll();
   st.next.prev = st.prev;
   st.prev.next = st.next;
   return st.val;

  }

}

class MaxStack1 {

   private TreeSet<int[]> set;
   TreeSet<int[]> stack;
   int c = 0;
    public MaxStack1() {
       Comparator<int[]> c = (a,b) ->
       { 
         return a[0] - b[0] == 0 ? a[1] - b[1] : a[0]-b[0];
        };
    set = new TreeSet<>(c);
    stack = new TreeSet<>(c);
    }
    
    public void push(int x) {
        set.add(new int[]{x,c});
        stack.add(new int[]{c,x});
        c++;
    }
    
    public int pop() {
        int[] val = stack.pollLast();
        set.remove(new int[]{val[1],val[0]});
        return val[1];
    }
    
    public int top() {
        return stack.last()[1];
    }
    
    public int peekMax() {

        return set.last()[0];
    }
    
    public int popMax() {
       int[] x = set.pollLast();
      stack.remove(new int[]{x[1],x[0]});
       return x[0];
    }
}

class StackNode{
  public int val,index;
  public StackNode next;
  public StackNode prev;
  public StackNode(int val,int index){
    this.val = val;
    this.index =index;
    this.next=null;
    this.prev = null;
  }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
