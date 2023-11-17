package string.중복문자제거;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Character> alpha = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (!alpha.contains(c))
                alpha.add(c);
        }

        for (char c : alpha) {
            ans.append(c);
        }

        System.out.println(ans);
    }

}
