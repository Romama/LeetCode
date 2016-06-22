package linkedlist;


/**
 * 快慢指针
 * 设定两个指针，每次向前移动的步数不同
 * 用途：
 * 1 判断单链表是否为循环链表
 * 2 寻找单链表的中间结点
 * @author admin
 *
 */
public class SlowAndFastPointer {

	public static void main(String[] args){
		
		//创建了两个单链表
		int[] a = {2,3,5,7,10,8,56};
		int[] b = {1,4,6,8,12,3,12};
		LinkNode heada = new LinkNode(-1);
		LinkNode headb = new LinkNode(-1);
		LinkNode l1 = heada;
		LinkNode l2 = headb;
		for(int i = 0; i < a.length; i++){
			l1.next = new LinkNode(a[i]);
			l1 = l1.next;
		}
		
		//构造循环单链表 headb
		for(int i = 0; i < b.length; i++){
			if(i == b.length - 1){
				l2.next = new LinkNode(b[i]);
				l2 = l2.next;	
				l2.next = headb.next; //设置循环
			}    
			else {
				l2.next = new LinkNode(b[i]);
				l2 = l2.next;	
			}
		}

		//查找单链表heada的中间结点
		LinkNode mid = findMid(heada.next);
		if(mid != null)
		    System.out.println(mid.val);
		
		//判断headb是否为循环单链表
		System.out.println(isCycle(heada.next));
	}
	
	/**
	 * 判断一个单链表是否是一个循环链表
	 * 让快、慢指针从链表头开始遍历，快指针向前移动两个位置，慢指针向前移动一个位置;
	 * 如果快指针到达NULL，说明链表以NULL为结尾，不是循环链表。
	 * 如果 快指针追上慢指针，则表示出现了循环。
	 * @param list
	 * @return
	 */
	public static boolean isCycle(LinkNode list){
		if(list == null || list.next == null) return false;
		LinkNode slow = list.next;
		LinkNode fast = list.next.next;

		while(true){
			if(fast == null || fast.next == null)
				return false;
			else if(fast == slow || fast.next == slow)
				return true;
			else {
				
				slow = slow.next;
				fast = fast.next.next;
			}
		}
	}
	
	/**
	 * 查找一个单链表的中间结点 ：middle node
	 * @param list
	 * @return
	 */
	public static LinkNode findMid(LinkNode list){
		if(list == null) return null;
		LinkNode slow = list;
		LinkNode fast = list;
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
