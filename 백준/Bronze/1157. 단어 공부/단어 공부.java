import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> hashmap = new HashMap<>();

		for (int i = 65; i < 91; i++) {
			hashmap.put((char) i, 0);
		}

		String inputStr = sc.next();
		char[] charArray = inputStr.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			char target = charArray[i];
			target = Character.toUpperCase(target);
			hashmap.put(target, hashmap.get(target) + 1);
		}

		int[] countArray = new int[26];
		int max = -1;
		char ans = '0';

		for (int i = 65; i < 91; i++) {
			char target = (char) i;
			countArray[i - 65] = hashmap.get(target);

			if (max < hashmap.get(target)) {
				max = hashmap.get(target);
				ans = target;
			}
		}

		Arrays.sort(countArray);

		if (countArray[24] == countArray[25]) {
			System.out.println("?");
		} else {
			System.out.println(ans);
		}

	}

}
