package stack_queue.크레인인형뽑기_카카오;

import java.io.IOException;
import java.util.Stack;

public class Main2 {

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

        for (int loc : moves) {
            for (int i = 1; i <= N; i++) {
                if (board[i][loc] > 0) {
                    if (!stack.isEmpty() && stack.peek() == board[i][loc]) {
                        stack.pop();
                        ans += 2;
                    } else {
                        stack.push(board[i][loc]);
                    }
                    board[i][loc] = 0;
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
