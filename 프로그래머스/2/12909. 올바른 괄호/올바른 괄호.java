class Solution {
	public boolean solution(String s) {

		int open = 0;
		int close = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				open++;
			} else if (s.charAt(i) == ')') {
				close++;
			}
            
            if (open < close) {
                return false;
            }
		}

		return (open == close);
	}
}