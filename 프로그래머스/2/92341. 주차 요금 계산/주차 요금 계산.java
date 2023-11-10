import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        // 출입차를 파악하기 위한 map
        HashMap<String, String> map = new HashMap<>();
        
        // 요금을 계산하기 위한 map
        HashMap<String, Integer> feeMap = new HashMap<>();
        
        // 모든 차량의 요금을 계산하기 위한 초기값
        for(int i = 0; i < records.length; i++){
            feeMap.put(records[i].split(" ")[1], 0);
        }
        
        
        for(int i = 0; i < records.length; i++){
            String[] infos = records[i].split(" "); // 0 시간, 1 차 번호, 2 출입여부
            
            // 이미 입차한 차량이 존재해 출차를 하는 경우
            if (map.containsKey(infos[1])){
                // map에서 입차한 경우를 제거하며 입차 시간을 가져온다.
                String[] inTime = map.remove(infos[1]).split(":");
                String[] outTime = infos[0].split(":");
                
                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
                
                // 요금 map에 누적 시간을 replace
                feeMap.replace(infos[1], feeMap.get(infos[1]) + 60 * hour + minute);
                
            } 
            
            // 입차하는 경우
            else {
                map.put(infos[1], infos[0]); // 차 번호, 시간
            }
        }
        
        // 아직 출차하지 않은 나머지 (23시 59분에 출차한 것으로 계산)
        for(String key : map.keySet()){
            String[] inTime = map.get(key).split(":");
            
            int hour = 23 - Integer.parseInt(inTime[0]);
            int minute = 59 -Integer.parseInt(inTime[1]);
            
            feeMap.replace(key, feeMap.get(key) + 60 * hour + minute);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList(feeMap.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if(Integer.parseInt(o1.getKey()) > Integer.parseInt(o2.getKey())){
                return 1;
            } else if (Integer.parseInt(o1.getKey()) < Integer.parseInt(o2.getKey())) {
                return -1;
            } else {
                return 0;
            }
        });
        
        System.out.println(list);
        
        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            if(list.get(i).getValue() > fees[0]){
                answer[i] = fees[1] + (int) Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3];
            } else{
                answer[i] = fees[1];
            }
        }
        
        return answer;
    }
}