package string.p1_11;

import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] cnt = new int[91];
        char[] arr = input.toCharArray();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i++) {
            if (arr[i] == arr[i + 1]) cnt[arr[i]]++;
            else {
                cnt[arr[i]]++; // 자기 자신
                ans.append(arr[i]);
                if (cnt[arr[i]] > 1) ans.append(cnt[arr[i]]);
                Arrays.fill(cnt, 0);
            }

            // 마지막 알파벳 처리
            if (i == input.length() - 2) {
                cnt[arr[i + 1]]++;
                if (arr[i - 1] == arr[i]) ans.append(arr[i - 1]).append(cnt[arr[i - 1]]);
                else ans.append(arr[i]).append(cnt[arr[i]]).append('\n');
            }
        }

        System.out.println(ans);
    }

}
