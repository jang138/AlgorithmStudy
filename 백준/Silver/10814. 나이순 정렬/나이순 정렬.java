
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<Node>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

        Collections.sort(list, (o1, o2) -> o1.age - o2.age );

        for (Node node : list) {
			System.out.println( node.age + " " + node.name );
		}
		
	}

	 public static class Node {
	        int age;
	        String name;

	        public Node(int age, String name) {
	            this.age = age;
	            this.name = name;
	        }
	    }
}
