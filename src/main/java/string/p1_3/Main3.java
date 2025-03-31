package string.p1_3;

import java.io.*;
import java.util.*;

public class Main3 {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Word> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            pq.offer(new Word(word.length(), word));
        }

        System.out.println(Objects.requireNonNull(pq.poll()).word);
    }

    static class Word implements Comparable<Word> {
        int len;
        String word;

        public Word(int len, String word) {
            this.len = len;
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if (this.len >= o.len) return o.len - this.len;
            else return o.len - this.len;
        }
    }

}
