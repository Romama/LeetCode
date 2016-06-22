package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * java的输入输出
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int i = in.nextInt(); //输入测试用例的组数
		//in.nextLine();
		while (i > 0) {
			List<Integer> list = new ArrayList<Integer>();
			String s = in.next();
			//list.add(in.nextInt());
			
			System.out.print(s);
			//System.out.println(a + b);
			i--;
		}
		
		/*Integer i01 = 59;
		int i02 = 59;
		Integer i03 = Integer.valueOf(59);
		Integer i04 = new Integer(59);
		System.out.println(i01 == i02);
		System.out.println(i03 == i02);
		System.out.println(i04 == i02);
		
		System.out.println(i01 == i03);
		
		System.out.println(i01 == i04);
		System.out.println(i03 == i04);*/
	}
}
