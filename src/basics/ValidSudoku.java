package basics;

import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个矩阵，判断该矩阵是否满足数独
 * 数独矩阵必须是9行9列的矩阵
 * @author admin
 *
 */
public class ValidSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = {
				{'.','.','.','.','5','.','.','1','.'},
				
				{'.','4','.','3','.','.','.','.','.'},
				
				{'.','.','.','.','.','3','.','.','1'},
				
				{'8','.','.','.','.','.','.','2','.'},
				
				{'.','.','2','.','7','.','.','.','.'},
				
				{'.','1','5','.','.','.','.','.','.'},
				
				{'.','.','.','.','.','2','.','.','.'},
				
				{'.','2','.','9','.','.','.','.','.'},
				
				{'.','.','4','.','.','.','.','.','.'}
	    };
		
		System.out.println(isValidSudoku(board));
	}
	
    public static boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0)
        	return false;
        int row = board.length; //矩阵的行数
        int col = board[0].length; //矩阵的列数
        if(row != 9 || col != 9)
        	return false;
        boolean result = true;
   
        for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				if(i % 3 == 0 && j % 3 == 0)
					result = result && isValidOfBoard(board,i,j);
			}
		}
     
        return isValid(board,row) && result;
    }
    
    /**
     * 判断给定的数组是否符合包含重复元素
     * @param arr
     * @return
     */
    public static boolean isValid(char[] arr){
    	Map<Character, Character> map = new HashMap<Character, Character>();
    	for(int i = 0; i < arr.length; i++){
    		if(arr[i] != '.'){
    			if (map.containsKey(arr[i])) {
    				return false;
    			} else {
    				map.put(arr[i], arr[i]);
    			}
    		}
    	}
    	return true;
    }
    
    /**
     * 判断每一行和每一列是否满足条件
     * @param arr
     * @return
     */
    public static boolean isValid(char[][] board,int row){
    	char[] column = new char[row];
    	boolean res = true;
    	 //判断每一行和每一列是否满足条件
        for(int i = 0; i < row; i++){
        	res = res && isValid(board[i]);
        }
        for (int i = 0; i < row; i++) {
        	//获得第i列
        	for (int j = 0; j < row; j++) {
				column[j] = board[j][i];
			}
        	//判断第i列是否满足条件
        	res = res && isValid(column);
        }
        
        return res;
    }
    
    /**
     * 判断小九宫格内元素是否满足条件，小九宫格内只能含有1到9，不能重复
     * @param board
     * @param row
     * @param col
     * @return
     */
    public static boolean isValidOfBoard(char[][] board, int row,int col){
 
    	Map<Character, Character> map = new HashMap<Character, Character>();
    	for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if(board[i][j] != '.'){
					if(map.containsKey(board[i][j])){
						return false;
					} else {
						map.put(board[i][j], board[i][j]);
					}		
				}	
			}
		}
    	
    	return true;
    	
    }
}
