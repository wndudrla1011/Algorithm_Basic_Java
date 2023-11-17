package string.문장속단어;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int pos;
        String word = "";

        while ((pos = input.indexOf(' ')) != -1) {
            String piece = input.substring(0, pos);
            if (piece.length() > word.length())
                word = piece;
            input = input.substring(pos + 1);
        }

        if (input.length() > word.length())
            word = input;

        System.out.println(word);
    }

}
