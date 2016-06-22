package tree;

/**
 * 根据后序和中序遍历序列还原二叉树
 * Construct Binary Tree from Postorder and Inorder Traversal
 * @author admin
 *
 */
public class BuildTreeByPostOrderAndInOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] postorder = {'h','j','d','k','l','e','b','f','g','c','a'}; //11个结点
		Object[] inorder = {'h','d','j','b','k','e','l','a','f','c','g'};
		TreeNode root = buildTree(postorder, inorder); //由先序和中序序列生成二叉树
		postOrder(root);
	}
	
	/**
	 * 后序遍历二叉树
	 * @param root
	 */
	public static void postOrder(TreeNode root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val + " ");
		}
	}
	
	/**
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public static TreeNode buildTree(Object[] postorder,Object[] inorder){
		return buildBT(postorder,inorder,0,postorder.length - 1,0,inorder.length - 1);
	}
	
	/**
	 * 
	 * @param postorder
	 * @param inorder
	 * @param p_s
	 * @param p_e
	 * @param i_s
	 * @param i_e
	 * @return
	 */
	public static TreeNode buildBT(Object[] postorder,Object[] inorder,int p_s,int p_e,int i_s,int i_e){
		if(p_s > p_e)
			return null;
		
		Object pivot = postorder[p_e];  //分界点
		int i = i_s;
		for (; i < i_e; i++) {
			if(inorder[i] == pivot)
				break;
		}
		
		int leftlen = i - i_s; 
	
		 //递归生成左子树 
        TreeNode left = buildBT(postorder, inorder, p_s, p_s + leftlen - 1, i_s, i - 1);  
        //递归生成右子树 
        TreeNode right = buildBT(postorder, inorder, p_s + leftlen, p_e - 1, i + 1, i_e); 
		
        //生成根结点，并赋值左右孩子结点
        TreeNode node = new TreeNode(pivot);  //后根遍历，根在最后
        node.left = left;
        node.right = right;
		return node;
		
	}
}
