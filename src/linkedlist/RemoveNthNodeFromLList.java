package linkedlist;


/**
 * 删除单链表中的第n个结点
 * @author admin
 *
 */
public class RemoveNthNodeFromLList {

	public static void main(String[] args){
		int[] a = {2,3,5,7,10};
		int[] b = {1,4,6,8,12};
		LinkNode heada = new LinkNode(-1);
		LinkNode headb = new LinkNode(-1);
		LinkNode l1 = heada;
		LinkNode l2 = headb;
		for(int i = 0; i < a.length; i++){
			l1.next = new LinkNode(a[i]);
			l1 = l1.next;
		}
		for(int i = 0; i < b.length; i++){
			l2.next = new LinkNode(b[i]);
			l2 = l2.next;
		}
		
		LinkNode newHead = removeNthNode(heada, 5);
		while(newHead != null){
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
	}
	
	/**
	 * 删除单链表中的第n个结点
	 * @param list
	 * @param n
	 */
	public static LinkNode removeNthNode(LinkNode list,int n){
		LinkNode head = list;  //list为带头结点的单链表，带头结点时，删除链表第一个结点不需要特殊处理，否则需要特殊处理
		int j = 0;
		while(head.next != null && j < n - 1){//寻找第i个结点head.next，其中，head指向其前驱
			j++;
			head = head.next;
		}
		
		if(head == null || j > n - 1) return null;
		
		head.next = head.next.next;
		
		return list.next;
	}
}
