package string.p1_10;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        String c = st.nextToken();
        int left = 0; //이전 c가 등장한 위치
        int right = str.indexOf(c); //다음 c가 등장하는 위치
        int distL, distR, i;

        for (i = 0; i <= right; i++)
            ans.append(right - i).append(' ');

        left = right;
        right = str.indexOf(c, i);

        for (int j = i; j < str.length(); j++) {
            distL = j - left; //left 로부터 거리
            distR = right - j; //right 로부터 거리

            if (right == -1) { //마지막 c 다음부터
                ans.append(distL).append(' ');
                continue;
            }

            if (distL < distR)
                ans.append(distL).append(' ');
            else
                ans.append(distR).append(' ');

            if (j == right) {
                left = right;
                right = str.indexOf(c, j + 1);
            }
        }

        System.out.println(ans);
    }

}
