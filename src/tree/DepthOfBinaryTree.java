package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
	 * 基于先序遍历算法，求二叉树的最大高度
	 * @param root
	 * @return
	 */
	public static int depthIteration(TreeNode root){
	
		if(root == null){
            return 0;
        }
		
		//存储每个结点的高度
        HashMap<TreeNode, Integer> depthMap = new HashMap<TreeNode,Integer>();
        
        //根结点的高度默认为1
        depthMap.put(root, 1);
        
        //记录最大高度
        int maxDepth = 1;
        
        //定义一个栈，用来进行先序遍历
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //结点出栈
            int depth = depthMap.get(node);
            maxDepth = Math.max(maxDepth, depth);
            if (node.right != null) {//迭代的先序遍历二叉树，首先压入右子树
                depthMap.put(node.right, depth + 1);
                stack.push(node.right);
            }
            if (node.left != null) {//然后压入左子树
                depthMap.put(node.left, depth + 1);
                stack.push(node.left);
            }
            
            //最后，将该结点对应的高度也从HashMap中删除
            depthMap.remove(node);
        }
        return maxDepth;
		
	}
	
	/**
	 * 方法三：
	 * 受层序遍历算法的启发，求出二叉树有多少层，也就知道了二叉树的高度是多少
	 * @param root
	 * @return
	 */
	public static int depthLevelTraversal(TreeNode root){
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int nCount = 1; //记录第n层的结点个数、
		int height = 0;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			nCount--;
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
			
			if(nCount == 0){ //遍历完一层,给nCount赋值下一层的结点个数
				height++;
				nCount = queue.size();
			}
		}
		return height;
	}
}
