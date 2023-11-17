package string.암호;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String cipher = br.readLine();

        while (N-- > 0) {
            String piece = cipher.substring(0, 7);
            StringBuilder tmp = new StringBuilder(); //이진수
            int num = 0; //이진수 계산값

            for (char c : piece.toCharArray()) {
                if (c == '#') tmp.append(1);
                else tmp.append(0);
            }

//            for (int i = 0; i < 7; i++)
//                num += (tmp.charAt(i) - 48) * Math.pow(2, 6 - i);

            num = Integer.parseInt(String.valueOf(tmp), 2);

            cipher = cipher.substring(7);

            ans.append((char) num);
        }

        System.out.println(ans);
    }

}
