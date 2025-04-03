package string.p1_6;

import java.io.*;
import java.util.*;

public class Main3 {

    public static void main(String[] args) throws IOException {
        Queue<Character> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String input = br.readLine();

        for (char c : input.toCharArray()) {
            if (!q.isEmpty()) {
                if (!q.contains(c)) {
                    q.offer(c);
                }
            } else {
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {
            ans.append(q.poll());
        }

        System.out.println(ans);
    }

}
