package stack_queue.후위식연산;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String op = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for (char c : op.toCharArray()) {
            if (c >= 48 && c <= 57) stack.push(c - 48);
            else {
                int second = stack.pop();
                int first = stack.pop();
                if (c == 43) stack.push(first + second);
                else if (c == 45) stack.push(first - second);
                else if (c == 42) stack.push(first * second);
                else stack.push(first / second);
            }
        }

        System.out.println(stack.pop());
    }

}
