import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        // System.out.println(Arrays.toString(array));
        
        for(int i = 0; i < array.length; i++){
            // 여는 괄호가 나오면 스택에 저장
            if(array[i] == '(') {
                stack.push('(');
            }
            
            // 닫는 괄호가 나오면 여는 괄호를 스택에서 꺼낸다
            else {
                
                // 이때 여는 괄호가 없다면 잘못된 괄호이다.
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                
                stack.pop();
            }
        }
        
        // 스택에 여는 괄호가 남은 경우 잘못된 괄호이다.
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}