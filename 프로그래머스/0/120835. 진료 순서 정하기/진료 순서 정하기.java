class Solution {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] answer = new int[emergency.length];
        
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(emergency[i] <= emergency[j])
                    count++;
            }
            
            answer[i] = count;
        }
        return answer;
    }
}