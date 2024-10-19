import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class FIndCycleInGraphUsingTopo {
    public static void main(String[] args) throws FileNotFoundException {
        Graph11 graph11 = new Graph11("topo1.txt");
        System.out.println(graph11.isCycle());
    }
}

class Graph11{
    Map<Integer,List<Integer>> map;
    List<Integer> order;
    Map<Integer,Integer> indegre;
    private int ver;
    public Graph11(String fileName) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(fileName));
        map = new HashMap<>();
        order = new ArrayList<>();
        indegre = new HashMap<>();
        ver = scanner.nextInt();
        while (scanner.hasNext()) {
            String[] s = scanner.next().split(",");
            Integer src = Integer.parseInt(s[0]);
            Integer dest = Integer.parseInt(s[1]);
            addEdge(src,dest);
        } 
        scanner.close();
    }

    public void addEdge(Integer src,Integer dest){
        List<Integer> list = new ArrayList<>();
        if(map.containsKey(src)){
            list = map.get(src);
        }
        int ind = 1;
        if(indegre.containsKey(dest)){
            ind = indegre.get(dest)+1;
        }
        indegre.put(dest, ind);
        list.add(dest);
        map.put(src, list);
    }

    public boolean isCycle(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<ver;i++){
            if(!indegre.containsKey(i)){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int v = queue.poll();
            order.add(v);
            List<Integer> list = map.get(v);
            if (list == null) {
                continue;
            }
            for(Integer val : list){
                if(indegre.containsKey(val) && indegre.get(val) > 0){
                    int v1 = indegre.get(val)-1;
                    indegre.put(val, v1);
                    if(v1 == 0){
                        queue.add(val);
                    }
                }
            }
        }
        if(order.size() != ver){
            return true;
        }
        return false;
    }
}
