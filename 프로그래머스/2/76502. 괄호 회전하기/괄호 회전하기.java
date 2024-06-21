import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
                
        for(int i = 0; i < length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i, length)).append(s.substring(0, i));
            String rotatedString = sb.toString();
            
            if(validation(rotatedString)){
                answer++;   
            }
            
        }
        
        return answer;
    }
    
    public boolean validation(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }
            
            else {
                if(stack.isEmpty()){
                    return false;
                }
                
                if(c == ']'){
                    if(stack.peek() != '[')
                        return false;
                }
                
                else if(c == ')'){
                    if(stack.peek() != '(')
                        return false;
                }
                
                else if(c == '}'){
                    if(stack.peek() != '{')
                        return false;
                }
                
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return true;
    }
}