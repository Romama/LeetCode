package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 求二叉树的深度
 * @author WeiCuicui
 *
 */
public class DepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Object[] array = { 1, 2, 3, 4, 5, 6, 7 };  //构造二叉树的结点值
		 TreeNode root = BinaryTree.createBinaryTree(array);
		 
		 //递归算法求二叉树的深度
		 int h = depthRecursive(root);
		 System.out.println(h);
		 
		 //迭代算法求二叉树的深度
		 h = depthIteration(root);
		 System.out.println(h);
		 
		 //层次遍历算法求二叉树的深度
		 h = depthLevelTraversal(root);
		 System.out.println(h);
		 
	}
	
	/**
	 * 方法一：
	 * 递归求二叉树的深度
	 * 
	 * 结点为null时，深度为0
	 * 结点不为null，分别求出左、右子树的深度，
	 * 找出左、右结点深度的最大值
	 * 当前结点的深度即为上面所求的最大值
	 * @return
	 */
	public static int depthRecursive(TreeNode root){
		if(root == null)
			return 0;
		int left = depthRecursive(root.left);
		int right = depthRecursive(root.right);
		
		return left > right ? left + 1 : right + 1;
	}

	
	/**
	 * 方法二：
	 * 受层序遍历算法的启发，求出二叉树有多少层，也就知道了二叉树的高度是多少
	 * @param root
	 * @return
	 */
	public static int depthLevelTraversal(TreeNode root){
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int nCount = 1; //记录第n层的结点个数
		int height = 0;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			nCount--;
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
			
			if(nCount == 0){ //遍历完一层,给nCount赋值下一层的结点个数
				height++; //一层遍历完，高度加1
				nCount = queue.size();
			}
		}
		return height;
	}
	
	
	/**
	 * 方法三：
	 * 基于先序遍历算法，求二叉树的最大高度
	 * @param root
	 * @return
	 */
	public static int depthIteration(TreeNode root){
		
		if(root == null)
			return 0;
		HashMap<TreeNode, Integer> depthMap = new HashMap<TreeNode, Integer>();
		int maxDepth = 1;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		depthMap.put(root, 1);
		TreeNode node = null;
		int depth = 0;
		
		while(!stack.isEmpty()){
			node = stack.pop(); //出栈，下面对应将该节点的深度删除
			depth = depthMap.get(node);
			maxDepth = Math.max(depth, maxDepth);
			if(node.right != null){
				stack.push(node.right);
				depthMap.put(node.right, depth + 1); //右孩子结点的深度  = 父结点的深度 + 1
			}
			if(node.left != null){
				stack.push(node.left);
				depthMap.put(node.left, depth + 1); //左孩子结点的深度  = 父结点的深度 + 1
			}
			
			depthMap.remove(node); //伴随着结点的出栈，一定要将这个结点对应的高度删除掉
		}
	
		return maxDepth;
	}
}
