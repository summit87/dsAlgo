package graph;

public class HamitonianPath {
    public static void main(String[] args) {
        int[][] graph = {
                { 0, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1 },
                { 0, 1, 0, 0, 1 },
                { 1, 1, 0, 0, 1 },
                { 0, 1, 1, 1, 0 } 
            };
        int totalVertex = 5;
        int[] path = new int[totalVertex+1];
        for(int i=0;i<totalVertex;i++){
            path[i] = -1;
        }
        path[0] = 0;
        if(isHamiltonian(graph, path, 1, totalVertex)){
            System.out.println("Hamiltotnian path exist");
        }

        printPath(path);
    }

    private static void printPath(int[] path){
        for(int i=0;i<path.length;i++){
            System.out.print(path[i]+" -> ");
        }
        System.out.println();
    }

    private static boolean isSafe(int[][] graph, int[] path, int currentIndex, int pos, int totalVertex) {

        
        if (graph[path[pos - 1]][currentIndex] == 0) {
            return false;
        }

        /**
         * 
         */
        for (int i = 0; i < pos; i++) {
            if (path[i] == currentIndex) {
                return false;
            }
        }
        return true;
    }

    private static boolean isHamiltonian(int[][] graph, int[] path, int pos, int totalVertex) {
        if (pos == totalVertex) {
            if (graph[path[pos - 1]][path[0]] == 1) {
                return true;
            }
            return false;
        }

        for (int i = 1; i < totalVertex; i++) {
            if (isSafe(graph, path, i, pos, totalVertex)) {
                path[pos] = i;
                if (isHamiltonian(graph, path, pos + 1, totalVertex)) {
                    return true;
                }
                path[pos] = -1;
            }
        }

        return false;
    }

}
