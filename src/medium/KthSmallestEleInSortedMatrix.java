package medium;

//优先级队列，是从jdk1.5开始提供的新的数据结构接口
//如果不提供Comparator的话，优先队列中元素默认按自然顺序排列
//每次从队列中取出的是具有最高优先权的元素。
import java.util.PriorityQueue;

/**
 * 已知一个n*m的矩阵，每一行、每一列都是有序的。
 * 求这个矩阵中第k小的元素
 * @author i333083
 *
 */
public class KthSmallestEleInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a = new int[][]{{1,5,9,11},{2,6,10,14},{3,7,13,15}};
		System.out.println(kthSmallest(a,11));
	}
	
	//求矩阵中第k小的元素
	public static int kthSmallest(int[][] matrix,int k){
		int rows = matrix.length; //矩阵的行数
		int cols = matrix[0].length;//列数
		
		//优先队列
		PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>(); //入队列
		
		/**
		 * 这里有一个设计非常巧妙的地方，将第一行升序的序列先入队列，根据Tuple类型的定义，最小的元素将会在队首。
		 * 每当队首元素出队列后，都将其所在列的下一个元素入队列，直到最后一行；
		 * 这样，就可以比较一个元素的同一行与同一列中相邻的元素中哪个较小，从而保证队首元素始终是矩阵中所有元素的最小值
		 */
		for(int j = 0; j < cols; ++j)
			queue.add(new Tuple(0,j,matrix[0][j]));
		//进行k-1次出队、入队，最后队首元素一定是所有元素中的第k小
		for(int i = 0; i < k - 1; ++i){
			Tuple p = queue.poll(); //出队列
			System.out.print(p.val + " ");
			if(p.x == rows - 1) //若是最后，则没有元素需要入队列了
				continue;
			queue.add(new Tuple(p.x + 1,p.y,matrix[p.x + 1][p.y]));
		}
		
		return queue.poll().val;
	}
}

//实现Comparable接口要覆盖compareTo方法, 在compareTo方法里面实现比较
//自定义一个数据结构-元组，继承自comparable接口
class Tuple implements Comparable<Tuple>{
	int x;
	int y;
	int val;
	public Tuple(int x,int y,int val){
		this.x = x;
		this.y = y;
		this.val = val;
	}
	
	@Override
	public int compareTo(Tuple t){
		return this.val - t.val; //若新加入的元素较小，则排在队首
	}
}
