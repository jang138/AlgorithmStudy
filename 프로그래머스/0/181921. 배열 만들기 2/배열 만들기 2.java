import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
                
        List<Integer> list = new ArrayList<>();

        int start = 0;
        if(l % 5 == 0)
            start = l;
        else
        {
            start = l - (l%5) +5;
        }
        
        Loop: for(int i = start; i <= r; i += 5){
            
            String strNum = String.valueOf(i);
            
            for(int j = 0; j < strNum.length(); j++){
                char c = strNum.charAt(j);
                if( c != '5' && c != '0')
                    continue Loop;
            }
            
            list.add(Integer.parseInt(strNum));
            
        }
        
        if(list.size() == 0)
            return new int[] {-1};
        else {
            int answer[] = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
            
            return answer;
        }
    }
}