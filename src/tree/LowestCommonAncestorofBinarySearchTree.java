package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BST：binary search tree 二分查找树
 * 利用队列先入先出的性质
 * @author admin
 *
 */
public class LowestCommonAncestorofBinarySearchTree {

	public static void main(String[] args){
		Object[] values = {6,4,8,3,5,7,9}; 
		TreeNode root = BinaryTree.createBinaryTree(values); //构造二叉查找树
		TreeNode p = new TreeNode(7);
		TreeNode q = new TreeNode(3);
		TreeNode common = lowestCommonAncestor(root, p, q);
		if(common != null){
			System.out.println(common.val);
		}
		
		TreeNode com = LCA(root,p,q);
		if(com != null)
			System.out.println(com.val);
	}
	
	/**方法一
	 * 
	 * 给定一个二叉查找树（BST），寻找p和q的最小公共祖先结点
	 * 解题思路：首先找到到达p的路径和到达q的路径，将这两个路径存入队列中
	 * 然后对两个路径依次出队列，找出最后一组相同的结点，结束
	 * @param root
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
		if(root == null)
			return null;
		Queue<TreeNode> pPath = new LinkedList<TreeNode>();
		Queue<TreeNode> qPath = new LinkedList<TreeNode>();
		TreeNode pre = null;
		//返回true，说明该结点存在；否则，说明给定的结点不存在，则无需再比较
		if(findNode(root, p, pPath) && findNode(root, q, qPath)){
			while(!pPath.isEmpty() && !qPath.isEmpty()){
				TreeNode pNode = pPath.poll();
				TreeNode qNode = qPath.poll();
				if(pNode == qNode){ //记录最后一组相同结点
					pre = pNode;
				} else { //一旦不同，跳出循环
					break;
				}
			}
		}
		return pre;
	}
	
	/**
	 * 在二叉树中查找结点p
	 * 将其祖先结点依次存入队列
	 * 返回true，说明该结点存在；否则，说明给定的结点不存在，则无需再比较
	 * @param root
	 * @param p
	 * @param stack
	 */
	public static boolean findNode(TreeNode root,TreeNode p,Queue<TreeNode> queue){ 
		if(root == null)
			return false;
		if(p.val == root.val){
			queue.add(root);
			return true;
		}
		else if(Integer.valueOf(p.val.toString()) < Integer.valueOf(root.val.toString())){ //在左子树查找
			queue.add(root);
			return findNode(root.left, p, queue);
		} 
		else {//在右子树查找
			queue.add(root);
			return findNode(root.right, p, queue);
		}
	}
	
	/** 方法二
	 * 
	 * 递归算法
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode LCA(TreeNode root,TreeNode p,TreeNode q){
		  if (root == null || p == null || q == null) return null;
		  if (Integer.valueOf(p.val.toString()) < Integer.valueOf(root.val.toString()) && Integer.valueOf(q.val.toString()) < Integer.valueOf(root.val.toString())) //两个结点都在左子树
		    return LCA(root.left, p, q);
		  else if (Integer.valueOf(p.val.toString()) > Integer.valueOf(root.val.toString()) && Integer.valueOf(q.val.toString()) > Integer.valueOf(root.val.toString())) //两个结点都在右子树
		    return LCA(root.right, p, q);
		  else
		    return root; //若两个结点一个在左子树上，另一个在右子树上，则共同祖先结点为当前的root
	}
}
