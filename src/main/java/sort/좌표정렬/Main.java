package sort.좌표정렬;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        Coor[] coors = new Coor[N];
        int pos;

        for (int i = 0; i < N; i++) {
            coors[i] = new Coor(readInt(), readInt());
        }

        for (int i = 1; i < N; i++) {
            Coor c = coors[i];
            pos = i;
            for (int j = i - 1; j >= 0; j--) {
                if (c.x > coors[j].x) {
                    pos = j + 1;
                    break;
                }
                else if (c.x == coors[j].x && c.y > coors[j].y) {
                    pos = j + 1;
                    break;
                }
                if (j == 0) pos = 0;
            }
            for (int j = i; j > pos; j--) {
                coors[j] = coors[j - 1];
            }
            coors[pos] = c;
        }

        for (Coor coor : coors) {
            System.out.println(coor.x + " " + coor.y);
        }
    }

    static class Coor {
        int x;
        int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
