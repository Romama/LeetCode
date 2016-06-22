package tree;

import java.util.Stack;

/**
 * 求最近公共祖先结点
 * @author Administrator
 *
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] array = {10,9,11,8,7,12,13};
		TreeNode root = BinaryTree.createBinaryTree(array);
		Object a = 8; 
		Object b = 12;
		int max = 26;
		
		//s1记录从根节点到a的所有父节点
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		findAllAncestors(root, a, s1);
		
		//s2记录从根节点到b的所有父节点
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		findAllAncestors(root, b, s2);
		
		for (int i = 0; i < s1.size(); i++) {
			System.out.print(Integer.parseInt(s1.get(i).val.toString()) + " ");
		}
		System.out.println();
		for (int i = 0; i < s2.size(); i++) {
			System.out.print(Integer.parseInt(s2.get(i).val.toString()) + " ");
		}
		System.out.println();
		
		int lowestCommonNode = 0;
		for(int i = 0; i < s1.size() && i < s2.size(); i++){
			if(s1.get(i).val.toString().equals(s2.get(i).val.toString())){
				lowestCommonNode = Integer.parseInt(s1.get(i).val.toString());
			}
		}
		
		System.out.println(lowestCommonNode);
		Stack<TreeNode> stack = new Stack<TreeNode>();
		//findAllPaths(root, stack, max, 0);
		findAllAncestors_BST(root, a, stack);
		System.out.println();
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(Integer.parseInt(stack.get(i).val.toString()) + " ");
		}
		
	}
	
	//查找节点a的所有祖先节点。适用于普通二叉树
	public static boolean findAllAncestors(TreeNode root,Object a,Stack<TreeNode> stack){
		if(root == null)
			return false;
		stack.push(root);
		if(root.val.equals(a)){
			return true;
		}
		boolean result = findAllAncestors(root.left, a, stack);
		if(!result)
			result = findAllAncestors(root.right, a, stack);
		if(!result)
		   stack.pop();
		return result;
	}
	
	//查找节点a的所有祖先节点。适用于二叉查找树
	public static boolean findAllAncestors_BST(TreeNode root,Object a,Stack<TreeNode> stack){
		if(root == null)
			return false;
		stack.push(root);
		if(root.val.equals(a)){
			return true;
		}
		boolean result = false;
		if(Integer.parseInt(root.val.toString()) > Integer.parseInt(a.toString())){
			result = findAllAncestors_BST(root.left, a, stack); //在左子树中查找
		} 
		if(Integer.parseInt(root.val.toString()) < Integer.parseInt(a.toString())){
			result = findAllAncestors_BST(root.right, a, stack);
		}
		if(!result)
		   stack.pop();
		return result;
	}
	
	//查找和为sum的所有路径
	public static void findAllPaths(TreeNode root,Stack<TreeNode> stack,int sum,int curSum){
		if(root == null)
			return;
		stack.push(root);
		curSum = curSum + Integer.parseInt(root.val.toString());
		if(curSum == sum){
			for (int i = 0; i < stack.size(); i++) {
				System.out.print(Integer.parseInt(stack.get(i).val.toString()) + " ");
			}
			System.out.println();
		}
		findAllPaths(root.left, stack,sum,curSum);
		findAllPaths(root.right, stack,sum,curSum);
		TreeNode tmp = stack.pop();
		curSum = curSum - Integer.parseInt(tmp.val.toString());
	}
}
