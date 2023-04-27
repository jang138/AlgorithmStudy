import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int i = people.length - 1;
        int front = 0;
        
        while(i>=front){
            // 제일 가벼운 사람도 탈 수 있는지 체크
            if(people[i] + people[front] <= limit){
                front++; // 탑승
            }
            answer++;
            i--;
        }
        
        return answer;
    }
}