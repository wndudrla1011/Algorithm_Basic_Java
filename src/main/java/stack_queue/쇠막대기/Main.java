package stack_queue.쇠막대기;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;

        char prev = S.charAt(0); //이전 괄호
        for (char s : S.toCharArray()) {
            if (s == ')') {
                stack.pop();
                if (prev == s) ans++; //')' -> ')' (막대기의 끝 -> 남은 조각 계산)
                else ans += stack.size(); //'(' -> ')' (레이저 -> 막대기 수만큼 계산)
            }
            else stack.push(s);
            prev = s; //현재 값 -> 이전 값
        }

        System.out.println(ans);
    }

}
