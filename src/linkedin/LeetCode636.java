package linkedin;

import java.util.Stack;

/**
 * 
 * On a single-threaded CPU, we execute a program containing n functions. Each
 * function has a unique ID between 0 and n-1.
 * 
 * Function calls are stored in a call stack: when a function call starts, its
 * ID is pushed onto the stack, and when a function call ends, its ID is popped
 * off the stack. The function whose ID is at the top of the stack is the
 * current function being executed. Each time a function starts or ends, we
 * write a log with the ID, whether it started or ended, and the timestamp.
 * 
 * You are given a list logs, where logs[i] represents the ith log message
 * formatted as a string "{function_id}:{"start" | "end"}:{timestamp}". For
 * example, "0:start:3" means a function call with function ID 0 started at the
 * beginning of timestamp 3, and "1:end:2" means a function call with function
 * ID 1 ended at the end of timestamp 2. Note that a function can be called
 * multiple times, possibly recursively.
 * 
 * A function's exclusive time is the sum of execution times for all function
 * calls in the program. For example, if a function is called twice, one call
 * executing for 2 time units and another call executing for 1 time unit, the
 * exclusive time is 2 + 1 = 3.
 * 
 * Return the exclusive time of each function in an array, where the value at
 * the ith index represents the exclusive time for the function with ID i.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * Output: [3,4]
 */
public class LeetCode636 {
    public static void main(String[] args) {
        String[] logs = { "0:start:0", "1:start:2", "1:end:5", "2:start:6", "2:end:9", "0:end:11" };
        int n = 3;
        // for (int v : getVal(logs, n)) {
        //     System.out.print(v + ",");
        // }

        System.out.println(823%6);
    }

    private static int[] getVal(String[] str, int n) {
        Stack<Integer> st = new Stack<>();

        int[] res = new int[n];
        String[] s = str[0].split(":");
        int time = Integer.valueOf(s[2]);
        st.push(Integer.valueOf(s[0]));
        for (int i = 1; i < str.length; i++) {
            s = str[i].split(":");
            while (time < Integer.valueOf(s[2])) {
                res[st.peek()]++;
                time++;
            }

            if ("start".equalsIgnoreCase(s[1])) {
                int val = Integer.valueOf(s[0]);
                st.push(val);

            } else if ("end".equalsIgnoreCase(s[1])) {
                res[st.peek()]++;
                st.pop();
                time++;
            }
        }

        return res;
    }

    /**
     * String[]
     * logs={"0:start:0","1:start:2","1:end:5","2:start:6","2:end:9","0:end:11"};
     * 
     * @return
     */
    public static int[] val(String[] str, int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (String s : str) {
            String[] s1 = s.split(":");
            if (st.isEmpty()) {
                int val = Integer.parseInt(s1[0]);
                st.push(val);
                res[val] = Integer.parseInt(s1[2]);
                continue;
            }

            if("start".equalsIgnoreCase(s1[1])){

            }
        }
        return res;
    }

}
