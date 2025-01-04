package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeAllValue {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> val = new ArrayList<>();
        int[] a = {2,3,6,7};
        int targetSum = 7;
        coinChangeValue1(list, targetSum, a, 0, val);
        System.out.println(list);

    }


    public static void coinChangeValue(List<List<Integer>> res ,int targetSum,int[] a,int index,List<Integer> val){
        if(index>a.length ||  targetSum < 0){
            return;
        }

        if(targetSum == 0){
            res.add(new ArrayList<>(val));
            return;
        }
      for(int i = index;i < a.length;i++){
        val.add(a[i]);
        coinChangeValue(res, targetSum-a[i], a, i, val);
        val.remove(val.size()-1);
      }
        
    }

    public static void coinChangeValue1(List<List<Integer>> res ,int targetSum,int[] a,int index,List<Integer> val){
        if(index==a.length ||  targetSum < 0){
            if(index == a.length && targetSum == 0){
                res.add(val);
            }
            return;
        }

       
        if(targetSum == 0){
            res.add(new ArrayList<>(val));
            return;
        }
        if(targetSum >= a[index] ){
         val.add(a[index]);
         coinChangeValue1(res, targetSum-a[index], a, index, val);
         val.remove(val.size()-1);
        }
        
        coinChangeValue1(res, targetSum, a, index+1, val);
      
        
    }
}
