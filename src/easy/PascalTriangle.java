package easy;

import java.util.List;
import java.util.ArrayList;

/**
 * 1 给定整数n，返回杨辉三角的n行，第一行为[1]
 * 2 给定rowIndex，返回杨辉三角的第rowIndex + 1行，当rowIndex为0时，为[1]
 * @author i333083
 */
public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rowIndex = 5;
		System.out.println(getRow(rowIndex));
		
		System.out.println(generate(rowIndex));
		
	}
	
	/**
	 * 得到杨辉三角的第k行，空间复杂度O(k)
	 * @param rowIndex
	 * @return
	 */
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if(rowIndex < 0)
           return result;
        result.add(1);
        int ele;
        for(int i = 1; i <= rowIndex; ++i){
            //就地修改元素值，使得空间复杂度为O(k)
            for(int j = 0, len = result.size() - 1; j < len; ++j){
                ele = result.get(j) + result.get(j + 1);
                result.set(j,ele);
            }
            result.add(0,1);
        }
        return result;
    }
	
	/**
	 * 生成杨辉三角的前n行
	 * @param numRows
	 * @return
	 */
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>(); //定义list
        if(numRows <= 0) return list;
        List<Integer> pre = new ArrayList<Integer>(); //前一行数据
        pre.add(1);
        list.add(pre);
        List<Integer> cur = new ArrayList<Integer>(); //当前行数据
        int tmp;
        for(int i = 1; i < numRows; ++i){
            pre = list.get(i - 1);
            cur = new ArrayList<Integer>();
            cur.add(1); //每行的第一个为1
            for(int j = 0,len = pre.size() - 1; j < len; ++j){
                tmp = pre.get(j) + pre.get(j + 1);
                cur.add(tmp);
            }
            
            cur.add(1); //每行的最后一个为1
            
            list.add(cur);
        }
        
        return list;
    }
	
	

}
