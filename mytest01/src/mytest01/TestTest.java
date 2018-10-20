package mytest01;

import org.junit.Test;

public class TestTest {

	@Test
	public void test1() {
		int x = 6;
		int y = 8;
		boolean b;
		b = x < y || ++x == --y;
		System.out.println(b);
		System.out.println(x);
		System.out.println(y);

	}

	@Test
	public void test2() {
		int b[][] = { { 1, 1, 1 }, { 2, 2 }, { 3 } };
		int sum = 0;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				sum += b[i][j];
			}
		}

		System.out.println(sum);
	}

	@Test
	public void test3() {
		int[] x = { 125, 21, 5, 168, 98 };
		int max = x[0];
		for (int i = 0; i < x.length; i++) {
			if (x[i] > max) {
				max = x[i];
			}
		}
		System.out.println(max);
	}

	@Test
	public void test4() {
		StringBuffer bf = new StringBuffer("Beijing2008");
		bf.insert(7, "@");
		System.out.println(bf.toString());
	}

}

class P {

}

class A extends P {

}

class B extends P {

}