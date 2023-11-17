package stack_queue.올바른괄호;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }

        System.out.println(stack.size() == 0 ? "YES" : "NO");
    }

}
