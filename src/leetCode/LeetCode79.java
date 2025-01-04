package leetCode;

import java.util.*;

public class LeetCode79 {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("cats","dog","sand","and","cat");
        String s = "catsandog";
        isWordExist(s, str);
    }


    public static boolean isWordExist(String s,List<String> str){

        Set<String> set = new HashSet<>(str);
        boolean[] visited = new boolean[s.length()+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int ind = queue.poll();
            if(ind == s.length()){
                System.out.println("FOund");
                break;
            }

            for(int end = ind+1;end <= s.length();end++){
                if(visited[end]){
                    continue;
                }

                if(set.contains(s.substring(ind, end))){
                    queue.add(end);
                    visited[end] = true;
                }
            }
        }
        int i = 0;
        for(boolean f : visited){
            System.out.print("("+i+" : "+f+" ),");
            i++;
        }

        return false;
    }
}
