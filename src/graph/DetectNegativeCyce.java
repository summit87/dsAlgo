package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;;

public class DetectNegativeCyce {
    public static void main(String[] args) {
        
    }
}

class Graph3{
    private Map<Character,List<WeightNode>> map;
    Map<Character,WeightNode> minDist ;
    public Graph3(String fileName) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(fileName));

    }

    public void addEdge(Character src,Character dest,Integer weight){
        List<WeightNode> list = new ArrayList<>();
        if(map.containsKey(src)){
            list = map.get(src);
        }
        WeightNode weightNode = new WeightNode();
        weightNode.node = dest;
        weightNode.weight = weight;
        list.add(weightNode);
        map.put(src, list);
    }

    public boolean isNegativeWeightCycle(Character src){
        Map<Character,WeightNode> midDistMapp = calculateMinDistMapping(src);
        return false;
    }

    private Map<Character, WeightNode> calculateMinDistMapping(Character src) {
        // TODO Auto-generated method stub
        WeightNode wn = new WeightNode();
        wn.node = src;
        wn.weight = 0;
        minDist.put(src,wn);
        Queue<WeightNode> queue = new LinkedList<>();
        queue.add(wn);
        while(!queue.isEmpty()){
            WeightNode wn1 =queue.poll();
            List<WeightNode> list= map.get(wn.node);
            for(WeightNode ch :  list){
              
            }

        }

        throw new UnsupportedOperationException("Unimplemented method 'calculateMinDistMapping'");
    }
}

class WeightNode{
    public Character node;
    public Integer weight;
}
