package stack_queue.p5_6;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int K = readInt();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            q.offer(i);

        while (q.size() > 1) {
            for (int i = 0; i < K - 1; i++)
                q.offer(q.poll());
            q.poll(); //K번째 값 버리기
        }

        System.out.println(q.poll());
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
