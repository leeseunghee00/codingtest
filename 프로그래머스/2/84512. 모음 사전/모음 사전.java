class Solution {
    
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    int count, result;
    
    public int solution(String word) {
 
        make("", word);
        
        return result;
    }
    
    private void make(String str, String word) {
                
        if (str.length() > alpha.length) {
            return;
        }
        
        if (!str.isEmpty()) {
            count++;
            
            if (str.equals(word)) {
                result = count;
                return;
            }
        }
        
        for (char ch : alpha) {
            make(str + ch, word);
        }
    }
}