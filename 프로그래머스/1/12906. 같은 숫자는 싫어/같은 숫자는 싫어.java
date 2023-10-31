import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
            int target = arr[i];
            if(deque.peekLast() != target){
                deque.offerLast(target);
            }
        }
                
        int answer[] = new int[deque.size()];
        int n = 0;
        for(int d : deque){
            answer[n++] = d;
        }
        

        return answer;
    }
}