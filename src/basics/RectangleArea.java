package basics;

/**
 * 求两个矩形覆盖的总面积
 * 方法：
 * 两个矩形面积总和  - 交叉部分的面积
 * @author admin
 *
 */
public class RectangleArea {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = -1500000001,B = 0,C = -1500000000,D = 1,E = 1500000000, F = 0,G = 1500000001,H = 1;
		System.out.println(computeArea(A, B, C, D, E, F, G, H));
	}
	
	/**
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @param E
	 * @param F
	 * @param G
	 * @param H
	 * @return
	 * (A,B),(C,D),(E,F),(G,H)
	 * 
	 */
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int res = (D - B) * (C - A) + (H - F) * (G - E);
    	int x1 = Math.max(A, E), x2 = Math.min(C, G),y1 = Math.max(B, F),  y2 = Math.min(D, H);
    	if (x2 <= x1 || y2 <= y1) return res;
    	return res - (x2 - x1) * (y2 - y1);
    }
}
