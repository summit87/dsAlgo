package graph;
/**
 * https://www.geeksforgeeks.org/number-of-hamiltonian-cycle/?ref=lbp
 */
public class NumberOfHamiltonianPath {
    public static void main(String[] args) {
        int n = 6;// number of vertices
        int fact = 1;
        int val = n-1;
        while(val > 1){
            fact *= val;
            val--;
        }

        System.out.println((fact/2));
    }
}
