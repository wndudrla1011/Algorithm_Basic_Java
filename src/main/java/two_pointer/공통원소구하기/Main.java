package two_pointer.공통원소구하기;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int p1 = 0, p2 = 0;
        while (p1 < N && p2 < M) {
            if (A[p1] == B[p2]) {
                ans.append(A[p1]).append(' ');
                p1++;
                p2++;
            }
            else if (A[p1] > B[p2]) p2++;
            else p1++;
        }

        System.out.println(ans);
    }

}
