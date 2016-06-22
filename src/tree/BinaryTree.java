package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树类
 * @author Administrator
 *
 */
public class BinaryTree {
		 	
	/**
	 * 构造二叉树，完全二叉树
	 */
	public static TreeNode createBinaryTree(Object[] array) {  
		List<TreeNode> nodeList = new LinkedList<TreeNode>();  //定义一棵二叉树
        // 将一个数组的值依次转换为Node节点  
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {  

            nodeList.add(new TreeNode(array[nodeIndex]));  
        }  
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {  
        	// 左孩子  
            nodeList.get(parentIndex).left = nodeList  
                    .get(parentIndex * 2 + 1);  
            // 右孩子  
            nodeList.get(parentIndex).right = nodeList  
                    .get(parentIndex * 2 + 2);  
        }  
        
        if(array.length > 1){
        	// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
            int lastParentIndex = array.length / 2 - 1;  
            // 左孩子  
            nodeList.get(lastParentIndex).left = nodeList  
                    .get(lastParentIndex * 2 + 1);  
            // 右孩子,如果数组的长度为奇数才建立右孩子  
            if (array.length % 2 == 1) {  
                nodeList.get(lastParentIndex).right = nodeList  
                        .get(lastParentIndex * 2 + 2);  
            } 
        }
       
        return nodeList.get(0); //返回根节点
    }  
}