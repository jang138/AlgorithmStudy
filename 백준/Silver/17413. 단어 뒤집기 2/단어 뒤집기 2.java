import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		
		for (int i = 0; i < inputStr.length(); i++) {
			char target = inputStr.charAt(i);
			
			if(flag && target != '>') {
				sb.append(target);
				continue;
			}
			
			if(target == '<') {				
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(target);
				
				flag = true;
				continue;
			}
			
			if(target == '>') {
				sb.append(target);
				flag = false;
				continue;
			}
			
			if(target == ' ') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(target);
				continue;
			}
			
			stack.push(target);
			
		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println(sb.toString());
	}

}
