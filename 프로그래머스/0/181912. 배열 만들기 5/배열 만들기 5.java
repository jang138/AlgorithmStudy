import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {        
        List<Integer> arrayList = new ArrayList<>();
        
        for(String str : intStrs){
            String subStr = str.substring(s, s+l);
            System.out.println(subStr);
            
            int toInt = Integer.parseInt(subStr);
            if(toInt > k)
                arrayList.add(toInt);
        }
        

        
        int[] answer = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++){
            answer[i] = arrayList.get(i);
        }
        
        return answer;
    }
}