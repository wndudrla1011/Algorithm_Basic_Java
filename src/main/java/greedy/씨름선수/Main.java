package greedy.씨름선수;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int ans = 1; //키가 가장 큰 선수는 무조건 선발
        List<Player> p = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            p.add(new Player(readInt(), readInt()));
        }

        Collections.sort(p); //키 기준 정렬

        for (int i = 1; i < N; i++) {
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                //키와 몸무게 모두 큰 선수가 존재하는가
                if (p.get(j).weight > p.get(i).weight) {
                    flag = true;
                    break;
                }
            }
            if (!flag) ans++;
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
