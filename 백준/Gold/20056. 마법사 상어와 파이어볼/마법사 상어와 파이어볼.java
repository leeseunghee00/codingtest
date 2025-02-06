import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, result;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<FireBall> fireBalls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 초기 파이어볼 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBalls.add(new FireBall(r, c, m, s, d));
        }

        // K번 명령 수행
        for (int i = 0; i < K; i++) {
            moveFireBalls();       // 1. 모든 파이어볼 이동
            mergeAndSplitFireBalls(); // 2. 이동 후 처리
        }

        // 최종 질량 합 계산
        result = fireBalls.stream().mapToInt(fb -> fb.m).sum();
        System.out.println(result);
    }

    // 1. 파이어볼 이동
    private static void moveFireBalls() {
        for (FireBall fireBall : fireBalls) {
            int nr = (fireBall.r + dy[fireBall.d] * fireBall.s % N + N) % N;
            int nc = (fireBall.c + dx[fireBall.d] * fireBall.s % N + N) % N;

            // 1부터 시작하는 좌표계 보정
            if (nr == 0) nr = N;
            if (nc == 0) nc = N;

            fireBall.r = nr;
            fireBall.c = nc;
        }
    }

    // 2. 2개 이상의 파이어볼 처리
    private static void mergeAndSplitFireBalls() {
        Map<String, List<FireBall>> map = new HashMap<>();

        // 2.1. 같은 위치 파이어볼을 맵에 저장
        for (FireBall fireBall : fireBalls) {
            String key = fireBall.r + "," + fireBall.c;
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(fireBall);
        }

        fireBalls.clear();

        // 2.2. 각 위치의 파이어볼을 합치거나 분할
        for (Map.Entry<String, List<FireBall>> entry : map.entrySet()) {
            List<FireBall> balls = entry.getValue();
            if (balls.size() == 1) {
                fireBalls.add(balls.get(0)); // 파이어볼이 1개면 그대로 추가
                continue;
            }

            // 여러 파이어볼 합치기
            int totalM = 0, totalS = 0;
            boolean allEven = true, allOdd = true;

            for (FireBall fb : balls) {
                totalM += fb.m;
                totalS += fb.s;
                if (fb.d % 2 == 0) allOdd = false; // 짝수 방향 체크
                else allEven = false; // 홀수 방향 체크
            }

            int newM = totalM / 5; // 질량 계산
            if (newM == 0) continue; // 질량이 0이면 소멸

            int newS = totalS / balls.size(); // 속력 계산
            int[] newDirections = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};

            // 분할된 파이어볼 생성
            String[] pos = entry.getKey().split(",");
            int r = Integer.parseInt(pos[0]);
            int c = Integer.parseInt(pos[1]);

            for (int d : newDirections) {
                fireBalls.add(new FireBall(r, c, newM, newS, d));
            }
        }
    }

    // 파이어볼 클래스
    static class FireBall {
        int r, c, m, s, d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
