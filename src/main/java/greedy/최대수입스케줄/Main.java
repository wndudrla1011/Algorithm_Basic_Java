package greedy.최대수입스케줄;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Schedule> pq = new PriorityQueue<>((o1, o2) -> o2.D - o1.D);
        PriorityQueue<Integer> imports = new PriorityQueue<>(Collections.reverseOrder());
        int N = readInt();
        int ans = 0;

        for (int i = 0; i < N; i++) {
            pq.offer(new Schedule(readInt(), readInt()));
        }

        int total_date = pq.peek().D; //가장 긴 날짜

        while (total_date > 0) {
            while (!pq.isEmpty() && pq.peek().D >= total_date) { //해당 날짜에 가능한 강연
                imports.offer(pq.peek().M); //수입 목록에 추가
                pq.poll();
            }
            total_date--; //날짜 차감
            if (!imports.isEmpty()) ans += imports.poll(); //imports 에 추가된 것이 있다면
        }

        System.out.println(ans);
    }

    static class Schedule {
        int M;
        int D;

        public Schedule(int m, int d) {
            M = m;
            D = d;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
