package leetCode;
public class LeetCode547 {
    public static void main(String[] args) {
        // int[][] isConnected = {{1,0},{1,1}};
        // System.out.println(findNebhours(isConnected));
        String s="hot";
        String s1  = "dot";
       
    }

    public static int findNebhours(int[][] isConnected){
        int numbers = isConnected.length;
        int[] size = new int[isConnected.length];
        int[] root = new int[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            size[i] = 1;
            root[i] = i;
        }
        for(int i = 0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j] == 1){
                    numbers-=union(size, root, i, j);
                }
            }
        }
        return numbers;
    }

    public static int findRoot(int[] root,int src){
        if(root[src]== src){
            return src;
        }
        return findRoot(root,root[src]);
    }

    public static int union(int[] size,int[] root,int root1,int root2){
        int r1 = findRoot(root, root1);
        int r2 = findRoot(root, root2);
        if(r1 == r2){
            return 0;
        }

        if(size[r1] < size[r2]){
            root[r1] = r2;
            size[r2]+=size[r1];
        }else if(size[r1] > size[r2]){
            size[r1]+=size[r2];
            root[r2] = r1;
        }else{
            size[r2]+=size[r1];
            root[r1] = r2;
        }
        return 1;
    }
}
