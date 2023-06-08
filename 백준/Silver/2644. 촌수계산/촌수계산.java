import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, A, B, M;
	static int family[][];
	static int chon[];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		family = new int[N + 1][N + 1];
		chon = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			family[x][y] = family[y][x] = 1;
		}
		
		bfs(A);
				
		System.out.println(chon[B] == 0 ? -1 : chon[B]);
	}
	
	private static void bfs(int num) {
		queue.add(num);
		
		while(!queue.isEmpty()) {
			int target = queue.poll();
//			System.out.println( "target : " + target);
			
			if(target == B) {
				break;
			}
			
			for (int i = 1; i <= N; i++) {
				if(family[target][i] == 1 && chon[i] == 0) {
//					System.out.print(i + " ");
					queue.add(i);
					chon[i] = chon[target] + 1;
				}
				
			}
			
		}
		
	}

}
