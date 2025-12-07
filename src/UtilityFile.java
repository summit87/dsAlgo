import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class UtilityFile {
    public static void main(String[] args) {
    //    int val =  31;
    //     System.out.println(31/4);
    //     System.out.println(31%4);
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.remove(list.size()-1);
        list.add(0, 2);
        System.out.println(list.iterator().next());

        // Sort the HashMap by value;
        int[] a = new int[]{1,2,3,4,1,3,2,5,5};
        Comparator<Map.Entry<Integer,Integer>> c = (a1,b) -> a1.getValue() - b.getValue(); // sort the map by value
        Comparator<Map.Entry<Integer,Integer>> c1 = (a1,b) -> {
            if(a1.getValue().compareTo(b.getValue()) == 0){
                if(a1.getKey().compareTo(b.getKey()) > 0){
                    return -1; // return the value in accending order
                }
                return 1;
            }
            return a1.getValue() - b.getValue();
        }; // sort the map by value
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : a){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        List<Map.Entry<Integer,Integer>> list1 = new ArrayList<>(map.entrySet());
        Collections.sort(list1,c1);
        for(Map.Entry<Integer,Integer> m : list1){
            System.out.println(m.getKey()+" : "+m.getValue());
        }

        

    }



    /**
     * How to sort the 2D array based (represented as co-ordinate system)
     * @param prefix
     * @return
     */
     public static int count(int[][] prefix){
        /**
         * Sort pq in reverseorder using comparator
         * PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
         */
        int[][] a1 = new int[2][2];
         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
       
        int count = 1;
        List<int[]> prefixList = new ArrayList<>();
        for(int i=0;i<prefix.length;i++){
            prefix[i][0] = prefix[i][0] - prefix[i][1];
            prefix[i][1] = prefix[i][0] + prefix[i][1];
            prefixList.add(prefix[i]);
        }
        // sort list of the 1d array
        Collections.sort(prefixList, (int[] a,int[] b) -> (a[0] - b[0]));

        // sort 2d array
        /**
         * 
         *  // sort by x_end
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });
         */
        Arrays.sort(prefix,(int[] a,int[] b) -> (a[0] - b[0]));
        for(int i=0;i<prefixList.size();i++){
            System.out.println(prefixList.get(i)[0]+" : "+prefixList.get(i)[1]);
        }
        return 1;
     }
}
