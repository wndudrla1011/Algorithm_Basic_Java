package map_tree.학급회장;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        Map<Character, Integer> board = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char cdd = input.charAt(i);
            board.put(cdd, board.getOrDefault(cdd, 0) + 1);
        }

        int max = 0;
        char ans = ' ';
        for (Map.Entry<Character, Integer> entry : board.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }

        System.out.println(ans);
    }

}
