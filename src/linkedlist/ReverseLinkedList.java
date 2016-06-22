package linkedlist;

import java.util.Stack;


/**
 * 将链表逆置，返回新的头结点
 * @author admin
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args){
		
		//构建单链表
		int[] b = {1,4,6,8,12};
		LinkNode headb = new LinkNode(-1); //单链表的头结点
		LinkNode l2 = headb; //遍历的指针l2
		for(int i = 0; i < b.length; i++){
			l2.next = new LinkNode(b[i]);
			l2 = l2.next;
		}
		
		//构建双向链表
		int[] a = {3,6,2,1,7,9,10,5};
		DoubleLinkNode heada = new DoubleLinkNode(-1); //双向链表的头结点
		DoubleLinkNode l1 = heada; //遍历的指针 l1
		for(int i = 0; i < a.length; i++){
			DoubleLinkNode tmp = new DoubleLinkNode(a[i]);
			l1.next = tmp;
			tmp.pre = l1;
			l1 = l1.next;
		}
		
		//输出双向链表
		//DoubleLinkNode newHead = reverseDoubleList(heada.next);
		DoubleLinkNode newHead = reverseDoubleList_Create(heada.next);
		System.out.println(newHead.val + " : " + newHead.pre + " : " + newHead.next.val);
		newHead = newHead.next;
		while(newHead.next != null){
			System.out.println(newHead.val + " : " + newHead.pre.val + " : " + newHead.next.val);
			newHead = newHead.next;
		}
		System.out.println(newHead.val + " : " + newHead.pre.val + " : " + newHead.next);
		
		//翻转a链表
		//LinkNode headc = reverseLink(headb.next); //headb.next，为第一个结点
		LinkNode headc = createReverseList(headb.next); //headb.next，为第一个结点
		while(headc != null){
			System.out.print(headc.val);
			headc = headc.next;
		}
	}
	
	
	/**
	 * 单链表
	 * 就地翻转，常量空间复杂度O(1)。（修改了原有单链表的结构）
	 * @param l
	 * @return
	 */
	public static LinkNode reverse(LinkNode l){
		if(l == null || l.next == null) return l;
		LinkNode pre = null;
		LinkNode cur = l;
		LinkNode next;
		while(cur != null){
			next = cur.next; //next
			cur.next = pre; //pre与cur关联
			pre = cur; //新的pre
			cur = next; //新的next
		}
		//返回翻转后新的头结点
		return pre;
	}
	 
	/**
	 * 单链表
	 * 借助于stack来进行翻转
	 * @param node
	 * @return
	 */
	public static LinkNode reverseLink(LinkNode head){
		if(head == null)
	        return head;
		Stack<LinkNode> s = new Stack<LinkNode>();
		while(head != null){
			s.push(head);
			head = head.next;
		}
		LinkNode headc = new LinkNode(-1);
		LinkNode node = headc;
		while(!s.isEmpty()){
			node.next = s.pop();
			node = node.next;
		}
		
		node.next = null; //注意：这里必须标注 node.next = null
		return headc.next;	
	}
	
	/**
	 * 头插法，翻转单链表，空间复杂度为O(n)
	 * @param head
	 * @return
	 */
	public static LinkNode createReverseList(LinkNode head){
		if(head == null || head.next == null)
			return head;
		LinkNode p = head.next;  // 遍历指针
		LinkNode q = new LinkNode(head.val); // 翻转后单链表的头结点
		while(p != null){
			LinkNode tmp = new LinkNode(p.val); // 新建结点
			tmp.next = q; //在链表头插入结点
			q = tmp;  //更新头结点
			p = p.next;
		}
		return q;
	}
	
	/**
	 * 就地翻转  双向链表
	 * @param head
	 * @return
	 */
	public static DoubleLinkNode reverseDoubleList(DoubleLinkNode head){
		if(head == null || head.next == null)
			return head;
		DoubleLinkNode pre = null;
		DoubleLinkNode p = head;
		DoubleLinkNode next = null;
		while(p != null){
			next = p.next;
			p.next = pre; //这里要设置next
			p.pre = next; //这里是同单链表不同的地方，还要设置pre
			pre = p;
			p = next;
		}
		pre.pre = null;
		
		return pre;
	}
	
	/**
	 * 头插法，建立双向链表
	 * @param head
	 * @return
	 */
	public static DoubleLinkNode reverseDoubleList_Create(DoubleLinkNode head){
		if(head == null || head.next == null)
			return head;
		DoubleLinkNode newHead = new DoubleLinkNode(head.val); //建立新链表的第一个结点
		DoubleLinkNode p = head.next; //遍历链表的指针
		while(p != null){
			DoubleLinkNode tmp = new DoubleLinkNode(p.val); //建立新结点
			tmp.next = newHead; 
			newHead.pre = tmp;
			newHead = tmp;  //更新第一个结点
			p = p.next;
		}
	    return newHead;
	}
}
