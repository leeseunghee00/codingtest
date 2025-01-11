import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Member> members = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Member member = new Member(i, age, name);

			members.add(member);
		}

		members.sort((o1, o2) -> {
			if (o1.age == o2.age) {
				return o1.idx - o2.idx;
			}

			return o1.age - o2.age;
		});

		for (Member member : members) {
			System.out.println(member.age + " " + member.name);
		}
	}

	static class Member {
		int idx;
		int age;
		String name;

		Member(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
	}
}
