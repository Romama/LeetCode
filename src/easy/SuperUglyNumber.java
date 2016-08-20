package easy;

/**
 * 参考ugly number II
 * @author Administrator
 *
 */
public class SuperUglyNumber {

	 public static void main(String[] args){
		int[] primes = {2,3,7,9};
		System.out.println("\n" + nthSuperUglyNumber(15, primes));
		
	 }
	 public static int nthSuperUglyNumber(int n, int[] primes) {
	        int[] arr = new int[n];
	        arr[0] = 1;
	        int len = primes.length;
	        int[] inds = new int[len];
	        int index = 1;
	        while(index < n){
	            int min = min(primes,inds,arr);
	            arr[index] = min;
	            next(primes,inds,arr,index);
	            index++;
	        }
	        for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
	        return arr[index - 1];
	    }
	    
	    public static int min(int[] primes,int[] inds,int[] arr){
	        
	        int min = arr[inds[0]] * primes[0] ; 
	        for(int i = 1;i < primes.length;i++){
	            if(arr[inds[i]] * primes[i] < min)
	               min = arr[inds[i]] * primes[i];
	        }
	        return min;
	    }
	    
	     public static void next(int[] primes,int[] inds,int[] arr,int index){
	        
	        for(int i = 0;i < primes.length; i++){
	            while(primes[i] * arr[inds[i]] <= arr[index]) inds[i]++;
	        }
	    }
}
