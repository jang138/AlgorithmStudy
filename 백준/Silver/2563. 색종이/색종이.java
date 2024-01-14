import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[101][101];
		int size = 0;
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if(!paper[i][j]) {
						paper[i][j] = true;
						size++;
					}
				}
			}
		}
		
		System.out.println(size);
	}

}