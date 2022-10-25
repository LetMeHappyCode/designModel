package class08;

public class Code09_NQueens {

	public static int num1(int n) {
		if (n < 1) {
			return 0;
		}
		int[] record = new int[n];  //第i行的皇后放在第几列
		return process1(0, record, n);
	}
	//目前在第i行
	//record[0..i-1] 表示之前的行，放了皇后的位置
	//n代表整体有多少行
	//返回值是，拜完所有的皇后摆法多少种
	public static int process1(int i, int[] record, int n) {
		if (i == n) {
			return 1;
		}
		int res = 0;
		//当前行在i行，尝试i行所有的列 -》 j
		for (int j = 0; j < n; j++) {
			//当前i行的皇后，放在j列，会不会和之前（0.。i-1）的黄昏后，共行共列或者共斜线
			//如果是，无效；如果不是，认为有效
			if (isValid(record, i, j)) {
				record[i] = j;
				res += process1(i + 1, record, n);
			}
		}
		return res;
	}

	//record[0..i-1]需要看，record[i..]不需要看
	//返回i行皇后，放在j列是否有效
	public static boolean isValid(int[] record, int i, int j) {
		for (int k = 0; k < i; k++) {
			//两个坐标的行相减的绝对值 等于  两个坐标列相减的绝对值，则在同一列
			if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
				return false;
			}
		}
		return true;
	}
	//优化后
	public static int num2(int n) {
		if (n < 1 || n > 32) {
			return 0;
		}
		int upperLim = n == 32 ? -1 : (1 << n) - 1;
		return process2(upperLim, 0, 0, 0);
	}

	public static int process2(int upperLim, int colLim, int leftDiaLim,
			int rightDiaLim) {
		if (colLim == upperLim) {
			return 1;
		}
		int pos = 0;
		int mostRightOne = 0;
		pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
		int res = 0;
		while (pos != 0) {
			mostRightOne = pos & (~pos + 1);
			pos = pos - mostRightOne;
			res += process2(upperLim, colLim | mostRightOne,
					(leftDiaLim | mostRightOne) << 1,
					(rightDiaLim | mostRightOne) >>> 1);
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 14;

		long start = System.currentTimeMillis();
		System.out.println(num2(n));
		long end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start) + "ms");

		start = System.currentTimeMillis();
		System.out.println(num1(n));
		end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start) + "ms");

	}
}
