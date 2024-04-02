import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
		int[] stageCount = new int[N + 1];

		for (int i = 0; i < stages.length; i++) {
			stageCount[stages[i]-1]++;
		}

		System.out.println(Arrays.toString(stageCount));

		HashMap<Integer, Double> map = new HashMap<>();
		double total = stages.length;

		for (int i = 0; i < N; i++) {
			if (stageCount[i] == 0) {
				map.put(i+1, 0.0);
				continue;
			}

			map.put(i+1, stageCount[i] / total);
			total -= stageCount[i];
		}

		List<HashMap.Entry<Integer, Double>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, (o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
		
		int answer[] = new int[entryList.size()];
		for (int i = 0; i < entryList.size(); i++) {
			answer[i] = entryList.get(i).getKey();
		}
        
        return answer;
    }
}