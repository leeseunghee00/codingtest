import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		int order = 0;

		for (int i = 0; i < priorities.length; i++) {
			queue.add(new Process(priorities[i], i));
			priorityQueue.add(priorities[i]);
		}

		while (!queue.isEmpty()) {
			Process current = queue.poll();

			if (current.priority < priorityQueue.peek()) {
				queue.add(current);
			} else {
				order++;
				priorityQueue.poll();

				if (current.location == location) {
					return order;
				}
			}
		}

		return -1;
	}

	class Process {
		int priority;
		int location;

		Process(int priority, int location) {
			this.priority = priority;
			this.location = location;
		}
	}
}