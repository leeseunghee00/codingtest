import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> meetingQueue = new PriorityQueue<>((n1, n2) -> n1.startTime - n2.startTime);
		PriorityQueue<Integer> roomQueue = new PriorityQueue<>();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());

			meetingQueue.offer(new Node(startTime, endTime));
		}

		// 첫 번째 방 생성
		Node firstMeeting = meetingQueue.poll();
		roomQueue.offer(firstMeeting.endTime);
		result++;

		while (!meetingQueue.isEmpty()){
			Node curMeeting = meetingQueue.poll();

			if (curMeeting.startTime >= roomQueue.peek()) {
				roomQueue.poll();
			} else {
				// 만약 현재 회의실 시간에 포함된다면, 방 생성
				result++;
			}

			roomQueue.offer(curMeeting.endTime);
		}

		System.out.println(result);
	}

	static class Node {
		int startTime;
		int endTime;

		public Node(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}
}
