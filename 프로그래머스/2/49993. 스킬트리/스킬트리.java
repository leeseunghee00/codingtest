class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        
        for (String tree : skill_trees) {
            StringBuilder sb = new StringBuilder();

            for (char ch : tree.toCharArray()) {
                if (skill.indexOf(ch) != -1) {
                    sb.append(ch);
                }
            }
            
            if (skill.startsWith(sb.toString())) {
                count++;
            }
        }
        
        return count;
    }
}
