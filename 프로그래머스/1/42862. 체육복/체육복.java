import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();

        for (int r : reserve) {
            reserveSet.add(r);
        }
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                reserveSet.remove(l); // 여벌 체육복 있지만 도난당한 학생은 제외
            } else {
                lostSet.add(l); // 실제 도난당한 학생만 남김
            }
        }

        int count = n - lostSet.size();

        // 체육복 빌려주기
        for (int l : lostSet) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                count++;
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                count++;
            }
        }

        return count;
    }
}
