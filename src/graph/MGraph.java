package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MGraph {
  public static void main(String[] args) throws FileNotFoundException {
    GraphStructure gn = new GraphStructure("g1.txt");
    List<Integer> order = gn.topologicalSorting(gn.getMap(), 4);
    System.out.println(order);
  }
}

class GraphStructure {
  private Map<Integer, GraphNode> map;
  private Set<Integer> visited;
  private Map<Integer, Integer> inDegree;

  public GraphStructure(String fileName) throws FileNotFoundException {
    map = new HashMap<>();
    inDegree = new HashMap<>();
    visited = new HashSet<>();
    Scanner sc = new Scanner(new File(fileName));
    while (sc.hasNext()) {
      String[] s = sc.nextLine().split(",");
      Integer src = Integer.parseInt(s[0]);
      Integer dest = Integer.parseInt(s[1]);
      int ind = 1;
      if (inDegree.containsKey(dest)) {
        ind = inDegree.get(dest) + 1;
      }
      inDegree.put(dest, ind);
      addEdge(src, dest);
    }
  }

  private void addEdge(Integer src, Integer dest) {
    if (map.containsKey(src)) {
      GraphNode gn = map.get(src);
      gn = createList(gn, dest);
      map.put(src, gn);
      return;
    }
    GraphNode gn = createList(null, dest);
    map.put(src, gn);
  }

  private GraphNode createList(GraphNode gn, Integer dest) {
    GraphNode graphNode = new GraphNode(dest);
    if (gn == null) {
      gn = graphNode;
      return gn;
    }
    gn.setNext(createList(gn.getNext(), dest));
    return gn;
  }

  public Map<Integer, GraphNode> getMap() {
    return map;
  }

  public void setMap(Map<Integer, GraphNode> map) {
    this.map = map;
  }

  public Set<Integer> getVisited() {
    return visited;
  }

  public void setVisited(Set<Integer> visited) {
    this.visited = visited;
  }

  public Map<Integer, Integer> getInDegree() {
    return inDegree;
  }

  public void setInDegree(Map<Integer, Integer> inDegree) {
    this.inDegree = inDegree;
  }

  public List<Integer> topologicalSorting(Map<Integer, GraphNode> map, int src) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(src);
    List<Integer> order = new ArrayList<>();
    order.add(src);
    while (!queue.isEmpty()) {
      int v = queue.poll();
      visited.add(v);
      GraphNode gn = map.get(v);
      while (gn != null) {
        if (!visited.contains(gn.getVal()) && inDegree.get(gn.getVal()) > 0) {
          int ind = inDegree.get(gn.getVal());
          ind = ind - 1;
          inDegree.put(gn.getVal(), ind);
          if (ind == 0) {
            visited.add(gn.getVal());
            queue.add(gn.getVal());
            order.add(gn.getVal());
          }
        }
        gn = gn.getNext();
      }
    }
    return order;
  }
}

class GraphNode {
  private GraphNode next;
  private Integer val;

  public GraphNode(Integer dest) {
    this.val = dest;
  }

  public GraphNode getNext() {
    return next;
  }

  public void setNext(GraphNode next) {
    this.next = next;
  }

  public Integer getVal() {
    return val;
  }

  public void setVal(Integer val) {
    this.val = val;
  }
}
