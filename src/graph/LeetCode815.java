package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Bus route
 * In this, we will first identify the number of route each stop hold
 * Then add all the route in the queue in the queue
 * then for each route in given stop , check if taget are reaching or not,
 * If target is reaching in this route, the  return numberOfBus
 * else go for next route and increse the count of the bus
 * .
 * .
 * .
 */
/**
 * Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 */
public class LeetCode815 {
    public static void main(String[] args) {
        int[][] routes = {{2},{2,8}};
        int source = 2;
        int target = 8;
        System.out.println(minRoute(routes, source, target));

    }

    @SuppressWarnings({"BoxedValueEquality", "NumberEquality"})
    public static int minRoute(int[][] routes,int source,int target){
        Map<Integer,List<Integer>> stopToRouteMap = new HashMap<>();
        Map<Integer,List<Integer>> routeToRouteMap = new HashMap<>();
        Set<Integer> totalRoute = new HashSet<>();

        for(int ri = 0;ri < routes.length;ri++){
            for(int stop = 0;stop < routes[ri].length;stop++){
                stopToRouteMap.putIfAbsent(routes[ri][stop], new ArrayList<>());
                stopToRouteMap.get(routes[ri][stop]).add(ri);
                
            }
        }

        Set<Integer> visited =new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int x : stopToRouteMap.get(source)){
            queue.add(x);
            visited.add(x);
        }
        totalRoute.add(stopToRouteMap.get(source).get(0));
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int y : routes[v]){
                if(y == target){
                    return totalRoute.size();
                }
                for(int r1 : stopToRouteMap.get(y)){
                    if(visited.contains(r1)){
                        continue;
                    }
                    visited.add(r1);
                    queue.add(r1);
                    totalRoute.add(r1);
                }
            }
        }



        return -1;
    }
}
