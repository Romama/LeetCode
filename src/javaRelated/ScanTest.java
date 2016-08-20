package javaRelated;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ScanTest {

	public static void main(String[] args) {
		// 读取第一个输入，得到数组个数
		Scanner scanner = new Scanner(System.in);
		int groupLength = scanner.nextInt();
		//scanner.nextLine();

		// 由于不知道各个数组的长度，因此只能用List
		List[] temp = new List[groupLength];

		// 最终结果放在一个二维数组中
		Integer[][] result = new Integer[groupLength][];

		// 跳过第一个空行
		scanner.nextLine();

		for (int i = 0; i < groupLength; i++) {
			temp[i] = new LinkedList<Integer>();
			while (true) {
				String element = scanner.nextLine();
				// 发现一个空行，表示进入下一个数组
				if (element == null || "".equals(element)) {
					break;
				}
				temp[i].add(element);
			}
		}

		// 最终结果temp中的每个List[Integer]转化为result中的对应Integer[]
		for (int i = 0; i < groupLength; i++) {
			result[i] = (Integer[]) temp[i].toArray(new Integer[0]);
		}

		// 打印结果
		for (int i = 0; i < result.length; i++) {
			System.out.print("[");
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + ",");
			}
			System.out.println("]");
		}
	}
}
