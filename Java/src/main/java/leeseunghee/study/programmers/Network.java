package leeseunghee.study.programmers;

public class Network {

    int n;
    int answer;
    int[][] computers;
    boolean[] visited;

    public void dfs(int i) {
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

    public int solution(int n, int[][] computers) {

        answer = 0;
        this.n = n;
        this.computers = computers;
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
