package graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class LeetCode310MinHeight {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> order= new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        Scanner sc = new Scanner(new File("mht.txt"));
        int n = sc.nextInt();
        int[] indegre = new int[n];
        while(sc.hasNext()){
            String[] s = sc.next().split(",");
            int src = Integer.parseInt(s[1]);
            int dest = Integer.parseInt(s[0]);
            map.putIfAbsent(src, new ArrayList<>());
            map.putIfAbsent(dest, new ArrayList<>());
            map.get(src).add(dest);
            map.get(dest).add(src);
            indegre[src]++;
            indegre[dest]++;
        }

        for(int i=0;i<n;i++){
            if(indegre[i] == 1){
                queue.add(i);
            }
        }

        while(n >= 2){
            int size = queue.size();
            n -= size;
            for(int i=0;i<size;i++){
                int v = queue.poll();
                List<Integer> list = map.get(v);
                if(list == null){
                    continue;
                }
                for(int ver : list){
                    if (--indegre[ver] == 1) {
                        queue.add(ver);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            order.add(queue.poll());
        }
        System.out.println(indegre[order.get(0)]);

        System.out.println(order);
        
    }
}
