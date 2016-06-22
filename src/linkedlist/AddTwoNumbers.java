package linkedlist;



/**
 * 两个非负整数存储在LinkedList中，且逆序存储，求两个数的和（存储在LinkedList中），并返回求和结果
 * 注意：可能会有进位；两个LinkedList长度可能不同，while(l1 != null || l2 != null)
 * @author Administrator
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num1 = {2,7,9,2};
		int[] num2 = {4,3,6,8,9};
		LinkNode head1 = new LinkNode(1);
		LinkNode l1 = head1;
		LinkNode head2 = new LinkNode(2);
		LinkNode l2 = head2;
		for(int i = 0; i < num1.length;i++){
			LinkNode node = new LinkNode(num1[i]);
			l1.next = node;
			l1 = l1.next;
		}
		//逆序
		head1 = ReverseLinkedList.reverse(head1.next);
		
		
		for(int i = 0; i < num2.length;i++){
			LinkNode node = new LinkNode(num2[i]);
			l2.next = node;
			l2 = l2.next;
		}
		
		//逆序
		head2 = ReverseLinkedList.reverse(head2.next);
		
		LinkNode head = addTwoNumbers(head1,head2);
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
			
	}
	
	/**
	 * 存储在LinkedList中的两个数相加
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {
        LinkNode head = new LinkNode(-1);
        LinkNode tail = null;
        int val = 0,add = 0;
        while(l1 != null || l2 != null){
            val = add;
            if(l1 != null){
                val = l1.val + val;
                l1 = l1.next;
            }
              
            if(l2 != null){
                val = l2.val + val;
                l2 = l2.next;
            }
              
            add = val / 10;
            val = val % 10;
          
            //头插法，建立新的链表
            LinkNode node = new LinkNode(val);
            node.next = tail;
            tail = node; //更新头结点
        }
        
        if(add == 1) {//最高位有进位，增加一个新的结点
        	LinkNode tmp = new LinkNode(add);
        	tmp.next = tail;
        	tail = tmp;
        }
        return tail; 
	        
	 }
}
