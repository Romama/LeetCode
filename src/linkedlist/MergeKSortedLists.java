package linkedlist;

import java.util.List;


/**
 * 将k个sorted list合并为一个 sortd list
 * @author admin
 * 包含merge two sorted list
 */
public class MergeKSortedLists {

	public static void main(String[] args){
		 Object[] a = {1,2,10,15};
		 Object[] b = {3,8,12,17};
		 Object[] c = {4,5,9,11,16};
	     LinkNode root1 = CreateLinkedList.createLinkedList(a);
	     LinkNode root2 = CreateLinkedList.createLinkedList(b);
	     LinkNode root3 = CreateLinkedList.createLinkedList(c);
	     LinkNode[] list = {root1,root2,root3};
	     LinkNode newRoot = mergeKSortedList(list);
	     while(newRoot != null){
	    	 System.out.print(newRoot.val + " ");
	    	 newRoot = newRoot.next;
		}
	}
	
	/**
	 * 方法一、LinkNode数组
	 * 时间复杂度O(nlogk)
	 * @param list
	 * @return
	 */
	public static LinkNode mergeKSortedList(LinkNode[] list){
		if(list == null || list.length == 0)
			return null;
		int len = list.length; 
		if(len == 1)
			return list[0];
		int mid = (len - 1)/ 2; //二分的时候，注意 mid = (len - 1) / 2,而不是 len/2，因为后者平分不均匀，前一种划分更为合理
		LinkNode[] list1 = new LinkNode[mid + 1] ;
		LinkNode[] list2 = new LinkNode[len - mid - 1] ;
		for(int i = 0 ;i < list1.length ; i++)
			list1[i] = list[i];
		for(int j = list1.length ;j < len;j++)
			list2[j - list1.length] = list[j];
		LinkNode l1 = mergeKSortedList(list1);
		LinkNode l2 = mergeKSortedList(list2);
		
		return mergeTwoSortedList(l1,l2);
	}
	
	
	/**
	 * 方法二、List<LinkNode> 存储k个sorted list的头结点
	 * @param lists
	 * @return
	 */
	public static LinkNode mergeKSortedList_1(List<LinkNode> lists){
		if(lists == null || lists.size() == 0)
			return null;
		if(lists.size() == 1)
			return lists.get(0);
		int len = lists.size();
		
		int mid = (len - 1) / 2;
		List<LinkNode> list1 = lists.subList(0, mid + 1);
		List<LinkNode> list2 = lists.subList(mid + 1, len);
		LinkNode l1 = mergeKSortedList_1(list1);
		LinkNode l2 = mergeKSortedList_1(list2);
		
		return mergeTwoSortedList(l1, l2);
	}
	
	//两个链表链接
	public static LinkNode mergeTwoSortedList(LinkNode l1,LinkNode l2){
		
		LinkNode head = new LinkNode(0); //创建一个头结点，最后还要删掉
		LinkNode p = head;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				p.next = l1;
				l1 = l1.next;
			} else{
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		
		p.next = (l1 != null) ? l1 : l2;
		return head.next;// head的下一个节点是第一个数据结点
	}
	
	/**
	 * 方法三、使用堆，heap技术
	 * @param lists
	 * @return
	 */
	/*public static LinkNode mergeKSortedListBasedHeap(LinkNode[] lists){
		
	}*/
}
