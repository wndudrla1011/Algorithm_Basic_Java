package map_tree.모든아나그램찾기;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        int s_len = S.length(), t_len = T.length();
        char[] A = new char[S.length()];
        int lt = 0, ans = 0;

        for (int i = 0; i < t_len - 1; i++) {
            A[i] = S.charAt(i);
            mapS.put(A[i], mapS.getOrDefault(A[i], 0) + 1);
        }

        for (char t : T.toCharArray())
            mapT.put(t, mapT.getOrDefault(t, 0) + 1);

        for (int rt = t_len - 1; rt < s_len; rt++) {
            A[rt] = S.charAt(rt);
            mapS.put(A[rt], mapS.getOrDefault(A[rt], 0) + 1);
            if (mapS.equals(mapT)) ans++;
            mapS.put(A[lt], mapS.get(A[lt]) - 1);
            if (mapS.get(A[lt]) == 0) mapS.remove(A[lt]);
            lt++;
        }

        System.out.println(ans);
    }

}
