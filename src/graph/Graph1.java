package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.*;
import java.util.Scanner;

import dp.LIS;

public class Graph1 {
    public static void main(String[] args) throws FileNotFoundException {
        Graph2 graph2 = new Graph2("g11.txt");
        //List<Integer> list = graph2.getMap().get(1);
        System.out.println("out "+graph2.getOutDegree().get(3));
        System.out.println("inde : "+graph2.getOutDegree().get(3));
        //System.out.println(list);
    }
}

class Graph2{
    private Map<Integer,List<Integer>> map;
    private Map<Integer,Integer> inDegreeMap;
    private Map<Integer,Integer> outDegreeMap;
    public Graph2(String fileName) throws FileNotFoundException{
        map = new HashMap<>();
        inDegreeMap = new HashMap<>();
        outDegreeMap = new HashMap<>();
        Scanner sc = new Scanner(new File(fileName));
        while(sc.hasNext()){
            String[] s = sc.nextLine().split(",");
            addEdge(map, Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
    }

    public Map<Integer,List<Integer>> getMap(){
        return map;
    }

    public void addEdge(Map<Integer,List<Integer>> map , int src,int dest){
        List<Integer> list = new ArrayList<>();
        Integer inDegree = 0;
        Integer outDegere = 0;
        if(map.containsKey(src)){
            list = map.get(src);
            outDegere = outDegreeMap.get(src);
        }
        if(inDegreeMap.containsKey(dest)){
            inDegree = inDegreeMap.get(dest);
        }
        outDegere++;
        inDegree++;
        list.add(dest);
        map.put(src, list);
        inDegreeMap.put(dest, inDegree);
        outDegreeMap.put(src, outDegere);
    }

    public Map<Integer,Integer> getIndegree(){
        return inDegreeMap;
    }

    public Map<Integer,Integer> getOutDegree(){
        return outDegreeMap;
    }
}


