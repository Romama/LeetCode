package linkedlist;


/**
 * 从单链表的尾部开始，删除第n个元素，并返回删除元素后新链表的第一个结点
 * 要求只遍历一趟
 * @author admin
 *
 */
public class RemoveNthNodeFromEndofList {

	public static void main(String[] args){
		int[] a = {2,3};
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
		
		LinkNode head = removeNthNode(heada.next, 2);
		if(head == null)
			System.out.println("error");
		else {
			while(head != null){
				System.out.print(head.val);
				head = head.next;
			}
		}	
	}
	
	//使用两个指针，相差n，特殊分析 n为链表长度的情况
	public static LinkNode removeNthNode(LinkNode head,int n){
		if(head == null) return null;
		LinkNode slow = head;
		LinkNode fast = head;
		int k = 1;
		
		//找到相差n的结点
		while(fast != null && k < n){
			fast = fast.next;
			k++;
		}
		
		//若n > 链表长度，无效
		if(fast == null)
			return null;
		// n == 链表长度
		if(fast.next == null) { //slow 位置即要删除的元素
			return head.next;
		}
		
		//查找倒数第n个结点
	    LinkNode pre = null; //记录删除结点的前驱
		while(fast.next != null){
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}
		
		pre.next = pre.next.next; //删除结点
		return head; //返回新链表的首结点
	}
}
