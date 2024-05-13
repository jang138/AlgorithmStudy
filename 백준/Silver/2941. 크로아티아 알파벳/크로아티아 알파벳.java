import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int length = str.length();

		String[] alphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		int answer = str.length();

		Loop1: for (int i = 0; i < length; i++) {
			Loop2: for (int j = i + 2; j <= length; j++) {
				String subStr = str.substring(i, j);

				for (String al : alphabet) {
					if (al.equals(subStr)) {
						answer -= subStr.length() - 1;
						i += al.length() - 1;
						break Loop2;
					}
				}
			}
		}

		System.out.println(answer);

	}

}
