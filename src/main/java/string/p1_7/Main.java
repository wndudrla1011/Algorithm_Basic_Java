package string.p1_7;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int lt = 0, rt = arr.length - 1;

        while (lt < rt) {
            if (!(arr[lt] + "").equalsIgnoreCase(arr[rt] + "")) {
                System.out.println("NO");
                System.exit(0);
            }
            lt++; rt--;
        }

        System.out.println("YES");
    }

}
