package sort.좌표정렬;

import java.io.IOException;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        List<Coor> coors = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            coors.add(new Coor(readInt(), readInt()));
        }

        Collections.sort(coors);

        for (Coor coor : coors) {
            System.out.println(coor.x + " " + coor.y);
        }
    }

    static class Coor implements Comparable<Coor> {
        int x;
        int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coor o) {
            if (o.x == this.x) return this.y - o.y;
            return this.x - o.x;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
