package leetCode;

/**
 * https://leetcode.com/problems/find-the-celebrity/description/
 */
public class LeetCode277 {
    public static void main(String[] args) {
        int n = 0;
        int person = 0;
        for(int i=0;i<n;i++){
            if(i != person /**&& knows(person,i)*/){
                person = i;
            }
        }

        for(int i=0;i< n;i++){
            if(person != i /**(knows(person,i) || ! knows(i,person))*/){
               // print -1
            }
        }

        // print person
    }

}
