package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 将单链表中重复的字符删除，只留下仅出现一次的字符
 * @author admin
 *
 */
public class RemoveDuplicatesFromSortedList2 {

	public static void main(String[] args){
		Object[] values = {1,2,2};
		LinkNode head = CreateLinkedList.createLinkedList(values);
		LinkNode newHead = removeDuplicates2(head);
		while(newHead != null){
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		} 
	}
	
	public static LinkNode removeDuplicates2(LinkNode head){
		if(head == null)
			return null;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();//统计出现的次数
		LinkNode p = head; //将head复制给p，从而利用p统计次数
		//遍历单链表，统计出现的次数
		while(p != null){
			int val = p.val;
			if(map.containsKey(val)){
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
			
			p = p.next;
		}
		
		//删除重复结点
		LinkNode newHead = new LinkNode(-1); //带头结点的新链表
		LinkNode pre = newHead; //初始化pre为头结点
		newHead.next = head; //初始化当前结点为head
		
		//删除重复元素
		while(head != null){
			int val = head.val;
			LinkNode next = head.next;
			if (map.get(val) > 1) { //删除元素
				pre.next = next;
			} else{
				pre = head; //这个必须要
			}
			head = head.next;
		}
	
		return newHead.next;
	}
}
