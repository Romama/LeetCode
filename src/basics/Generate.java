package basics;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出杨辉三角中的第n行
 * @author admin
 *
 */
public class Generate {
	public static void main(String[] args){
		int numRows = 5;
		int[] arr = {1,5,2,2,8};
		System.out.println(generate(numRows)); //list中的值可以直接输出
		System.out.println(arr);  //数组的内容不可以直接输出
	}

	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>(); //定义list
        if(numRows <= 0) return list;
        List<Integer> row = new ArrayList<Integer>(); //第一行
        row.add(1);
        list.add(row);
        for(int i = 1; i < numRows; i++){
            List<Integer> l = new ArrayList<Integer>(); //存储第i行数据
            l.add(1);
            row = list.get(i - 1) ; //获得上一行数据
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
