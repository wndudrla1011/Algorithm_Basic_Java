package array.멘토링;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt(); //학생 수
        int M = readInt(); //테스트 결과
        int[][] A = new int[M + 1][N + 1];
        int[][] check = new int[N + 1][N + 1]; //짝꿍 히스토리
        int ans = 0; //멘토링 경우의 수

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                A[i][j] = readInt();
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = j + 1; k <= N; k++) {
                    int s1 = A[i][j];
                    int s2 = A[i][k];
                    check[s1][s2] = 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                /*
                * 값이 일치하지 않는다. => 둘 중 하나는 항상 멘토 (멘토-멘티 관계)
                * */
                if (check[i][j] != check[j][i]) {
                    ans++;
                }
            }
        }

        System.out.println(ans / 2); //멘토, 멘티 양쪽 모두 카운팅했으므로 나누기 2
    }

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input <= 32) {
                return isNegative ? n * -1 : n;
            } else if (input == '-')
                isNegative = true;
            else
                n = (n << 3) + (n << 1) + (input & 15);
        }
    }

}
