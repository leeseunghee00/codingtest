import java.util.*;
import java.io.*;

public class Main {

	static int N, K, count;
	static Meeting[] meetings;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		meetings = new Meeting[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			meetings[i] = new Meeting(start, end);
		}

		Arrays.sort(meetings);
		ArrayList<Integer> rooms = new ArrayList<>();

		for (Meeting meeting : meetings) {
			boolean flag = false;

			rooms.sort((o1, o2) -> -Integer.compare(o1, o2));

			for (int i = 0; i < rooms.size(); i++) {
				if (rooms.get(i) < meeting.start) {
					rooms.set(i, meeting.end);
					count++;
					flag = true;
					break;
				}
			}

			if (!flag && rooms.size() < K) {
				rooms.add(meeting.end);
				count++;
			}
		}

		System.out.println(count);
	}

	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting obj) {
			if (this.end == obj.end) {
				return Integer.compare(this.start, obj.start);
			}
			return Integer.compare(this.end, obj.end);
		}
	}
}
