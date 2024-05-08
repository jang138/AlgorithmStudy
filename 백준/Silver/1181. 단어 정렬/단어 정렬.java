import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<String> inputList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			inputList.add(br.readLine());
		}

		Collections.sort(inputList, (l1, l2) -> {
			if (l1.length() == l2.length())
				return l1.compareTo(l2); // 문자열 객체의 compareTo 메서드
			return Integer.compare(l1.length(), l2.length()); // Integer의 compare
		});

		StringBuilder sb = new StringBuilder();
		String beforeStr = "";
		String targetStr = "";

		for (int i = 0; i < inputList.size(); i++) {
			targetStr = inputList.get(i);

			if (beforeStr.equals(targetStr))
				continue;

			sb.append(targetStr).append("\n");
			beforeStr = targetStr;
		}

		System.out.println(sb.toString());
	}

}
