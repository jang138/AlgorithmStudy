import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arrayList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arrayList.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(arrayList);

		for (int i : arrayList) {
			sb.append(i).append('\n');
		}
		
		System.out.println(sb);
		
	}

}
