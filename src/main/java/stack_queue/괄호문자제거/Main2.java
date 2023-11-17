package stack_queue.괄호문자제거;

import java.io.*;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (c != ')') stack.push(c);
            else {
                while (stack.pop() != '(');
            }
        }

        for (char character : stack) {
            ans.append(character);
        }

        System.out.println(ans);
    }

}
