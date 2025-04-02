package string.p1_5;

import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        StringBuilder alphabet = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] inputCharArray = input.toCharArray();
        int last = inputCharArray.length - 1;

        /*Collect Alphabet*/
        for (int i = 0; i <= last; i++) {
            char ch = inputCharArray[i];
            if (ch > 32) { // not space
                if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) alphabet.append(ch);
            }
        }

        alphabet.reverse();

        int idx = 0;
        for (int i = 0; i <= last; i++) {
            char ch = inputCharArray[i];
            if (ch > 32) { // not space
                if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) ans.append(alphabet.charAt(idx++));
                else ans.append(ch);
            }
        }

        System.out.println(ans);
    }

}
