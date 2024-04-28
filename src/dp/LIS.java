package dp;

public class LIS {
	static int max_res = Integer.MIN_VALUE;
	public static void main(String[] args){
		int[] a={3,10,2,1,20};
		lis(a,a.length);
    System.out.println(max_res);
	}

	private static int lis(int[] a, int length) {
		if(length <= 0){
			return 0;
		}
		int res = 1;
		int max_end = 1;
		for(int i=1;i<length;i++){
			res = lis(a,i);
			if (1+res > max_end && a[i-1] < a[length-1]){
				max_end = res+1;
			}
		}
		if (max_res < max_end){
			max_res = max_end;
		}
		return max_end;
	}
}
