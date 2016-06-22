package tree;

/**
 * 根据先序和中序序列构造出二叉树
 * 递归
 * Construct Binary Tree from Inorder and Postorder Traversal
 * @author admin
 *
 */
public class BuildTreeByPreOrderAndInOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] preorder = {'a','b','d','h','j','e','k','l','c','f','g'};
		Object[] inorder = {'h','d','j','b','k','e','l','a','f','c','g'};
		TreeNode root = buildTree(preorder, inorder); //由先序和中序序列生成二叉树
		preOrder(root);
	}
	
	/**
	 * 输出：先序遍历二叉树
	 * @param root
	 */
	public static void preOrder(TreeNode root){
		if(root != null){
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	/**
	 * 根据先序遍历和中序遍历序列，生成二叉树
	 * @param preorder
	 * @param inorder
	 * @return
	 */
    public static TreeNode buildTree(Object[] preorder, Object[] inorder) {
    	 return buildPI(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);  
    }
    
    /**
     * 查找先序遍历中的当前结点值在中序遍历序列中的位置
     * @param preorder
     * @param inorder
     * @param p_s 先序遍历的起始
     * @param p_e 先序遍历的结束
     * @param i_s 中序遍历的起始
     * @param i_e 中序遍历的结束
     * @return
     */
    public static TreeNode buildPI(Object[] preorder, Object[] inorder, int p_s, int p_e, int i_s, int i_e){  
        if(p_s > p_e)  
            return null;  
        Object pivot = preorder[p_s];  //将中序遍历序列分为左、右两个部分
        int i = i_s;  
        for(;i < i_e;i++){  //在中序遍历序列中找到pivot的位置
            if(inorder[i] == pivot)  
                break;  
        }  
        TreeNode node = new TreeNode(pivot);  
        int lenLeft = i - i_s;  
        //递归生成左子树 ，preOrder中结束位置 p_s + lenleft，inorder中结束位置为i - 1 
        node.left = buildPI(preorder, inorder, p_s + 1, p_s + lenLeft, i_s, i - 1);  
        //递归生成右子树 ，preOrder中起始位置 p_s + lenleft + 1，inorder中起始位置为i + 1
        node.right = buildPI(preorder, inorder, p_s + lenLeft + 1, p_e, i + 1, i_e); 
        return node;  
    }  

}
