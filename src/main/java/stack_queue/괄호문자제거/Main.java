package stack_queue.괄호문자제거;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') stack.pop();
            if (stack.isEmpty() && c > 41) ans.append(c);
        }

        System.out.println(ans);
    }

}
