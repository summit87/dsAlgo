package sliding;

import java.util.*;;

public class TemCharacterStringOccurMoreThanOne {
    public static void main(String[] args) {
        List<String> lst = lenghtOfStrig("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        lst.forEach(System.out::println);
    }

    private static List<String> lenghtOfStrig(String s) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String s1 = s.substring(i, i + 10);
            boolean isAdded = set.add(s1);
            if (!isAdded) {
                set1.add(s1);
            }
        }
        list.addAll(set1);
        return list;
    }

}
