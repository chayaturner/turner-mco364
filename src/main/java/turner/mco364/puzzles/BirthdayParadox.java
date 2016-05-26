package turner.mco364.puzzles;

import java.util.Random;

//class group project- # ppl needed for odds of having same birthday

public class BirthdayParadox {
	static final Random RAND = new Random();

	public static void main(String[] args) {

		double percentage = 0.0;
		int ppl = 2;

		while (percentage < .99) {
			double timesTrue = 0;
			for (int i = 0; i < 10000; i++) {
				if (findDuplicateBirthdays(ppl)) {
					timesTrue++;
				}
			}
			percentage = timesTrue / 10000;
			System.out.println(ppl + " : " + percentage);
			ppl++;
		}
	}

	public static boolean findDuplicateBirthdays(int ppl) {
		boolean[] birthdays = new boolean[365];
		int day;

		for (int i = 0; i < ppl; i++) {
			day = RAND.nextInt(365);

			if (!birthdays[day]) {
				birthdays[day] = true;
			} else {
				return true;
			}
		}

		return false;
	}
}