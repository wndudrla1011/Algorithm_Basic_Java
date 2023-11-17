package stack_queue.응급실;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt(); //찾고 있는 환자
        Queue<int[]> q = new LinkedList<>();
        int ans = 1;

        for (int i = 0; i < N; i++) {
            q.offer(new int[]{i, readInt()});
        }

        while (!q.isEmpty()) {
            int[] urgent = q.peek();
            //현재 환자보다 위험도가 높은 환자 찾기
            for (int i = 0; i < q.size() - 1; i++) {
                q.offer(q.poll());
                int[] next = q.peek();
                if (urgent[1] < next[1]) {
                    urgent = next;
                }
            }
            if (M == urgent[0]) break; //환자 찾음
            else while (q.peek()[0] != urgent[0]) q.offer(q.poll()); //가장 위험한 환자를 앞으로
            q.poll(); //선정된 환자 제외
            ans++;
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
