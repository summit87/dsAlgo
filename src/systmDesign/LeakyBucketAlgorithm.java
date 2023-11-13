package systmDesign;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/** Assuming 3 request per second */
public class LeakyBucketAlgorithm {
  public static void main(String[] args) {
    UserBucket userBucket = new UserBucket(Instant.now(), new LinkedBlockingDeque<>(3));
    Map<String, UserBucket> mapping = new HashMap<>();
    mapping.put("1", userBucket);
    for (int i = 0; i < 5; i++) {
      Instant lastUpdateTs = mapping.get("1").getLastUpdateTs();
      Instant instant = lastUpdateTs.plusSeconds(1);
      try {
        Thread.sleep(999);
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
      Instant now = Instant.now();
      if (now.compareTo(instant) < 1 && mapping.get("1").getBlockingDeque().size() > 3) {
        System.out.println("Request reach more than threshold");
        continue;
      }

      UserBucket userBucket1 = mapping.get("1");
      BlockingDeque<Integer> blockingDeque = userBucket1.getBlockingDeque();
      if (now.compareTo(instant) >= 1) {
        System.out.println("Adding new bucket");
        blockingDeque = new LinkedBlockingDeque<>(3);
      }
      blockingDeque.add((i + 1));
      userBucket1.setBlockingDeque(blockingDeque);
      userBucket1.setLastUpdateTs(now);
      mapping.put("1", userBucket1);
      System.out.println("Processing request + " + (i + 1) + " : " + blockingDeque.size());
    }
  }
}

class UserBucket {
  private Instant lastUpdateTs;
  private BlockingDeque<Integer> blockingDeque;

  public UserBucket(Instant lastUpdateTs, BlockingDeque<Integer> blockingDeque) {
    this.lastUpdateTs = lastUpdateTs;
    this.blockingDeque = blockingDeque;
  }

  public Instant getLastUpdateTs() {
    return lastUpdateTs;
  }

  public void setLastUpdateTs(Instant lastUpdateTs) {
    this.lastUpdateTs = lastUpdateTs;
  }

  public BlockingDeque<Integer> getBlockingDeque() {
    return blockingDeque;
  }

  public void setBlockingDeque(BlockingDeque<Integer> blockingDeque) {
    this.blockingDeque = blockingDeque;
  }
}
