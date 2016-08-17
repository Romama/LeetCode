package medium;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class KthSmallestPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null || k <= 0)
           return null;
        if(nums1.length == 0 || nums2.length == 0)
           return new ArrayList<int[]>();
        if(nums1.length * nums2.length < k)
           return null;
        //the priorityqueue 优先队列
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        //result
        List<int[]> list = new ArrayList<int[]>();
        //首先将nums1同nums2[0]的所有组合入队列
        for(int i = 0; i < nums1.length; ++i)
           queue.add(new Pair(i,0,nums1[i],nums2[0])); 
        //获取k个最小值
        for(int n = 0; n < k; ++n){
            Pair tmp = queue.poll();
            int[] ele = tmp.pair; //数值对
            list.add(ele); //加入结果集
            if(tmp.j == nums2.length - 1)
               continue;
            queue.add(new Pair(tmp.i,tmp.j + 1,nums1[tmp.i],nums2[tmp.j + 1]));
        }
        return list;
    }

}
//定义pair的数据结构
class Pair implements Comparable<Pair>{
    int[] pair = new int[2]; //定义数组对
    int i;
    int j;
    public Pair(int i,int j,int e1,int e2){
        pair[0] = e1;
        pair[1] = e2;
        this.i = i;
        this.j = j;
    }
    
    @Override
    public int compareTo(Pair that){ //升序排列
        return (pair[0] + pair[1]) - (that.pair[0] + that.pair[1]);
    }
}
