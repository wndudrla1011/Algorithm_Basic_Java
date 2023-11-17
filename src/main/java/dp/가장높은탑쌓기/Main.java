package dp.가장높은탑쌓기;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt(); //벽돌의 수
        List<Brick> A = new ArrayList<>();
        int[] dp = new int[N]; //A.get(i)를 꼭대기로 하는 최대 탑 높이
        int ans = 0;

        for (int i = 0; i < N; i++) {
            A.add(new Brick(readInt(), readInt(), readInt()));
        }

        Collections.sort(A);

        dp[0] = A.get(0).height;
        int max;
        for (int i = 1; i < N; i++) {
            max = A.get(i).height; //현재 벽돌 높이
            for (int j = i - 1; j >= 0; j--) {
                if (A.get(i).weight < A.get(j).weight) //더 무거운 것이 있으면
                    max = Math.max(max, dp[j] + A.get(i).height); //높이 합하기
            }
            dp[i] = max;
        }

        for (int d : dp) ans = Math.max(ans, d);

        System.out.println(ans);
    }

    static class Brick implements Comparable<Brick> {
        int bottom;
        int height;
        int weight;

        public Brick(int bottom, int height, int weight) {
            this.bottom = bottom;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.bottom - this.bottom; //밑면 넓이 내림차순
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
