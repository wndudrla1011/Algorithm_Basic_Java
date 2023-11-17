package stack_queue.크레인인형뽑기_카카오;

import java.io.IOException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[][] board = new int[N + 1][N + 1];
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = readInt();
            }
        }

        int M = readInt();
        int[] moves = new int[M];

        for (int i = 0; i < M; i++)
            moves[i] = readInt();

        int v = 0, prev = 0;
        for (int loc : moves) {
            for (int i = 1; i <= N; i++) {
                v = board[i][loc];
                if (v > 0) {
                    board[i][loc] = 0;
                    stack.push(v);
                    if (v != prev) {
                        prev = stack.peek();
                    } else {
                        while (v == prev) {
                            ans++;
                            v = stack.pop();
                            if (stack.isEmpty()) prev = 0;
                            else prev = stack.peek();
                        }
                    }
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
