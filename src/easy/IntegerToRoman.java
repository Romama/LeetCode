package easy;

/**
 *  将一个Integer数字转换为罗马数字，范围 1-3999
 *  integer数据与罗马数字之间的对应关系，列举出来，建立一个二维数组
 * 	1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

	10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

	100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

	1000~3000: {"M", "MM", "MMM"}.
 */
public class IntegerToRoman {

	public static void main(String[] args){
		int a = 159;
		System.out.println(intToRoman(a));
	}
	
	/**
	 * int 类型数字转换为罗马数字
	 * @param num
	 * @return
	 */
	public static String intToRoman(int num){
		
		//注意给0设置 ""，罗马数字中不存在0的对应
        String[][] iTor = {
				{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},//0,1-9
				{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},//0,10-90
				{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},//0,100-900
				{"", "M", "MM", "MMM"}//0,1000-3000
		};
		String roman = "";
		int d = 0;
		while(num != 0){
			int pos = num % 10;
			roman = iTor[d][pos] + roman; //注意字符串拼接的顺序
			d++;
			num = num / 10;
		}
		return roman;
	}
}
