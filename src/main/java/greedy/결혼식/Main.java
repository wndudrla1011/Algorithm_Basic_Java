package greedy.결혼식;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        List<Schedule> schedules = new ArrayList<>();
        int ans = Integer.MIN_VALUE, cnt = 0;

        for (int i = 0; i < N; i++) {
            schedules.add(new Schedule(readInt(), 's'));
            schedules.add(new Schedule(readInt(), 'e'));
        }

        Collections.sort(schedules);

        for (Schedule elem : schedules) {
            if (elem.state == 's') cnt++; //도착
            else cnt--; //떠남
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }

    static class Schedule implements Comparable<Schedule> {
        int time; //시간
        int state; //상태 (s:도착 or e:떠남)

        public Schedule(int time, int state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Schedule o) {
            if (this.time == o.time) return this.state - o.state; //e부터 나오도록
            return this.time - o.time; //시간 오름차순
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
