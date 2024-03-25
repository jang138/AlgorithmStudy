import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int pattern[][] = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] count = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < 3; j++){
                if(answers[i] == pattern[j][i % pattern[j].length])
                    count[j]++;
            }
        }
        
        System.out.println(Arrays.toString(count));
        
        int maxScore = 0;
        for(int i = 0; i < count.length; i++){
            maxScore = Math.max(maxScore, count[i]);
        }
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < count.length; i++){
            if(maxScore == count[i])
                arrayList.add(i+1);
        }
        
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}