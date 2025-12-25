package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode1797 {

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5);
        authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
        authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
        System.out.println(authenticationManager.countUnexpiredTokens(6)); // The token with tokenId "aaa" is the only unexpired one at time
                                                       // 6, so return 1.
        authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
        authenticationManager.renew("aaa", 8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time
                                               // 8 the renew request is ignored, and nothing happens.
        authenticationManager.renew("bbb", 10); // The token with tokenId "bbb" is unexpired at time 10, so the renew
                                                // request is fulfilled and now the token will expire at time 15.
        System.out.println(authenticationManager.countUnexpiredTokens(15)); // The token with tokenId "bbb" expires at time 15, and the
                                                        // token with tokenId "aaa" expired at time 7, so currently no
                                                        // token is unexpired, so return 0.

    }

}

class AuthenticationManager {

    private TreeMap<Integer, List<String>> ttlToTokensMapping;
    private Map<String, Integer> tokenToTTLMap;
    private int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        ttlToTokensMapping = new TreeMap<>();
        tokenToTTLMap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        int ttl = this.timeToLive + currentTime;
        tokenToTTLMap.put(tokenId, ttl);
        ttlToTokensMapping.putIfAbsent(ttl, ttlToTokensMapping.getOrDefault(ttl, new ArrayList<>()));
        ttlToTokensMapping.get(ttl).add(tokenId);
    }

    public void renew(String tokenId, int currentTime) {
        if (!tokenToTTLMap.containsKey(tokenId)) {
            return;
        }
        Integer ttl = tokenToTTLMap.get(tokenId);
        if (ttl < currentTime) {
            return;
        }
        Integer newTTL = this.timeToLive + currentTime;
        tokenToTTLMap.put(tokenId, newTTL);
        ttlToTokensMapping.get(ttl).remove(tokenId);
        ttlToTokensMapping.putIfAbsent(newTTL, ttlToTokensMapping.getOrDefault(newTTL, new ArrayList<>()));
        ttlToTokensMapping.get(newTTL).add(tokenId);
    }

    public int countUnexpiredTokens(int currentTime) {
       
        int count = 0;
        for(Map.Entry<Integer,List<String>> m : ttlToTokensMapping.entrySet()){
           if(m.getKey() > currentTime){
            count++;
           }
        }
        return count;
    }
}
