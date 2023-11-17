package two_pointer.연속된자연수의합;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }

        int lt = 0, rt = 0, sum = 0;
        while (rt <= N / 2 + 1) {
            if (sum >= N) {
                if (sum == N) ans++;
                sum -= A[++lt];
            } else {
                sum += A[++rt];
            }
        }

        System.out.println(ans);
    }

}
