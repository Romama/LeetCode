package basics;

/**
 * 从 1开始，读：11，表示1个1
 * 下一个，读作21，表示2个1，
 * 1211，表示1个2，1个1......依次类推
 * 给出n，返回第n个元素，可以将其作为string 字符串处理
 * @author admin
 *
 */
public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String num = "1113";
		System.out.println(next(num));
		System.out.println(getNth(5));
	}

	public static String getNth(int n){
		if(n <= 0) return null;
		String num = "1"; //第1个串为1
		int i = 1; //计数
		while(i < n){
			num = next1(num) ;
			i++;
		}	
		return num;
	}
	
	//从1开始
	public static String next(String num){
		String res = "";
		char[] ele = num.toCharArray(); //转换为字符数组
		
		for (int i = 1; i <= ele.length; i++) { //i的范围：1到ele.length
			int j = i;
			while(j < ele.length){
				if(ele[j] == ele[j - 1]){
					j++;
					continue;
				}
				else
					break; //跳出while循环
			}
			if(j == ele.length){ //已经判断到最后一个元素，结束
				res = res + (j + 1 - i) + ele[j - 1];
				break;
			}else {
				res = res + (j + 1 - i) + ele[j - 1];
				i = j; //给i赋新的值，然后再去执行i的for循环进行判断， 若i <= ele.length， i++，然后进行循环体
			}
		}

		return res;
	}
	
	//从0开始
	public static String next1(String num){ //根据当前num，生成下一个num
        char[] ele = num.toCharArray(); //转换为字符数组
        String res = ""; //存储结果
        for(int i = 0; i < ele.length; i++){ //遍历ele
            int j = i + 1;
            while(j < ele.length){
                if(ele[j] == ele[j - 1]){
                    j++;
                }else{
                    break;
                }
            }
            
            if(j == ele.length){
                res = res + (j - i) + ele[j - 1];
                break;
            } else{
                res = res + (j - i) + ele[j - 1];
                i = j - 1;
            }
        }
        
        return res;
    }
}
