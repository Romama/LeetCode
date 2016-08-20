package javaRelated;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * 使用comparable实例，需要覆盖compareTo方法
 * 1 好处：在类的内部实现，
 * 2 缺点：要修改源代码的数据结构
 * @author i333083
 *
 */
public class ComparableDemo implements Comparable<ComparableDemo> {

	public int attribute1;
	public String attribute2;
	
	//the constructor
	public ComparableDemo(int a,String b){
		attribute1 = a;
		attribute2 = b;
	}
	
	//重写方法 compareTo
	@Override
	public int compareTo(ComparableDemo demo){
		return this.attribute1 - demo.attribute1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<ComparableDemo> list = new ArrayList<ComparableDemo>();
		ComparableDemo one = new ComparableDemo(5,"dd");
		ComparableDemo two = new ComparableDemo(2,"ge");
		list.add(one);
		list.add(two);
		System.out.println(list.get(0).attribute1);
		System.out.println(list.get(1).attribute1);
		Collections.sort(list);
		System.out.println(list.get(0).attribute1);
		System.out.println(list.get(1).attribute1);
	}

}
