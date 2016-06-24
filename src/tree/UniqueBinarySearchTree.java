package tree;


/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 给定一组二叉树的结点值，根据这些值可以组成多少种结构不同的二叉查找树
 * @author WeiCuicui
 *
 */
public class UniqueBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 1;
		System.out.println("递归求解： " + getNumOfDifferentBST_Recursive(n));
		
		System.out.println("迭代求解(动态规划)： " + getNumOfDifferentBST_Iterative(n));
	}
	
	/**
	 * 返回二叉搜索树的个数
	 * 
	 * 递归(时间复杂度大，可能造成内存不够)
	 * 
	 * 思路：dp[i]存储1到i的结点组成的二叉搜索树的数量，定义dp[0]为1，已知dp[1]为1 ，dp[2]为2，dp[3]为5...
	 * 如何求得dp[n]是问题的关键
	 * 第一步：确定根结点
	 * 第二步：确定左子树中结点个数，及左子树中可能组成的二叉搜索树的数量 a
	 * 第三步：确定右子树中的结点个数，及右子树中可能组成的二叉搜索树的数量 b
	 * 第四步：a*b即以当前结点为根结点的二叉搜索树的个数
	 * @param n
	 * @return
	 */
	public static int getNumOfDifferentBST_Recursive(int n){
		if(n == 0) //定义 n为0时，返回1，因为需要作乘法运算
			return 1;
		if(n == 1)
			return 1;
		int count = 0;
		for(int i = 1; i <= n; ++i)
		    count = count + getNumOfDifferentBST_Recursive(i - 1) * getNumOfDifferentBST_Recursive(n - i);
		
		return count;
	}
	
	/**
	 * 非递归
	 * @param n
	 * @return
	 */
	public static int getNumOfDifferentBST_Iterative(int n){
		
		if(n < 0)
			return -1;
		if(n == 0)
			return 1;
		
		//定义动态规划数组
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
	
		for(int i = 2; i <= n; ++i){//由i个结点构成的二叉搜索树的个数
			for(int j = 1; j <= i; ++j)//分别以j为根结点时的二叉搜索树个数
			    dp[i] += dp[j - 1] * dp[i - j];
		}
		
		return dp[n];
	}
	
	

}
