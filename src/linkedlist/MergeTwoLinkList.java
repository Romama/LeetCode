package linkedlist;


/**
 * 将两个非递减有序的LinkedList进行合并，并返回合并后的LinkedList
 * @author admin
 *
 */
public class MergeTwoLinkList {

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
		
		LinkNode headc = merge(heada.next, headb.next);
		while(headc != null){
			System.out.print(headc.val);
			headc = headc.next;
		}
			
	}
	/**
	 * 将l1与l2进行合并
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static LinkNode merge(LinkNode l1,LinkNode l2){
		if(l1 == null && l2 == null) return null;
		else if(l1 == null) return l2;
		else if(l2 == null) return l1;
		LinkNode l3 = new LinkNode(-1);
		LinkNode p = l3;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val ){
				p.next = l1;
				p = p.next;
				l1 = l1.next;
			} else {
				p.next = l2;
				p = p.next;
				l2 = l2.next;
			}
		}
		
		if(l1 != null)
			p = l1;
		if(l2 != null) 
			p = l2;
		return l3.next;

	}
}
