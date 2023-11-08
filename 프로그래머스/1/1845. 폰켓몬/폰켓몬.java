import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int type = nums.length / 2;
        
        System.out.println(Arrays.toString(nums));
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int phonekemon = nums[i];
            
            if(map.containsKey(phonekemon)){
                map.replace(phonekemon, map.get(phonekemon) + 1);
            } else {
                map.put(phonekemon, 1);
            }
        }
        
        return map.size() > type ? type : map.size();
    }
}