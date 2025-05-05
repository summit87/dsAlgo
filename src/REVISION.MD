#### Graph

* <b>Dijaksta algo </b> : 

    * This algo work for weight  > 0 , we use this algo to find minimum cost to reach from source to destination
    * We use priority queue to store the vertices , sorting in priority queue will be done based on weight of the edge
    * Time complexity of the algoritham is O(Elog(V)) , if we have E edge , then for each edge at most once the vertices will be stored in heap with time complexity Log(V) , for E edge TC = Elog(V)

* <b>Union and Find Algo : </b>
    
    * Normal disjoint algoritham will be taking linear time for search , since normal DSU implementation will create skew tree

        * 
    * Disjoint set by size and rank will take log(n) time to find the destination
