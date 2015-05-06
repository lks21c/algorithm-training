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

		int[] hit = { 9, 3, 1 };

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
			if (size == 1) {
				if ((x[0] % hit[0]) == 0) {
					return x[0] / hit[0];
				} else {
					return (x[0] / hit[0]) + 1;
				}
			} else if (size == 2) {
				int count = 0;
				while (true) {
					selectionSort(x);
					if (x[0] - hit[0] <= 0 && x[1] - hit[1] <= 0) {
						return count + 1;
					}
					x[0] = x[0] - hit[0];
					x[1] = x[1] - hit[1];
					count++;
				}
			} else if (size == 3) {
				int count = 0;
				while (true) {
					selectionSort(x);
					x[0] = x[0] - hit[0];
					x[1] = x[1] - hit[1];
					x[2] = x[2] - hit[2];
					count++;
					break;
				}
			}
			return -1;
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
	}
}
