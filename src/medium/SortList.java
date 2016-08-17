package medium;

public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode node = new ListNode(7);
		ListNode p = node;
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(1);
		sortList(node);
		while(node != null){
			System.out.print(node.val);
			node = node.next;
		}
	}
	
	public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        //找到链表的中间节点，一快一慢两个指针
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null; //记录第一部分的最后一个节点
        //将单链表划分为两部分
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        
        //将两部分分割开
        if(pre != null)
           pre.next = null;
        
        //分别对两部分递归排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1,l2); //归并
        
    }
    
    //归并两个有序序列
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null)
           return l2;
        if(l2 == null)
           return l1;
        ListNode l = new ListNode(-1);
        ListNode newHead = l;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                newHead.next = l1;
                l1 = l1.next;
                newHead = newHead.next;
            } else {
                newHead.next = l2;
                l2 = l2.next;
                newHead = newHead.next;
            }
        }
        
        if(l1 != null)
           newHead.next = l1;
        if(l2 != null)
           newHead.next = l2;
        return l.next;
    }
}
class ListNode{
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
