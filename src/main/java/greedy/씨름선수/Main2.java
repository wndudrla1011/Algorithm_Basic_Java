package greedy.씨름선수;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int ans = 0; //키가 가장 큰 선수는 무조건 선발
        List<Player> p = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            p.add(new Player(readInt(), readInt()));
        }

        Collections.sort(p); //키 기준 정렬

        int max = Integer.MIN_VALUE;
        for (Player o : p) {
            if (o.weight > max) {
                max = o.weight;
                ans++;
            }
        }

        System.out.println(ans);
    }

    static class Player implements Comparable<Player> {
        int height;
        int weight;

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Player o) {
            return o.height - this.height;
        }
    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            }
            else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
    }

}
