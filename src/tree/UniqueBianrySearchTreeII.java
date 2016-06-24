package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * @author WeiCuicui
 *
 */
public class UniqueBianrySearchTreeII {

	public static void main(String[] args){
		int n = 3;
		
		List<TreeNode> list = generateTrees(n);
		
		for(int i = 0; i < list.size(); ++i)
			System.out.println(list.get(i).val);
	}
	
	/**
	 * list集合中存储的是所有满足条件的二叉搜索树的根结点
	 * @param n
	 * @return
	 */
	public static List<TreeNode> generateTrees(int n) {
        if(n == 0)//输入n为0时，返回[]
           return new ArrayList<TreeNode>();
        return genTrees(1,n);
    }
    public static List<TreeNode> genTrees (int start, int end){

        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start > end){
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left,right;
        for(int i = start;i <= end; ++i){//分别以 1到n为根结点，构成二叉搜索树

            left = genTrees(start, i - 1); //递归生成左子树
            right = genTrees(i + 1,end); //递归生成右子树

            for(TreeNode lnode: left){
                for(TreeNode rnode: right){
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
