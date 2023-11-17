package greedy.친구인가;

import java.io.IOException;

public class Main {

    static int[] A; //초기 배열

    public static void main(String[] args) throws IOException {
        int N = readInt(); //학생 수
        int M = readInt(); //친구 정보 개수
        A = new int[N + 1];

        //초기 배열 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int a = readInt();
            int b = readInt();
            union(a, b);
        }

        System.out.println(find(readInt()) == find(readInt()) ? "YES" : "NO");
    }

    //집합 만들기
    static void union(int a, int b) {
        int pa = find(a); //a의 대표 노드
        int pb = find(b); //b의 대표 노드
        if (pa < pb) A[pb] = pa;
        else A[pa] = pb;
    }

    //find -> 대표 노드 찾기
    static int find(int a) {
        if (a == A[a]) return a;
        else return A[a] = find(A[a]); //모든 자식 노드 값을 부모 노드로
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
