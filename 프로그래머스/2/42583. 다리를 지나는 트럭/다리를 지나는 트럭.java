import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new LinkedList<>(); // 0: 무게, 1: 남은 거리
		int bWeight = 0;
		int idx = 0;
		int time = 0;

		while (idx < truck_weights.length || !bridge.isEmpty()) {
			time++;

			if (!bridge.isEmpty() && bridge.peek()[1] == 0) {
				bWeight -= bridge.poll()[0];
			}

			if (idx < truck_weights.length) {
				int tWeight = truck_weights[idx];

				if (bWeight + tWeight <= weight && bridge.size() < bridge_length) {
					bridge.add(new int[]{tWeight, bridge_length});
					bWeight += tWeight;
					idx++;
				}
			}

			for (int[] truck : bridge) {
				truck[1]--;
			}
		}

		return time;
    }
}