import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int n = 0; n < commands.length; n++){
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            
            int length = j - i + 1;
            int[] subArray = new int[length];
            int[] copyArray = Arrays.copyOfRange(array, i - 1, j);
            for(int a = 0; a < length; a++){
                subArray[a] = array[a + i - 1];
            }
            
            Arrays.sort(subArray);
            Arrays.sort(copyArray);
            
            answer[n] = copyArray[k - 1];
        }
        return answer;
    }
}