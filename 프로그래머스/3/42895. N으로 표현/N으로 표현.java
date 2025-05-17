import java.util.*;;

class Solution {
    public int solution(int N, int number) {
        
        List<Set<Integer>> list = new ArrayList<>();
        
        // N을 사용한 갯수별 리스트 초기화
        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }
        
        // N이 1일 때는 무조건 자기자신밖에 없다.
        list.get(1).add(N);
        
        if (number == N) {
            return 1;
        }
        
        for (int i = 2; i <= 8; i++) {
            // N을 i개 사용할 때
            Set<Integer> total = list.get(i);
            
            for (int j = 1; j < i; j++) {
                Set<Integer> a = list.get(j);
                Set<Integer> b = list.get(i - j);
                
                for (int x : a) {
                    for (int y : b) {
                        total.add(x + y);
                        total.add(x - y);
                        total.add(x * y);

                        if (x != 0 && y != 0) {
                            total.add(x / y);
                        }
                    }
                }
                
                // N이 i개로 이루어진 수
                total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            
            if (total.contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}