import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        Map<Character, String> map = new HashMap<>();
        map.put('a', "aya");
        map.put('y', "ye");
        map.put('w', "woo");
        map.put('m', "ma");
        
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String bab : babbling){
            boolean flag = true;
            
            while(bab.length() > 0){
                
                char c = bab.charAt(0);
                if(!map.containsKey(c)){
                    flag = false;
                    break;
                }
                    

                String word = map.get(c);
                if(word.length() > bab.length()){
                    flag = false;
                    break;
                }
                
                String sub = bab.substring(0, word.length());
                if(!sub.equals(word)){
                    flag = false;
                    break;
                }

                bab = bab.substring(word.length(), bab.length());                
            }
            
            if(flag)
                answer++;

        }
        
        return answer;
    }
}