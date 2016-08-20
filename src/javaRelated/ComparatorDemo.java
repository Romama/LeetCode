package javaRelated;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

/**
 * comparator实例，定义在类的外部
 * 1 优点：不会破坏源码；在类外部单独定义一次，可以在多处使用
 * @author i333083
 *
 */
public class ComparatorDemo{

	public int a;
	public int b;
	
	public ComparatorDemo(int a,int b){
		this.a = a;
		this.b = b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<ComparatorDemo> list = new ArrayList<ComparatorDemo>();
		ComparatorDemo one = new ComparatorDemo(6,4);
		ComparatorDemo two = new ComparatorDemo(4,5);
		list.add(one);
		list.add(two);
		
		System.out.println(list.get(0).a);
		System.out.println(list.get(1).a);
		Collections.sort(list,new ComparatorDemoCompare()); //进行排序
		
		System.out.println(list.get(0).a);
		System.out.println(list.get(1).a);
		
	}

}

//必须明确定义比较的类型
class ComparatorDemoCompare implements Comparator<ComparatorDemo>{
	
	@Override
	public int compare(ComparatorDemo a,ComparatorDemo b){
		return a.a - b.a;
	}
}
