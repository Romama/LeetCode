package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出二叉树中所有从根结点到叶子结点的路径
 * @author admin
 *
 */
public class BianryTreePaths {

	//存储所有路径
	static List<String> list = new ArrayList<String>();
	//记录一条路径
	static List<Integer> path = new ArrayList<Integer>();
	public static void main(String[] args){
		 Object[] array = {1,2,3,4,5,6,7,8,9,10};  //构造二叉树的结点值
		 TreeNode root = BinaryTree.createBinaryTree(array);
		 System.out.println(binaryTreePaths(root));
	}
	
	/**
	 * 返回所有路径
	 * @param root
	 * @return
	 */
    public static List<String> binaryTreePaths(TreeNode root) {
       getPath(root);
       return list;
    }
    
    /**
     * 采用递归、回溯法
     * 先序遍历二叉树
     * @param root
     */
    public static void getPath(TreeNode root){
    	 if(root == null)
         	return;
    	 path.add(Integer.parseInt(root.val.toString()));
    	 if(root.left == null && root.right == null){
    		 List<Integer> newPath = new ArrayList<Integer>(path);
    		 String s = "";
    		 for (int i = 0; i < newPath.size(); i++) {
				if(i == 0){
					s = s + newPath.get(i) + "";
				} else {
					s = s + "->" + newPath.get(i); 
				}
			 }
    		 list.add(s);
    	 }
    	 
    	 getPath(root.left);
    	 getPath(root.right);
    	 
    	 path.remove(path.size() - 1);
    }
}
