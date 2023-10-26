import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		boolean u;

		if (year % 400 == 0) {
			u = true;
		} else if (year % 4 == 0 && year % 100 != 0) {
			u = true;
		} else {
			u = false;
		}

		System.out.println(u ? 1 : 0);
	}

}
