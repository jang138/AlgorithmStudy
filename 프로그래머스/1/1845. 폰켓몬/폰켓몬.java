import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int type = nums.length / 2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int phonekemon = nums[i];
            map.put(phonekemon, 1);
        }
        
        return map.size() > type ? type : map.size();
    }
}