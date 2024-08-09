import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			list.add(new int[] { s, e });
		}
		
		Collections.sort(list, (l1, l2) -> {
			if(l1[1] == l2[1])
				return Integer.compare(l1[0], l2[0]);
			
			return Integer.compare(l1[1], l2[1]);
		});

		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(Arrays.toString(list.get(i)));
//		}
		
		int cnt = 0;
		int endTime = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)[0] >= endTime) {
				cnt++;
				endTime = list.get(i)[1];
			}
		}
		
		System.out.println(cnt);
	}

}
