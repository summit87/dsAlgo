package dsu;

public class DSUBySize {
    public static void main(String[] args) {
        
        int n = 5;
        int[] size = new int[n];
        int[][] edges = {{0,0},{0,1},{1,2},{3,4},{1,4}};
        int[] root = new int[n];
        int[] rank = new int[n];
        for(int i=0;i<n;i++){
            root[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
        // for(int[] edge : edges){
        //     if(edge[0] == edge[1]) continue;
        //     unionBySize(root, edge[0], edge[1], size);

        // }

        for(int[] ed : edges){
            if(ed[0] == ed[1]) continue;
            unioinByRank(root, ed[0], ed[1], rank);
        }

       for(int i=0;i<n;i++){
        System.out.print(find1(root, i)+",");
       }


    }

    public static int find1(int[] nodes,int src){
        if(nodes[src] == src){
            return src;
        }
       
        return find(nodes, nodes[src]);
    }

    public static int find(int[] nodes,int src){
        if(nodes[src] == src){
            return src;
        }
        return find(nodes, nodes[src]);
    }

    public static void unionBySize(int[] nodes,int src1,int src2,int[] size){
        int root1 = find(nodes, src1);
        int root2 = find(nodes, src2);
        if(size[root1] < size[root2]){
            nodes[root1] = root2;
            size[root2]+=size[root1];
        }else{
            nodes[root2] = root1;
            size[root1] +=size[root2];
        }
    }

    public static void unioinByRank(int[] root,int src1,int src2,int[] rank){
        int root1 = find(root, src1);
        int root2 = find(root, src2);
        if(rank[root1] < rank[root2]){
            //rank[root2]++;
            root[root1] = root2;
        }else if(rank[root2] < rank[root1]){
            //rank[root1]++;
            root[root2] = root1;
        }else{
            rank[root1]++;
            root[root2] = root1;
        }
    }
}
