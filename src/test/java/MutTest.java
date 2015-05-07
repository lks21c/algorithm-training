import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MutTest {

	MutaliskEasy mu = new MutaliskEasy();

	@Test
	public void test1() {
		int[] val = { 12, 10, 4 };
		int count = mu.minimalAttacks(val);
		Assert.assertEquals(2, count);
	}

	@Test
	public void test1_sort() {
		int[] val = { 12, 10, 4 };
		mu.selectionSort(val);
		Assert.assertEquals(12, val[0]);
		Assert.assertEquals(10, val[1]);
		Assert.assertEquals(4, val[2]);
	}

	@Test
	public void test2() {
		int[] val = { 54, 18, 6 };
		int count = mu.minimalAttacks(val);
		Assert.assertEquals(6, count);
	}

	@Test
	public void test3() {
		int[] val = { 55, 60, 53 };
		int count = mu.minimalAttacks(val);
		Assert.assertEquals(13, count);
	}

	@Test
	public void test4() {
		int[] val = { 1, 1, 1 };
		int count = mu.minimalAttacks(val);
		Assert.assertEquals(1, count);
	}

	@Test
	public void test5() {
		int[] val = { 60, 40 };
		int count = mu.minimalAttacks(val);
		Assert.assertEquals(9, count);
	}

	@Test
	public void test6() {
		int[] val = { 60 };
		int count = mu.minimalAttacks(val);
		Assert.assertEquals(7, count);
	}

	public class MutaliskEasy {

		String[] hit = { "9", "3", "1" };
		String[][] list = new String[6][3];

		public int minimalAttacks(int[] x) {
			int size = x.length;

			// validation
			if (size < 1 || size > 3) {
				return -1;
			}

			for (int i = 0; i < size; i++) {
				if (x[i] < 1 || x[i] > 60) {
					return -1;
				}
			}
			int loop_count = 0;
			List<String> permutation = generatePermutations(hit);
			while (true) {
				// 비교
				// 순열로 차감 -> 정렬 -> 비교
				for (int i = 0; i < permutation.size(); i++) {
					int next_dead_count = 0;
					int dead_count = 0;
					int[] tmp = new int[size];
					// 차감
					for (int j = 0; j < size; j++) {
						tmp[j] = x[j] - Character.getNumericValue(permutation.get(i).charAt(j));
					}
					// 정렬
					selectionSort(tmp);
					// 비교
					for (int j = 0; j < size; j++) {
						if (Integer.parseInt(hit[j]) >= tmp[j]) {
							next_dead_count++;
						}
						if (tmp[j] <= 0) {
							dead_count++;
						}
					}
					if (dead_count == size) {
						return loop_count + 1;
					} else if (next_dead_count == size) {
						return loop_count + 2;
					}
				}
				// 정렬
				selectionSort(x);

				// 차감
				for (int j = 0; j < size; j++) {
					x[j] = x[j] - Integer.parseInt(hit[j]);
					System.out.print(x[j] + " ");
				}
				loop_count++;
			}
		}

		public void selectionSort(int[] list) {
			int indexMin, temp;

			for (int i = 0; i < list.length - 1; i++) {
				indexMin = i;
				for (int j = i + 1; j < list.length; j++) {
					if (list[j] > list[indexMin]) {
						indexMin = j;
					}
				}
				temp = list[indexMin];
				list[indexMin] = list[i];
				list[i] = temp;
			}
		}

		private List<String> generatePermutations(String[] elements) {
			List<String> permutations = new ArrayList<String>();
			if (elements.length == 2) {
				String x1 = elements[0] + elements[1];
				String x2 = elements[1] + elements[0];
				permutations.add(x1);
				permutations.add(x2);
			} else {
				for (int i = 0; i < elements.length; i++) {
					String[] elements2 = new String[elements.length - 1];
					int kalo = 0;
					for (int j = 0; j < elements2.length; j++) {
						if (i == j) {
							kalo = 1;
						}
						elements2[j] = elements[j + kalo];
					}
					List<String> k2 = generatePermutations(elements2);
					for (String x : k2) {
						String s = elements[i] + x;
						permutations.add(s);
					}
				}
			}
			return permutations;
		}
	}
}
