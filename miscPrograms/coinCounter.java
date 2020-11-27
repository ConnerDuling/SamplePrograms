import java.util.Scanner;

public class coinCounter {

	// Find the minimum number of coins required to make n cents.
	// You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.
	// For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢,
	// and a 1¢.

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("How many dollars do you have?");
		
		double dollars = kb.nextDouble();
		System.out.println("You need a minimum of "+ coinsTotal(dollars) +" coins to make up $"+String.format(("%.2f"), dollars));
	}

	public static int coinsTotal(int cents) {
		int count = 0;
		while (cents >= 25) {
			count++;
			cents -= 25;
		}
		while (cents >= 10) {
			count++;
			cents -= 10;
		}
		while (cents >= 5) {
			count++;
			cents -= 5;
		}
		while (cents >= 1) {
			count++;
			cents -= 1;
		}

		return count;
	}

	public static int coinsTotal(double dollars) {
		dollars = dollars * 100;
		return coinsTotal((int) dollars);
	}
}
