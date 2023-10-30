import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sec = 0;            // 시간
        int bridge_weight = 0;  // 다리의 현재 무게
        Queue<Integer> bridge = new LinkedList<>(); // 다리에 오른 트럭을 담는 큐
                
        for(int t : truck_weights){            
            while(true){
                // 다리 위에 트럭이 없을 때
                if(bridge.isEmpty()){
                    bridge.add(t);
                    bridge_weight += t;
                    sec++;
                    break;
                }
                
                // 다리 위 트럭이 꽉 찼을 때
                else if(bridge.size() == bridge_length){
                    bridge_weight -= bridge.poll();
                    
                    if(bridge_weight + t <= weight){
                        bridge.add(t);
                        bridge_weight += t;
                        sec++;
                        break;
                    } else {
                        bridge.add(0);
                        sec++;
                    }
                }
                
                // 다리 위에 트럭이 있고 대기 트럭이 올라갈 수 있을 때
                else {                    
                    if(bridge_weight + t <= weight){
                        bridge.add(t);
                        bridge_weight += t;
                        sec++;
                        break;
                    } else {
                        bridge.add(0);
                        sec++;
                    }
                }
            }
        }
        
        return sec + bridge_length; // 마지막 트럭이 다리를 지나는데 걸리는 시간까지 합해준다.
    }
}