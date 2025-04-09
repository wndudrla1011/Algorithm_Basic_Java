package array.p2_6;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        Stack<Integer> rev_num = new Stack<>();
        int num = 0, max = Integer.MIN_VALUE;

        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c > 32) { //숫자
                num = num * 10 + (c - 48);
            } else { //SP
                if (max < num) max = num;
                rev_num.push(num);
                num = 0;
            }
        }

        rev_num.push(num);
        int[] prime = new int[max + 1];

        for (int i = 2; i <= Math.sqrt(max); i++) {
            int j = 2;
            while (i * j <= max) {
                prime[i * j]++;
                j++;
            }
        }

        while (!rev_num.isEmpty()) {
            int elem = rev_num.pop();
            if (prime[elem] == 0 && elem > 1) ans.append(elem).append(' ');
        }

        System.out.println(ans);
    }

}
