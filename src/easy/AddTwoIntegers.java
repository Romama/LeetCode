package easy;

//不用加减乘除求两个数的和，使用位运算
public class AddTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(addTwoNums(10, 3));
	}
	
	//不使用 + - 求两个数的和
	public static int addTwoNums(int a,int b){
		//首先求本位值，异或，相同为0，不同为1
		int x = a ^ b;
		
		// 求各位向上一位的进位，与运算，然后向左移位
		// << 的优先级要高于 &，因此，要将(a & b)用括号括起来
		int y = (a & b) << 1;
		
		if(y == 0){
			return x;
		} else {
			return addTwoNums(x,y); //递归
		}
	
	}

}
