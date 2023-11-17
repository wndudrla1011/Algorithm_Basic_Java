package stack_queue.교육과정설계;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Essential = br.readLine();
        String Plan = br.readLine();
        Queue<Character> q = new LinkedList<>();

        for (char e : Essential.toCharArray()) {
            q.offer(e);
        }

        for (char p : Plan.toCharArray()) {
            if (q.isEmpty()) break;
            if (p == q.peek()) q.poll();
        }

        System.out.println(q.size() > 0 ? "NO" : "YES");
    }

}
