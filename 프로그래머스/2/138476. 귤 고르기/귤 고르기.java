import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : tangerine){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> {
            return Integer.compare(map.get(o2), map.get(o1));
        });
                
        int cnt = 0;
        while(k > 0){
            k -= map.get(keyList.get(cnt));
            cnt++;
        }
        
        return cnt;
    }
}