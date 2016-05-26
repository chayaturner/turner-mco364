package turner.mco364.puzzles;

import java.util.HashSet;
import java.util.Iterator;

public class Coins {

	private int[] list;
	private HashSet<Integer> listSet;

	public Coins(int[] list) {

		this.list = list;
		listSet = new HashSet<Integer>();
		setUpListSet();
	}

	private void setUpListSet() {
		for (int i = 0; i < list.length; i++) {
			if (!listSet.contains(list[i])) {
				listSet.add(list[i]);
			}
		}
	}

	private String showPairs(int sum) {

		Iterator<Integer> iter = listSet.iterator();
		StringBuilder build = new StringBuilder();
		while (iter.hasNext()) {
			int next = iter.next();
			if (next > 0) {
				if (listSet.contains(sum - next)) {
					build.append("(");
					build.append(next);
					build.append(",");
					build.append(sum - next);
					build.append(") ");
				}
			} else {
				if (listSet.contains(sum + next)) {
					build.append("(");
					build.append(next);
					build.append(",");
					build.append(sum + next);
					build.append(") ");
				}
			}

		}
		return build.toString();
	}

	public static void main(String[] args) {
		int[] list = { -1, 14, 3, 5, 6, 2, 8, 9, 13, 6, 4, 15, 0, 6, 8 };
		Coins m = new Coins(list);
		System.out.println(m.showPairs(15));

	}
}