package dsu;

public class Dsu1 {
    /**
     *  uf.union(1, 2);
        uf.union(3, 4);
     * @param args
     */
    public static void main(String[] args) {
     
        int num =5;
        int[] root = new int[num];
        for(int i=0;i<num;i++){
            root[i] = i;
        }

        unioin(root, 1, 2);
        unioin(root, 3, 4);
        System.out.println((findRoot(root,1))+" : "+(findRoot(root, 3)));

    }


    public static int findRoot(int[] root, int val){
        if(root[val] == val){
            return val;
        }

        return findRoot(root, root[val]);
    }

    public static void unioin(int[] root, int val1,int val2){
        int rv1 = findRoot(root, val1);
        int rv2 = findRoot(root, val2);
        if(rv1 == rv2){
            return;
        }

        root[rv1] = rv2;
    }
}
