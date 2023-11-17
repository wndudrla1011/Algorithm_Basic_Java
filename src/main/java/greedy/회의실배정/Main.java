package greedy.회의실배정;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = readInt(); //회의 수
        List<Timeline> t = new ArrayList<>();
        int ans = 1; //최대 회의 수

        for (int i = 0; i < n; i++) {
            t.add(new Timeline(readInt(), readInt()));
        }

        Collections.sort(t); //종료 시간이 짧은 것부터 (같으면 시작 시간이 짧은 것부터)

        int end = t.get(0).e;
        for (int i = 1; i < n; i++) {
            if (end <= t.get(i).s) { //이전 종료 시간 <= 다음 시작 시간
                end = t.get(i).e;
                ans++;
            }
        }

        System.out.println(ans);
    }

    static class Timeline implements Comparable<Timeline> {
        int s;
        int e;

        public Timeline(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Timeline o) {
            if (this.e == o.e) return this.s - o.s;
            return this.e - o.e;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
