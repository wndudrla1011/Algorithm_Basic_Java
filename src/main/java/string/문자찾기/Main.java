package string.문자찾기;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();
        String word = br.readLine().toLowerCase();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Objects.equals(word, input.substring(i, i + 1)))
                result++;
        }

        System.out.println(result);
    }

}
