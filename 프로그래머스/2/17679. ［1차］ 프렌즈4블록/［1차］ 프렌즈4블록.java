import java.util.*;

class Solution {
        
    public int solution(int m, int n, String[] board) {
        Friends4Blocks game = new Friends4Blocks(new Board(m, n, board));
        
        return game.play();
    }
    
    class Friends4Blocks {
        
        private final Board board;
        
        Friends4Blocks(Board board) {
            this.board = board;
        }
        
        /* (게임 반복) 2x2 매칭 -> 제거 -> 내림 */
        public int play() {
            int totalRemoved = 0;
            
            while (true) {
                // 1. 2x2 매칭 찾기
                boolean[][] marked = board.find2x2Matches();
                // 2. 2x2 매칭 제거
                int removed = board.removeMarked(marked);
                
                if (removed == 0) {
                    break;
                }
                
                // 3. 제거된 수 카운팅
                totalRemoved += removed;
                // 4. 위에 남은 아이콘들 내리기
                board.applyGravity();
            }
            
            return totalRemoved;
        }
    }
    
    class Board {

        // 비어있음을 표시
        private static final char EMPTY = '.';

        private final int rows;
        private final int cols;
        private final Block[][] grid;
        
        Board(int rows, int cols, String[] board) {
            this.rows = rows;
            this.cols = cols;
            this.grid = new Block[rows][cols];
            
            for (int r = 0; r < rows; r++) {
                char[] arr = board[r].toCharArray();
                for (int c = 0; c < cols; c++) {
                    grid[r][c] = new Block(arr[c]);
                }
            }
        }
        
        /* 2X2 매치 찾기 */
        public boolean[][] find2x2Matches() {
            boolean[][] mark = new boolean[rows][cols];
            
            for (int r = 0; r < rows - 1; r++) {
                for (int c = 0; c < cols - 1; c++) {
                    char icon = grid[r][c].get();
                    
                    // 비어있으면, 넘어가기
                    if (icon == EMPTY) {
                        continue;
                    }
                    
                    // 주변(2x2)이 같은 아이콘이면, 마킹
                    if (grid[r][c + 1].get() == icon &&
                        grid[r + 1][c].get() == icon &&
                        grid[r + 1][c + 1].get() == icon) {
                        mark[r][c] = mark[r][c + 1] = mark[r + 1][c] = mark[r + 1][c + 1] = true;
                    }
                }
            }
            
            return mark;
        }
        
        /* 2X2 매치 제거 */
        public int removeMarked(boolean[][] marked) {
            int removed = 0;
            
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (marked[r][c] & !grid[r][c].isEmpty(EMPTY)) {
                        grid[r][c].set(EMPTY);
                        removed++;
                    }
                }
            }
            
            return removed;
        }
        
        /* 위에 있는 아이콘 내리기 */
        public void applyGravity() {
            for (int c = 0; c < cols; c++) {
                int write = rows - 1;
                
                // 아래에서부터 채우기 위함
                for (int r = rows - 1; r >= 0; r--) {
                    if (!grid[r][c].isEmpty(EMPTY)) {
                        char icon = grid[r][c].get();
                        grid[write][c].set(icon);
                        
                        if (write != r) {
                            grid[r][c].set(EMPTY);
                        }
                        
                        write--;
                    }
                }
            }
        }
    }
    
    class Block {
        
        private char icon;
        
        Block(char icon) {
            this.icon = icon;
        }
        
        public char get() {
            return icon;
        }
        
        public void set(char icon) {
            this.icon = icon;
        }
        
        public boolean isEmpty(char empty) {
            return icon == empty;
        }
    }
}
