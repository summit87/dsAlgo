package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;;

/**
 * How to indeitfy the eulerian path
 * 1. zero or two node should have the odd degree , if we have node more then 2 with odd vertices , then graph does not have 
 *    Eulerian path
 * 2. if node have zero edges then that node will called as semi eulerian
 * 3. All the node should be visited , if any of the node is not visited and having size > 0, then the graph will not have eulerian path/circle 
 */

/**
 * this is for direcrted graph
 */

public class EulerianPath {
    public static void main(String[] args) {

    }
}

class Graph12 {
    private Map<Integer, List<Integer>> map;
    private Set<Integer> visited;
    int numOfVertex;

    public Graph12(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        numOfVertex = scanner.nextInt();
        map = new HashMap<>();
        while (scanner.hasNext()) {
            String[] s = scanner.next().split(",");
            Integer src = Integer.parseInt(s[0]);
            Integer dest = Integer.parseInt(s[1]);
            map.putIfAbsent(src, new ArrayList<>());
            map.get(src).add(dest);
        }
    }

    public boolean isEulerian() {
        int oddDegree = 0;
        for (int i = 0; i < numOfVertex; i++) {
            if (map.get(i).size() % 2 != 0) {
                oddDegree++;
            }
        }
        if (oddDegree > 2) {
            return false;
        }

        int i = 0;
        for (i = 0; i < numOfVertex; i++) {
            if (map.get(i).size() != 0) {
                break;
            }
        }

        if (i == numOfVertex) {
            return true;
        }

        dfsUtil(map, 0);

        for (i = 0; i < numOfVertex; i++) {
            if (!visited.contains(i) && map.get(i).size() > 0) {
                return false;
            }
        }

        return true;
    }

    private void dfsUtil(Map<Integer, List<Integer>> map2, int i) {

        visited.add(i);
        List<Integer> list = map.get(i);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer val : list) {
            if (!visited.contains(val)) {
                dfsUtil(map2, val);
            }
        }

    }

}
