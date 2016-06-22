package linkedlist;


/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
   reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
   You must do this in-place without altering the nodes' values.
   For example,
   Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {

	public static void main(String[] args){
		Object[] values = {1,2,3,4,5};
		LinkNode head = CreateLinkedList.createLinkedList(values);
		LinkNode newHead = reorderList(head);
		while(newHead != null){
			System.out.print(newHead.val);
			newHead = newHead.next;
		}
		
	}
	
	//先对单链表的后半部分就地逆置，然后
	public static LinkNode reorderList(LinkNode head){
		if(head == null)
			return null;
		int len = 0;
		LinkNode p = head; //后半部分的起始结点p
		LinkNode q = p; 
		while(q != null){ //统计单链表的长度len
			len++;
			q = q.next;
		}
		
		if(len == 1 || len == 2)
			return head;
		
		//找到后半部分的起始结点p
		int pos = 0;
		while(pos < (len + 1) / 2){ 
			p = p.next;
			pos++;
		}
		
		//对后半部分进行就地逆置
		LinkNode pre = null;
		LinkNode cur = p;
		LinkNode next = null;
		while(cur != null){
			next = cur.next; //暂存next
			cur.next = pre; //新的next
			pre = cur; //当前结点记为pre
			cur = next;  //next作为新的cur
		}
		cur = pre; //逆置之后后半部分新的第一个结点
		
		
		//对单链表进行重新排序
		LinkNode newHead = new LinkNode(-1); //新链表的头结点
		newHead.next = head; 
		LinkNode nextPost = null; //记录后半部分的下一个结点
		
		//移动结点
		while(cur.next != null){
			next = head.next; //暂存head.next
			nextPost = cur.next; //暂存cur.next
			
			//拼接
			head.next = cur;  
			cur.next = next; 
			
			cur = nextPost;   //后半部分的当前结点
			head = next;  //前半部分的当前结点
		}
		
		if(len % 2 == 0){
			//处理尾结点
			head = null;
			return newHead.next;
		} else {
			//对最后一个结点进行处理
			next = head.next; 
			head.next = cur;  
			cur.next = next;
			
			//处理尾结点
			next.next = null;
			return newHead.next;
		}
	}
}
