package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/?envType=problem-list-v2&envId=sliding-window
 * 
 * The idea to use this algoritham is using uniquness of the character at current window
 * Since question asked is to calculate the length of the max substring size on which we have each character count >= k
 * Now if you see , just because of > with equal increse the complexity , in this kind of condition we don't know when we 
 * need to increse or decrese the window size  .
 * 
 * So we will try to find the longest lenght of the substring which satisfy the consition on the k and longest unique character
 * 1. Now we know maximum unique character is possibe in string is 26 ,
 * 2. Now for each uniquness count , if number of unique is matching , 
 *    then we will be checking the frequency count , if frequency count is satisfying the condition on k, then 
 *    we will calculate the length of the string at this point of time.
 * 3. if for each uniquness count , if numner is more than the allowed maximum frequency , 
 *    then we will reduce the window from left and keep going , untill the number of uniquness is not equal to defined one
 * 
 * final if all the uniquness are exhaustead , then we will return the 
 * 
 * 
 * 
 */
public class LeetCode395 {

    public static void main(String[] args) {
        String str = "aaabb";
        int k = 3;
        System.out.println(longestSubString(str, k));
    }

    public static int longestSubString(String str,int k){
        int maxLen = Integer.MIN_VALUE;
        for(int uc = 1;uc <= uniqueCharacter(str);uc++){
            int left = 0;
            int right=0;
            int unique = 0;
            int countOfUniqueCharForAtleastK=0;
            Map<Character,Integer> map = new HashMap<>();
            while(right < str.length()){
                if(unique <= uc){

                    if(!map.containsKey(str.charAt(right))){
                        unique++;
                    }
                    map.put(str.charAt(right), map.getOrDefault(str.charAt(right),0)+1);
                    /**
                     * This condition make sure, we are counting unique character for each K window
                     */
                    if(map.get(str.charAt(right)) == k){
                        countOfUniqueCharForAtleastK++;
                    }
                    right++;
                }else{
                    if (map.get(str.charAt(left)) == k) {
                        countOfUniqueCharForAtleastK--;
                    }
                    map.put(str.charAt(left), map.get(str.charAt(left))-1);
                    if(map.get(str.charAt(left)) == 0){
                        unique--;
                        map.remove(str.charAt(left));
                    }
                    left++;
                }

                if(unique == uc && unique == countOfUniqueCharForAtleastK){
                    maxLen = Math.max(maxLen, (right-left));
                }
            }

           
        }
        return maxLen;
    }

    public static int uniqueCharacter(String str){
        Set<Character> set = new HashSet<>();
        for(Character ch : str.toCharArray()){
            set.add(ch);
        }

        return set.size();
    }



}
