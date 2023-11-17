package map_tree.아나그램;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String w1 = br.readLine();
        String w2 = br.readLine();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : w1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : w2.toCharArray()) {
            if (!map.containsKey(c)) {
                System.out.println("NO");
                return;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        for (int value : map.values()) {
            if (value > 0) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

}
