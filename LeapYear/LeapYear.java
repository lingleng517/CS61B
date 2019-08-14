/**
	A leap year is either:
	divisible by 400 or
	divisible by 4 and not by 100
*/

public class LeapYear {
	public static void main(String[] args) {
		int year = Integer.parseInt(args[0]);
		if (isLeapYear(year)) {
			System.out.println(year + " is a leap year.");
		}
		else {
			System.out.println(year + " is not a leap year.");
		}
	}
	public static boolean isLeapYear(int year) {
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			return true;
		}
		else {
			return false;
		}
	}
}