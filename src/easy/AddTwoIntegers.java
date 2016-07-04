package easy;

public class AddTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(addTwoNums(10, 4));
	}
	
	//不使用 + - 求两个数的和
	public static int addTwoNums(int a,int b){
		int x = a ^ b;
		// << 的优先级要高于 &，因此，要将(a & b)用括号括起来
		int y = (a & b) << 1;
		return x + y;
	}

}
