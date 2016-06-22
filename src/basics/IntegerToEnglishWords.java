package basics;

/**
 * 将一个整型数字用英文表示
 * @author admin
 *
 */
public class IntegerToEnglishWords {

	public static void main(String[] args){
		int num = 12348;
		System.out.println(numberToWords(num));
	}
	
	/**
	 * 分段
	 * @param num
	 * @return
	 */
	public static String numberToWords(int num) {
        if (num < 0) {
            return "";
        }
        //数字为0直接返回
        if (num == 0) {
            return "Zero";
        }
 
        //左起段落
        int segment1 = num / 1000000000;           //段落1：十亿位-千亿位
        int segment2 = num % 1000000000 / 1000000; //段落2：百万位-亿位
        int segment3 = num % 1000000 / 1000;       //段落3：千位-十万位
        int segment4 = num % 1000;                 //段落4：个位-百位
 
        String result = "";
         
        if (segment1 > 0) {
            result += numToWordsLessThan1000(segment1) + " " + "Billion";
        }
        if (segment2 > 0) {
            result += numToWordsLessThan1000(segment2) + " " + "Million";
        }
        if (segment3 > 0) {
            result += numToWordsLessThan1000(segment3) + " " + "Thousand";
        }
        if (segment4 > 0) {
            result += numToWordsLessThan1000(segment4);
        }
 
        return result.trim(); //去掉字符串result的首尾空格
    }
    
	/**
	 * 对1000以内的数进行转换
	 * @param num
	 * @return
	 */
   private static String numToWordsLessThan1000(int num) {
         
        if (num == 0 || num >= 1000) {
            return "";
        }
        String result = "";
        if (num >= 100) {
            result += numToWordsBase(num / 100) + " " + "Hundred";
        }
        num = num % 100;
        if (num > 20) {
            result += numToWordsBase(num / 10 * 10);
            if (num % 10 != 0) { 
                result += numToWordsBase(num % 10);
            }
        } else if (num > 0) {
            result += numToWordsBase(num);
        }
         
        return result;
    }
    
   /**
    * 一些基本english words
    * @param num
    * @return
    */
    private static String numToWordsBase(int num) {
        String result = " ";
        switch (num) {
        case 1: result += "One"; break;
        case 2: result += "Two"; break;
        case 3: result += "Three"; break;
        case 4: result += "Four"; break;
        case 5: result += "Five"; break;
        case 6: result += "Six"; break;
        case 7: result += "Seven"; break;
        case 8: result += "Eight"; break;
        case 9: result += "Nine"; break;
        case 10: result += "Ten"; break;
        case 11: result += "Eleven"; break;
        case 12: result += "Twelve"; break;
        case 13: result += "Thirteen"; break;
        case 14: result += "Fourteen"; break;
        case 15: result += "Fifteen"; break;
        case 16: result += "Sixteen"; break;
        case 17: result += "Seventeen"; break;
        case 18: result += "Eighteen"; break;
        case 19: result += "Nineteen"; break;
        case 20: result += "Twenty"; break;
        case 30: result += "Thirty"; break;
        case 40: result += "Forty"; break;
        case 50: result += "Fifty"; break;
        case 60: result += "Sixty"; break;
        case 70: result += "Seventy"; break;
        case 80: result += "Eighty"; break;
        case 90: result += "Ninety"; break;
        }
        return result;
    }
}
