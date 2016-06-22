package basics;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成杨辉三角的第kth行，其中，第0行为 1
 * Given an index k, return the kth row of the Pascal's triangle.
   For example, given k = 3,
   Return [1,3,3,1].
   Note:
   Could you optimize your algorithm to use only O(k) extra space?
   
 * @author admin
 *
 */
public class PascalTriangle2 {

	public static void main(String[] args){
		int rowIndex = 6;
		System.out.println(getRow(rowIndex));
	}
	
	/**
	 * 返回杨辉三角的第k行（第0行为 1）
	 * 若k = 3
	 * 返回 1 3 3 1
	 * 要求空间复杂度不超过O(k)
	 * @param rowIndex
	 * @return
	 */
	public static List<Integer> getRow(int rowIndex){
		List<Integer> row = new ArrayList<Integer>();
		if(rowIndex < 0) return row;
		// 第 rowIndex 行有 rowIndex + 1 个元素，给这 rowIndex + 1个元素赋初值 0
        for(int i = 0; i <= rowIndex; ++i){ 
            row.add(0);
        }
        
        row.set(0, 1);
        
        //生成第rowIndex行数据，最小为第0行
        //由第 j 行逆序生成第j + 1行，初始为 1
        //j == 0 时，生成的是 1 1
        //j == 1 时，生成的是 1 2 1
        //......
        //j == rowIndex - 1，生成最终结果
        for(int j = 0; j < rowIndex; ++j){
            for(int k = rowIndex - 1; k > 0; --k){ //从最后一个元素开始，逆序计算
            	row.set(k, row.get(k) + row.get(k - 1));
            }
        }
        row.set(rowIndex, 1); //给最后一位赋值1
        return row;
	}
}
