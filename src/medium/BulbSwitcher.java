package medium;

/**
 * 
 * There are n bulbs that are initially off. 
 * You first turn on all the bulbs. 
 * Then, you turn off every second bulb. 
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). 
 * For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 * 
 * 一、从给定的题目中找到规律：就是，当 i 为  1 到 n之间的任何数时，翻转 k = ri 位置上灯泡的状态。
 * 求n轮之后，还有几盏灯是开着的？
 * 二、最直观的方法是穷举法：一轮轮的遍历，但是，当n很大时，时间复杂度太大。
 * 三、找规律：
 * 若起初有5盏灯，经过5轮翻转后，最终只有第1盏和第4盏是亮着的，不妨分析下，这里面是否有什么规律？
 * 起始：5盏灯全部为 off
 * 1 = （1,1）                                       1次翻转，最终on
 * 2 = （1,2），（2,1）                      2次翻转，最终off
 * 3 = （1,3），（3,1）                      2次翻转，最终off
 * 4 = （1,4），（2,2），（4,1）    3次翻转，最终on
 * 5 = （1,5），（5,1）                      2次翻转，最终off
 * 
 * 可以看出，最终为on的灯所在位置都是平方数
 * @author admin
 *
 */
public class BulbSwitcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		System.out.println(bulbSwitch(n));
	}
	
	//返回n轮之后，有多少盏灯是开着的
	public static int bulbSwitch(int n){
		if(n <= 0)
			return 0;
		int num = (int)Math.sqrt(n); //求n的平方根
		
		System.out.println(num);
		
		return num;
	}
}
