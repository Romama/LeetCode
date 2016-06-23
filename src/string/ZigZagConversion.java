package string;

/**
 * 给定一个字符串，将其按照之字的形状重新排列成一定的行，最后将排列后的字符按照行拼接起来，并返回。
 * 即循环对角线结构。
 * 向下循环:nRows
 * 斜角线循环:nRows-2(减去首尾两个端点)
 * 重复
 * @author Administrator
 *
 */
public class ZigZagConversion {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "ABCDE";
		int numRows = 4;
	    System.out.println(zigZag(s, numRows));	
		
	}
	
	/**
	 * 输出zigZag形式拼接的字符串
	 * 找规律，找出下标与所在行之间的关系
	 * 向下循环 numRows
	 * 斜对角线 numRows - 2（除去首尾两行）
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String zigZag(String s,int numRows){
		if(numRows <= 0 || s == null) return null;
		else if(numRows == 1 ||s.length() == 0 ) return s;
		String[] res = new String[numRows]; //存储各行的结果，初始化为""
		for(int i = 0; i < numRows; i++)
			res[i] = "";
		int i = 0;
		//为各行赋值
		while(i < s.length()){
			for(int j = 0;i < s.length() && j < numRows; j++) res[j] += s.charAt(i++); //向下循环
			for(int j = numRows - 2;i < s.length() && j > 0; j--) res[j] += s.charAt(i++); //对角线循环
		}
		
		String result = "";
		for(int k = 0; k < numRows; k++)
			result += res[k];
		return result;
	}

}
