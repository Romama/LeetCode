package basics;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numRows = 10;
		System.out.println(generate(numRows));
	}
	
	//生成杨辉三角的前n行
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>(); //定义list
        if(numRows <= 0) return list;
        List<Integer> row = new ArrayList<Integer>(); //第一行
        row.add(1);
        list.add(row);
        for(int i = 2; i <= numRows; i++){
            List<Integer> l = new ArrayList<Integer>(); //存储第i行数据
            l.add(1);
            row = new ArrayList<Integer>(list.get(list.size() - 1)) ; //获得上一行数据
            for(int j = 0; j < row.size() - 1; j++){
                int e = row.get(j) + row.get(j + 1);
                l.add(e);
            }
            
            l.add(1);
            
            list.add(l);
        }
        return list;
	 }

}
