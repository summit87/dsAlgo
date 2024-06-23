package interview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OneApp {

  public static void main(String[] args) throws FileNotFoundException {
    countTrip("trip.txt");
  }

  private static int countTrip(String fileName) throws FileNotFoundException {
    List<TripInfo> tripInfo = new ArrayList<>();
    Scanner sc = new Scanner(new FileInputStream(fileName));
    while (sc.hasNext()) {
      String[] s = sc.nextLine().split(",");
      tripInfo.add(
          new TripInfo(
              Integer.parseInt(s[0]),
              Integer.parseInt(s[2].substring(0, s[2].length() - 1)),
              s[1],
              s[3]));
    }

    int countTrip = 0;
    Map<String, List<TripInfo>> map =
        tripInfo.stream()
            .collect(Collectors.groupingBy(TripInfo::getPlatNumber, Collectors.toList()));
    for (Map.Entry<String, List<TripInfo>> map1 : map.entrySet()) {
      int tripCount = 0;
      for (int round = 0; round < (map1.getValue().size() / 4); round++) {

        List<TripInfo> trip =
            map1.getValue().subList(round, round + 4).stream()
                .sorted(
                    Comparator.comparing(TripInfo::getTimestamp)
                        .thenComparing(TripInfo::getPetrolPoint))
                .collect(Collectors.toList());
        int i = 1;
        if (trip.size() < 4) {
          break;
        }
        for (; i < 4; i++) {
          if (trip.get(i - 1).getTimestamp() > trip.get(i).getTimestamp()
              || trip.get(i - 1).getPetrolPoint() > trip.get(i).getPetrolPoint()) {
            break;
          }
        }

        if (i == trip.size()) {
          countTrip++;
        }
      }
    }
    System.out.println(countTrip);
    return 0;
  }
}

class TripInfo {

  private Integer timestamp;
  private Integer petrolPoint;
  private String plateNumber;
  private String entryPoint;

  public TripInfo(Integer ts, Integer pp, String pn, String ep) {
    this.entryPoint = ep;
    this.petrolPoint = pp;
    this.plateNumber = pn;
    this.timestamp = ts;
  }

  public Integer getTimestamp() {
    return this.timestamp;
  }

  public Integer getPetrolPoint() {
    return this.petrolPoint;
  }

  public String getPlatNumber() {
    return this.plateNumber;
  }

  public String getEntryPoint() {
    return this.entryPoint;
  }

  @Override
  public String toString() {
    return String.format(
        "{ %s ,%s ,%s ,%s }",
        this.getTimestamp(), this.getPlatNumber(), this.getPetrolPoint(), this.getEntryPoint());
  }
}
