package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingOfArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,2,3,4,1);
       for(String s :   list(list)){
        System.out.println(s);
       }

    }

    public static List<String> list(List<Integer> a){
        List<String> res= new ArrayList<>();
        int[] count = new int[10000];
        int[] count1 = new int[10000];
        Arrays.fill(count, -1);
        Arrays.fill(count1, -1);
        char[] ch1 = new char[a.size()];
        char[] ch2 = new char[a.size()];
        Arrays.fill(ch1, '0');
        Arrays.fill(ch2, '0');
        for(int i=0,j=a.size()-1;i<a.size() && j>=0;i++,j--){
            if(count[a.get(i)] == -1){
                count[a.get(i)] = 0;
                ch1[i] = '0';
            }else{
                ch1[i] = '1';
            }
            if(count1[a.get(j)] == -1){
                count1[a.get(j)] = 0;
                ch2[j] = '0';
            }else{
                ch2[j] = '1';
            }
        }
        
        res.add(String.valueOf(ch1));
        res.add(String.valueOf(ch2));
        return res;
    }
}
