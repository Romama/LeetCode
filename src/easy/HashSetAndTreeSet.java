package easy;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * set 不包含重复元素，确切的说，不包含满足 e1.equals(e2) 的元素对 e1 和 e2， 
 * @author i333083
 *
 */
public class HashSetAndTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Person> set = new HashSet<Person>();
		
		set.add(new Person(1,"a"));
		set.add(new Person(4,"b"));
		//加入自定义类型Person类型到set中，需要重写
		set.add(new Person(10,"c"));
		set.add(new Person(10,"c"));
		
		//遍历HashSet，hashset中的元素是无序的，是根据hash算法来的
		Iterator<Person> iterator = set.iterator();
		while(iterator.hasNext()){
			Person person = iterator.next();
			System.out.print(person.age + " " + person.name + "，");
		}
		
		System.out.println();
		//new PersonComparator
		Set<Person> treeSet = new TreeSet<Person>(new PersonComparator());
		treeSet.add(new Person(1,"a"));
		treeSet.add(new Person(2,"b"));
		treeSet.add(new Person(0,"h"));
		
		Iterator<Person> it = treeSet.iterator();
		while(it.hasNext()){
			Person p = it.next();
			System.out.println(p.age + " " + p.name + ", ");
		}
	}
}

//要想自定义对象类型可以满足HashSet的不重复，需要重写equals方法和hashcode方法
class Person{
	int age;
	String name;
	public Person(int age,String name){
		this.age = age;
		this.name = name;
	}
	
	public String toString(int age,String name){
		return "{age: "+age+",name："+name+"}";
	}
	
	//重新equals方法,为了进行等值比较
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Person){//若obj是instance的一个实例
			Person person = (Person)obj; //转换为Person类型
			if(person.age == age && person.name.equals(name))
				return true;
		}
		return false;
	}
	
	//重写hashcode，为了将对象加入到hashset、hashtable、hashmap这样的数据结构中
	//【原则】正确重写hashcode的原则：按照equals()中比较两个对象是否一致时用到的属性来重写hashCode()
	// 公式：属性1的int形式+ C1*属性2的int形式+  C2*属性3的int形式+ …
	// 当属性是引用类型的时候，如果已经重写过hashCode()，那么这个引用属性的int形式就是直接调用属性已有的hashCode值。
	@Override
	public int hashCode(){
		return name.hashCode() + 17 * age;
	}
}

//自定义排序方式
class PersonComparator implements Comparator<Person>{
	//自定义排序
	@Override
	public int compare(Person a,Person b){
		return b.age - a.age;
	}
}
