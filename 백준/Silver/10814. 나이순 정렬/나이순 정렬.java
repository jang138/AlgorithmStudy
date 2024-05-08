import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Person {
		int age;
		String name;
		int index;

		public Person(int age, String name, int index) {
			this.age = age;
			this.name = name;
			this.index = index;
		}

		@Override
		public String toString() {
			return String.format("%d %s", this.age, this.name);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        // priority queue 보다는 person 클래스를 타입으로 가지는 리스트를 정렬하는 것이 더 효율적이다.
		PriorityQueue<Person> pq = new PriorityQueue<>((p1, p2) -> {
			if (p1.age == p2.age)
				return Integer.compare(p1.index, p2.index);
			return Integer.compare(p1.age, p2.age);
		});

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Person p = new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i);
			pq.add(p);
		}

		StringBuilder sb = new StringBuilder();

		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
