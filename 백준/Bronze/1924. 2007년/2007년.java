import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int daySum = 0;
		int month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String dayOfWeek[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

		for (int i = 0; i < x; i++) {
			daySum += month[i];
		}
		
		daySum += y;

		System.out.println(dayOfWeek[daySum % 7]);
	}

}