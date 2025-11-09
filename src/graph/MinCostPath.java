package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given list of the connecte city , find the total min cost from source to
 * destination city
 * 
 * e.g : // The list of (city1, city2, cost) from the example
 * static List<String[]> flightsData = Arrays.asList(
 * new String[]{"A", "B", "10"},
 * new String[]{"A", "C", "30"},
 * new String[]{"B", "D", "50"},
 * new String[]{"C", "D", "20"},
 * new String[]{"C", "E", "60"},
 * new String[]{"D", "E", "10"}
 * );
 */
public class MinCostPath {

    public static void main(String[] args) {
        List<String[]> flightsData = Arrays.asList(new String[] { "NYC", "LHR", "450" },
                new String[] { "NYC", "LAX", "300" }, new String[] { "LAX", "SFO", "150" },
                new String[] { "LAX", "NRT", "680" }, new String[] { "SFO", "NRT", "650" },
                new String[] { "DFW", "LAX", "180" },
                new String[] { "DFW", "GRU", "550" }, new String[] { "BOS", "LHR", "350" },
                new String[] { "BOS", "NYC", "100" },
                new String[] { "GRU", "SCL", "160" }, new String[] { "BOG", "MIA", "220" },
                new String[] { "BOG", "SCL", "100" },
                new String[] { "LHR", "CDG", "110" }, new String[] { "LHR", "FRA", "120" },
                new String[] { "CDG", "AMS", "90" },
                new String[] { "CDG", "IST", "250" }, new String[] { "FRA", "LHR", "130" },
                new String[] { "FRA", "MAD", "200" },
                new String[] { "AMS", "FRA", "90" }, new String[] { "MAD", "CDG", "150" },
                new String[] { "MAD", "ATH", "220" },
                new String[] { "ATH", "IST", "150" }, new String[] { "IST", "DXB", "310" },
                new String[] { "IST", "ATH", "180" },
                new String[] { "FRA", "NYC", "500" }, new String[] { "AMS", "NYC", "480" },
                new String[] { "LHR", "NYC", "430" },
                new String[] { "DXB", "SIN", "300" }, new String[] { "DXB", "CPT", "600" },
                new String[] { "DXB", "JNB", "550" },
                new String[] { "SIN", "NRT", "280" }, new String[] { "SIN", "SYD", "400" },
                new String[] { "NRT", "SIN", "290" },
                new String[] { "SYD", "LAX", "800" }, new String[] { "SYD", "DXB", "700" },
                new String[] { "JNB", "CPT", "180" },
                new String[] { "JNB", "DXB", "520" }, new String[] { "JNB", "LHR", "500" },
                new String[] { "CPT", "LHR", "690" },
                new String[] { "JNB", "GRU", "650" }, new String[] { "GRU", "BOG", "180" },
                new String[] { "SCL", "DFW", "500" });
        System.out.println(minCost(flightsData, "NYC", "CPT"));
    }

    public static int minCost(List<String[]> list, String source, String target) {
        Map<String, List<CityNode>> cityMap = new HashMap<>();
        Map<String, Integer> costMap = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        int minCost = Integer.MAX_VALUE;
        for (String[] s : list) {
            CityNode cityNode = new CityNode(s[1], Integer.parseInt(s[2]));
            cityMap.putIfAbsent(s[0], new ArrayList<>());
            cityMap.get(s[0]).add(cityNode);
            costMap.put(s[1], minCost);
            map.put(s[1], null);
        }
        costMap.put(source, 0);
        costMap.put(target, minCost);
        map.put(source, source);

        Queue<CityNode> queue = new LinkedList<>();
        CityNode sourceCity = new CityNode(source, 0);
        queue.add(sourceCity);
        while (!queue.isEmpty()) {
            CityNode cityNode = queue.poll();
            if (cityNode.getCost() > costMap.get(cityNode.getCity())) {
                continue;
            }
            if (!cityMap.containsKey(cityNode.getCity())) {
                break;
            }
            for (CityNode city : cityMap.get(cityNode.getCity())) {
                int temp = city.getCost() + cityNode.getCost();
                if (costMap.get(city.getCity()) > temp) {

                    city.setCost(temp);
                    costMap.put(city.getCity(), temp);
                    map.put(city.getCity(), cityNode.getCity());
                    queue.add(city);
                }
            }
        }
        List<String> path = new ArrayList<>();
        String originalTarget = target;
        while (map.containsKey(target) && !target.equals(source)) {
            path.add(target);
            target = map.get(target);
        }
        path.add(source);
        System.out.println(path);
        return costMap.get(originalTarget);
    }

}

class CityNode {
    private String cityName;
    private int cost;

    public CityNode(String city, int cost) {
        this.cityName = city;
        this.cost = cost;
    }

    public void setCityName(String city) {
        this.cityName = city;
    }

    public String getCity() {
        return this.cityName;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
