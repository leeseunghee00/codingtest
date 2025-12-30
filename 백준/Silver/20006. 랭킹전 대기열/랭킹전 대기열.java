import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int players, limit;
	static Deque<Room> gameRooms = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		players = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());

		while (players-- > 0) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String nickname = st.nextToken();
			Player player = new Player(nickname, level);

			// 기존 방 인원 수가 부족하면서 기준 레벨 범위에 부합한 경우 -> 플레이어 추가
			boolean flag = false;

			for (Room room : gameRooms) {
				if (!room.isFull() && room.isWithinRange(player.level)) {
					room.add(player);
					flag = true;
					break;
				}
			}

			// 아직 생성된 방이 없거나 위 조건에 충족하지 못한 경우 -> 방 추가 & 플레이어 추가
			if (!flag || gameRooms.isEmpty()) {
				gameRooms.add(new Room());
				gameRooms.getLast().waiters.add(player);
			}
		}

		// 방 상태 바꾸기 & 닉네임 순으로 정렬
		for (Room room : gameRooms) {
			room.changeStatus();
			room.sortWaiters();
		}

		// 출력
		for (Room room : gameRooms) {
			System.out.println(room.status);
			for (Player player : room.waiters) {
				System.out.println(player.level + " " + player.nickname);
			}
		}
	}

	static class Room {
		List<Player> waiters = new ArrayList<>();
		String status = "Waiting!";

		private void add(Player player) {
			waiters.add(player);
		}

		private boolean isFull() {
			return waiters.size() + 1 > limit;
		}

		private void changeStatus() {
			if (waiters.size() == limit) {
				this.status = "Started!";
			}
		}

		private void sortWaiters() {
			waiters.sort(
				Comparator.comparing((Player p) -> p.nickname)
					.thenComparingInt(p -> p.level)
			);
		}

		private boolean isWithinRange(int level) {
			int base = waiters.get(0).level;

			return base - 10 <= level && level <= base + 10;
		}
	}

	static class Player {
		String nickname;
		int level;

		public Player(String nickname, int level) {
			this.nickname = nickname;
			this.level = level;
		}
	}
}