package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LeetCode380 {
    public static void main(String[] args) {
        InsertDelete insertDelete = new InsertDelete();
        insertDelete.insert(1);
        insertDelete.insert(2);
        insertDelete.insert(5);
        insertDelete.insert(9);
        insertDelete.insert(10);
        System.out.println(""+insertDelete.remove(2));
        System.out.println(insertDelete.getRandom());
    }

}

class InsertDelete {
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public InsertDelete() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val){
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size());
        return true;
    }

    public boolean remove(int val){
        if(!map.containsKey(val)){
            return false;
        }
        int ind = map.remove(val);
        int newVal = list.get(list.size()-1);
        list.set(ind, newVal);
        map.put(newVal,ind);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom(){
        return list.get(new Random().nextInt(0,list.size()));
    }
}
