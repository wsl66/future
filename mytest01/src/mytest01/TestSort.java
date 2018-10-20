package mytest01;

public class TestSort {


	public static void main(String[] args) {
		int[] intArr = new int[] { 88, 25, 53, 78, 28, 38, 93, 52 };
		// choseSort(intArr);
		bubboSort(intArr);
	}

	/**
	 * 选择排序
	 * 
	 * @param intArr
	 */
	public static void choseSort(int[] intArr) {
		
		for (int i = 0; i < intArr.length - 1; i++) {// i为每次选择的最值索引值
			int temp = i;
			for (int j = i + 1; j < intArr.length; j++) {// 每次和temp比较的索引值
				if (intArr[temp] > intArr[j]) {
					temp = j;
				}
			}
			int tempVal = intArr[temp];
			intArr[temp] = intArr[i];
			intArr[i] = tempVal;
		}
		printArr(intArr);
	}

	/**
	 * 冒泡排序
	 * 
	 * @param intArr
	 */
	public static void bubboSort(int[] intArr) {

		for (int i = intArr.length - 1; i > 0; i--) {// i为每次最值确定的索引位置

			for (int j = 0; j < i; j++) {// j为两相邻比较元素的前一个索引
				if (intArr[j] > intArr[j + 1]) {
					int tempVal = intArr[j + 1];
					intArr[j + 1] = intArr[j];
					intArr[j] = tempVal;
				}
			}
		}
		printArr(intArr);

	}

	/**
	 * 打印数组
	 * 
	 * @param intArr
	 */
	private static void printArr(int[] intArr) {
		StringBuilder sb = new StringBuilder();
		sb.append("intArr=[");
		for (int i = 0; i < intArr.length; i++) {
			if (i == 0) {
				sb.append(intArr[i]);
				continue;
			}
			sb.append(",").append(intArr[i]);
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
}
