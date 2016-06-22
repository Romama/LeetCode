package linkedlist;


/**
 * 根据给定的值创建LinkedList
 * @author admin
 *
 */
public class CreateLinkedList {

	public static void main(String[] args){
		Object[] values = {1,2,3,7,9,11};
		LinkNode root = createLinkedList(values);
		while(root != null){
			System.out.print(root.val + " ");
			root = root.next;
		}
	}
	
	//根据给定values值创建单链表
	public static LinkNode createLinkedList(Object[] values){
		if(values == null || values.length == 0)
			return null;
		LinkNode root = new LinkNode(Integer.parseInt(values[0].toString())); //根节点
		LinkNode p = root; //指针，指向当前结点
		for(int i = 1 ; i < values.length; i++){
			LinkNode node = new LinkNode(Integer.parseInt(values[i].toString()));
			p.next = node;
			p = node;
		}
		return root;
	}
}
