import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cntArray = new int[26];

		String inputStr = sc.next();
		char[] charArray = inputStr.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			char target = charArray[i];
			target = Character.toUpperCase(target);
			int targetIndex = target - 65;
			cntArray[targetIndex]++;
		}

		int max = -1;
		char ans = '0';

		for (int i = 65; i < 91; i++) {
			char target = (char) i;
			int cnt = cntArray[i - 65];

			if (max < cnt) {
				max = cnt;
				ans = target;
			}
		}

		Arrays.sort(cntArray);

		if (cntArray[24] == cntArray[25]) {
			System.out.println("?");
		} else {
			System.out.println(ans);
		}

	}

}
