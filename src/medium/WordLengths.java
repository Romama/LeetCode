package medium;

/**
 * mask思想，如何用int来记录一个word
 * Maximum Product of Word Lengths
 * @author Administrator
      因为题目中说都是小写字母，那么只有26位，一个整型数int有32位，我们可以用后26位来对应26个字母,
      若为1，说明该对应位置的字母出现过，那么每个单词的都可由一个int数字表示，
      两个单词没有共同字母的条件是这两个int数相与为0
 */
public class WordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"add","ded","eft","eiiowee","ouou"};
		System.out.println(maxProduct(words));
	}
	
	public static int maxProduct(String[] words){
		int maxProduct = 0; //结果
		int[] mask = new int[words.length]; //记录每一个word
        for (int i = 0; i < words.length; ++i) { //对所有word进行两两比较，嵌套循环，避免了 a*b,b*a的重复判断
        	//将每一个word单词用int表示
        	for(int k = 0; k < words[i].length(); k++){
        		mask[i] |= 1 << (words[i].charAt(k) - 'a');
            }
            for(int j = 0; j < i; ++j) {       
            	//若两个word无相同元素，则计算乘积，更新maxProduct
                if ((mask[i] & mask[j]) == 0) { //更新
                	maxProduct = maxProduct >= (words[i].length() * words[j].length()) ? maxProduct : words[i].length() * words[j].length();      
                }
            }
        }
        return maxProduct;
	}

}
