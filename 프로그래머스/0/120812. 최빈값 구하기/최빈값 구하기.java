import java.util.*;

class Solution {
    public int solution(int[] array) {
        ArrayList<Node> arrayList = new ArrayList<>();
		for (int i = 0; i <= 1000; i++) {
			arrayList.add(new Node(i, 0));
		}
		
		for (int n : array) {
			arrayList.set(n, new Node(n, arrayList.get(n).value + 1));
		}

		Collections.sort(arrayList, (o1, o2) -> {
			return Integer.compare(o2.value, o1.value);
		});
        
        System.out.println(arrayList);

		return arrayList.get(0).value == arrayList.get(1).value ? -1 : arrayList.get(0).index;  
    }
    
    static class Node {
		int index;
		int value;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
        
        public String toString(){
            return index + " " + value;
        }
	}
}