package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode895 {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
class FreqStack {

    Map<Integer,Stack<Integer>> stMap;
    Map<Integer,Integer> freqMap;
    int freq;
    public FreqStack() {
        stMap = new HashMap<>();
        freqMap = new HashMap<>();    
        freq = 0;
    }
    
    public void push(int val) {
        int count = 1;
        if(freqMap.containsKey(val)){
            count+=freqMap.get(val);
        }
        freqMap.put(val, count);
        freq = Math.max(freq,freqMap.get(val));
        Stack<Integer> st = new Stack<>();
        if(stMap.containsKey(count)){
            st = stMap.get(count);
        }
        st.add(val);
        stMap.put(count,st);
    }
    
    public int pop() {
        int val = stMap.get(freq).pop();
        freqMap.put(val,freq-1);
        if(stMap.containsKey(freq) && stMap.get(freq).isEmpty()){
            stMap.remove(freq);
            freq--;
        }
        return val;
    }
}