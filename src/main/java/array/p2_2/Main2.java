package array.p2_2;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] arr = new int[N];
        int cnt = 1;

        for (int i = 0; i < N; i++) arr[i] = readInt();

        boolean flag = true;
        for (int i = 1; i < N; i++) { // 나의 위치
            for (int j = i - 1; j >= 0; j--) { // 앞사람 위치
                if (arr[j] >= arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
            flag = true;
        }

        System.out.println(cnt);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
