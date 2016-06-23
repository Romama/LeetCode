package string;

/**
 * 找到字符串中第一个只出现一次的字符
 * @author Administrator
 * 由于字符（char）是一个长度为8的数据类型，因此总共有可能 256 种可能。
 * 于是我们创建一个长度为256的数组，每个字母根据其ASCII码值作为数组的下标对应数组的对应项，
 * 而数组中存储的是每个字符对应的次数。
 * 这样我们就创建了一个大小为256，以字符ASCII码为键值的哈希表。
 * 
 * （若仅限于英文字符，则可以采用长度为26的整形数组，用来存储26个英文字符出现的次数）
 */
public class FirstNotRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a2dmha2dh789789";
		System.out.println(findFirstNotRepeatedChar(str));

	}
	
	/**
	 * 一个字符的长度为8，长度为256的数组可以统计所有类型的字符
	 * 若不存在，则返回为 ' '
	 * @param str
	 * @return
	 */
	public static char findFirstNotRepeatedChar(String str){
		if(str == null || str.length() == 0)
			return ' ';
		int[] map = new int[256];
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(map[c] > 0){
				map[c]++; //次数加1
			} else {
				map[c] = 1;
			}
		}
		
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(map[c] == 1){
				return c;			
			}	
		}
		
		return ' ';
	}
}
