package tree;

import java.util.ArrayList;
import java.util.List;

//多叉树的节点  
public class ManyTreeNode {  
	    
    //节点的内容  
    private MultiTreeNode  data ;  
    
    //节点列表  
  	private List<ManyTreeNode> childList; 
    
    public MultiTreeNode getData() {
	    return data;
    }
	
	public void setData(MultiTreeNode data) {
		this.data = data;
	}
	
	public List<ManyTreeNode> getChildList() {
		return childList;
	}
	
	public void setChildList(List<ManyTreeNode> childList) {
		this.childList = childList;
	}
	    
	//构造函数  
	public ManyTreeNode(){  
	    data = new MultiTreeNode();  
	    childList = new ArrayList<ManyTreeNode>();  
	}  
	    
	//构造函数 可以指定key的值  
	public ManyTreeNode(int key){  
	    data = new MultiTreeNode();  
	    data.setKey(key);  
	    childList = new ArrayList<ManyTreeNode>();  
	}      
}  