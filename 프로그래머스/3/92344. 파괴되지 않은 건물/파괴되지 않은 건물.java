import java.util.*;

class Solution {

    public int solution(int[][] board, int[][] skill) {
        
        Game game = new Game(board, skill);
        
        int result = game.start();
        
        return result;
    }
    
    class Game {
        int[][] board;
        int[][] skill;
        int[][] sum;
        
        Game(int[][] board, int[][] skill) {
            this.board = board;
            this.skill = skill;
            this.sum = new int[board.length + 1][board[0].length + 1];
        }
        
        public int start() {
            int n = board.length;
            int m = board[0].length;
            
            for (int[] s : skill) {
                int type = s[0];
                RC rc1 = new RC(s[1], s[2]);
                RC rc2 = new RC(s[3], s[4]);
                int degree = s[5];
                
                if (type == 1) {
                    update(rc1, rc2, -degree);  // 공격
                } else {
                    update(rc1, rc2, degree);   // 치유
                }
            }
            
            // 가로 누적합
            for (int r = 0; r <= n; r++) {
                for (int c = 1; c <= m; c++) {
                    sum[r][c] += sum[r][c - 1];
                }
            }
            
            // 세로 누적합
            for (int c = 0; c <= m; c++) {
                for (int r = 1; r <= n; r++) {
                    sum[r][c] += sum[r - 1][c];
                }
            }
            
            return count();
        }
        
        private void update(RC rc1, RC rc2, int degree) {
            sum[rc1.r][rc1.c] += degree;
            sum[rc1.r][rc2.c + 1] -= degree;
            sum[rc2.r + 1][rc1.c] -= degree;
            sum[rc2.r + 1][rc2.c + 1] += degree;
        }
        
        private int count() {
            int unbroken = 0;
            int n = board.length;
            int m = board[0].length;
            
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (board[r][c] + sum[r][c] > 0) {
                        unbroken++;
                    }
                }
            }
            
            return unbroken;
        }
    }
    
    class RC {
        int r, c;
        
        RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
