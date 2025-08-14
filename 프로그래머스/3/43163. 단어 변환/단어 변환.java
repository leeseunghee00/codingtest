import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {

        // 타켓이 포함되어 있지 않을 경우
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
    
        int result = bfs(begin, target, words);
        
        return result;
    }
    
    private int bfs(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.offer(new Word(begin, 0));
        
        while (!queue.isEmpty()) {
            Word now = queue.poll();
            
            if (now.word.equals(target)) {
                return now.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(now.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], now.count + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean canConvert(String nowWord, String convertWord) {
        int count = 0;         // 변환할 개수 카운팅
        
        for (int i = 0; i < convertWord.length(); i++) {
            if (convertWord.charAt(i) != nowWord.charAt(i)) {
                count++;
            }
        }
        
        return count == 1;
    }
    
    class Word {
        String word;
        int count;
        
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}