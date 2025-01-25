import java.util.Arrays;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if (!completion[i].equals(participant[i])) {
				return participant[i];
			}
		}

		if (participant.length != completion.length) {
			return participant[participant.length - 1];
		}

		return "0";
    }
}