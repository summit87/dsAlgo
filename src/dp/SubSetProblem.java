package dp;

/**
 * In given array find is sum is exist or not
 */
public class SubSetProblem {
	public static void main(String[] args){
		int[] a =  {1,2,3};
		int sum = 4;
   // System.out.println(sumSubSet(a,sum,a.length));
   sumSubsetDP(a,sum);
    System.out.println();
	}

	private static boolean sumSubSet(int[] a, int sum, int length) {

		if (length <= 0 || sum < 0){
			return false;
		}
		if (sum == 0){
			return true;
		}
		return sumSubSet(a,sum-a[length-1],length-1) || sumSubSet(a,sum,length-1);
	}

	private static boolean sumSubsetDP(int[] a,int sum){
		boolean[][] b = new boolean[a.length+1][sum+1];
		b[0][0] = true;
		for(int i=1;i<=a.length;i++){
			for (int j = 0;j<=sum;j++){
				if(j - a[i-1] == 0){
					b[i][j] = true;
				}else if(j < a[i-1]){
					b[i][j] = b[i-1][j];
				}
				else if (j - a[i-1] >= 0){
					b[i][j] = b[i-1][j-a[i-1]]||b[i-1][j];
				}
			}
		}
		for(int i=0;i<=a.length;i++){
			for(int j=0;j<=sum;j++){
				System.out.print(b[i][j]+",");
			}
			System.out.println();
		}
		return b[a.length][sum];
	}
}
