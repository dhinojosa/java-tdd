package com.xyzcorp.instructor.fibonacci;

public class FibonacciSequence {

	private static int loop(int n) {
		int[] f = new int[n + 2]; // 1 extra to handle case, n = 0
		int i;
		f[0] = 0;
		f[1] = 1;
		for (i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

	public static int apply(int i) {
		if (i < 0)
			throw new IllegalArgumentException("Number cannot be negative");
		if (i == 0 || i == 1)
			return i;
		// else return apply(i - 1) + apply(i - 2);
		return loop(i);
	}
}
