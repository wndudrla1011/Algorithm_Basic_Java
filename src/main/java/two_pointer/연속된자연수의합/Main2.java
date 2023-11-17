package two_pointer.연속된자연수의합;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0, cnt = 1;

        N--;
        while (N > 0) {
            cnt++;
            N = N - cnt;
            if (N % cnt == 0) ans++;
        }

        System.out.println(ans);
    }

}
