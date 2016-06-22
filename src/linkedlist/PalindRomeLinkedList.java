package linkedlist;


/**
 * 给定一个单链表，判读它是不是满足回文串
 * @author admin
 *
 */
public class PalindRomeLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//构造两个单链表
		int[] a = {1,2,3,5,5,3,2,1,10};
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
		
		System.out.println(isPalindRome(heada.next));
		
	}
	
	/**
	 * O(n) time complexity and O(1) space complexity
	 * 首先利用快、慢指针找到链表的中间结点 mid
	 * 然后将后半部分就地翻转，与前半部分比较
	 * @param l1
	 */
	public static boolean isPalindRome(LinkNode head){
		if(head == null || head.next == null) return false;
		LinkNode p = head;
		
		//利用快慢指针查找单链表的中间结点
		LinkNode mid = findMid(p);
		
		//将指针调整到后半部分的起点
		mid = mid.next; 
		
		//对后半部分链表进行就地翻转
		LinkNode pre = null;
		LinkNode cur = mid;
		LinkNode next;
		while(cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		//pre为翻转完成的后半部分的第一个结点
		while(pre != null){
			if(head.val != pre.val)
				return false;
			head = head.next;
			pre = pre.next;
		}
		return true;
	}
	
	//查找中间结点
	public static LinkNode findMid(LinkNode h){
		if(h == null) return null;
		LinkNode slow = h;
		LinkNode fast = h;
		while(true){
			if(fast.next == null || fast.next.next == null)
				return slow;
			else {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
	}

}
