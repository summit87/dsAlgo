package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class DijkstraAlgo {
  public static void main(String[] args) throws FileNotFoundException {
        DijGraphStructure dijGraphStructure = new DijGraphStructure("g2.txt");
        dijGraphStructure.distraitAlgo(0);
  }
}

class DijGraphStructure {
  private Map<Integer, DijGraphNode> map;
  private Set<Integer> visited;
  private Integer numberOfNode;

  public DijGraphStructure(String fileName) throws FileNotFoundException {
    map = new HashMap<>();
    visited = new HashSet<>();
    Scanner scanner = new Scanner(new File(fileName));
    numberOfNode = Integer.parseInt(scanner.nextLine());
    while (scanner.hasNext()) {
      String[] s = scanner.nextLine().split(",");
      Integer src = Integer.parseInt(s[0]);
      Integer dest = Integer.parseInt(s[1]);
      Integer weight = Integer.parseInt(s[2]);
      NodeVal nodeVal = new NodeVal(dest, weight);
      addEdge(src, nodeVal);
    }
  }

  public void distraitAlgo(Integer src) {
    List<NodeVal> nodeValList = new ArrayList<>();
    Integer[] dist = new Integer[numberOfNode];
    Integer[] path = new Integer[numberOfNode];
    for (int i = 0; i < numberOfNode; i++) {
      dist[i] = Integer.MAX_VALUE;
      path[i] = -1;
    }
    dist[src] = 0;
    Queue<NodeVal> queue = new LinkedList<>();
    PriorityQueue<NodeVal> pq = new PriorityQueue<>(Comparator.comparing(NodeVal::getWeight));
    pq.add(new NodeVal(0, 0));
    path[0] = -1;
    while (!pq.isEmpty()) {
      NodeVal v = pq.poll();
      DijGraphNode node = map.get(v.getDest());
      while (node != null) {
        NodeVal d = node.getVal();
        int x = dist[v.getDest()] + d.getWeight();
        if (dist[d.getDest()] > x) {
          dist[d.getDest()] = x;
          pq.add(new NodeVal(d.getDest(), x));
          path[d.getDest()] = v.getDest();
        }
        node = node.getNext();
      }
    }

    for (int i = 1; i < numberOfNode; i++) {
      printPath(path,i);
      System.out.print(i+"  : {"+dist[i]+"} ");
      System.out.println();
    }
  }

  public void printPath(Integer[] path, int p) {
    if (path[p] == -1) {
      return;
    }
    printPath(path, path[p]);
    System.out.print(path[p] + " -> ");
  }

  private void addEdge(Integer src, NodeVal nodeVal) {
    if (map.containsKey(src)) {
      DijGraphNode node = map.get(src);
      node = createAdjList(node, nodeVal);
      map.put(src, node);
      return;
    }
    DijGraphNode dijGraphNode = createAdjList(null, nodeVal);
    map.put(src, dijGraphNode);
  }

  public DijGraphNode createAdjList(DijGraphNode node, NodeVal val) {
    DijGraphNode gn = new DijGraphNode(val);
    if (node == null) {
      node = gn;
      return node;
    }
    node.setNext(createAdjList(node.getNext(), val));
    return node;
  }
}

class NodeVal {
  private Integer dest;
  private Integer weight;

  public NodeVal(Integer dest, Integer weight) {
    this.dest = dest;
    this.weight = weight;
  }

  public Integer getDest() {
    return dest;
  }

  public void setDest(Integer dest) {
    this.dest = dest;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }
}

class DijGraphNode {
  private NodeVal val;
  private DijGraphNode next;

  public DijGraphNode() {}

  public DijGraphNode(NodeVal val) {
    this.val = val;
  }

  public NodeVal getVal() {
    return val;
  }

  public void setVal(NodeVal val) {
    this.val = val;
  }

  public DijGraphNode getNext() {
    return next;
  }

  public void setNext(DijGraphNode next) {
    this.next = next;
  }
}
