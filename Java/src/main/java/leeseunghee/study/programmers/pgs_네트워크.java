package leeseunghee.study.programmers;

public class pgs_네트워크 {

    static int n;
    static int[][] computers;
    static boolean[] visited;

    public static void main(String[] args) {

        computers = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(solution(3, computers));
    }

    private static void dfs(int i) {
        // 방문함 체크
        visited[i] = true;

        // 2. 수행 동작
        for (int j = 0; j < n; j++) {
            // 1. 탈출 조건
            if (computers[i][j] == 1 && j != i && !visited[j]) {
                dfs(j);
            }
        }
    }

    private static int solution(int n, int[][] computers) {

        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
}