import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
long answer = 0;
        int len = deliveries.length;
        
        // 배달용, 수거용
        LinkedList<int[]> list1 = new LinkedList<>();
        LinkedList<int[]> list2 = new LinkedList<>();
        
        // 개수와 거리 정보 저장
        for(int i =0 ;i < len; i++){
            if(deliveries[i] > 0)
                list1.add(new int[]{deliveries[i], i+1});
            if(pickups[i] > 0)
                list2.add(new int[]{pickups[i], i+1});
        }
        
        // 현재 적재 중인 상자 수 
        int sum =0 ;
        
        // 이동 거리
        int dist = 0;
        
        while(!list1.isEmpty() || !list2.isEmpty()){
            sum = 0;
            dist = 0;
            
            while(!list1.isEmpty() && sum < cap){
                int[] poll = list1.pollLast();
                dist = Math.max(dist, poll[1]);
                
                // 상자를 실을 수 있는지 판단
                if(poll[0] + sum <= cap){
                    sum += poll[0];
                } else{
                    poll[0] -= (cap - sum);
                    list1.add(poll);
                    break;
                }
            }
            
            sum = 0;
            while(!list2.isEmpty() && sum < cap){
                int[] poll = list2.pollLast();
                dist = Math.max(dist, poll[1]);
                
                // 상자를 실을 수 있는지 판단
                if(poll[0] + sum <= cap){
                    sum += poll[0];
                } else{
                    poll[0] -= (cap - sum);
                    list2.add(poll);
                    break;
                }
            }
            
            answer += dist * 2;
        }
        
        return answer;
    }
}