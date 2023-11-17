package string.문장속단어;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = "";

        while (st.hasMoreTokens()) {
            String piece = st.nextToken();
            if (piece.length() > word.length())
                word = piece;
        }

        System.out.println(word);
    }

}
