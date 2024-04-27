package sorting;


import java.util.Arrays;
import java.util.List;

public class Q1 {
	public static void main(String[] args){
		int[] a = {90, -1, 2, 0, 6, 2, -4, 8,-100,900000,4,0,1};
		quickS(a,0,a.length-1);
		for (int ints : a) {
			System.out.println(ints);
		}
	}

	private static void quickS(int[] a, int l, int r) {
		if(l >= r){
			return;
		}
		int m = (l+r)/2;
		int p = pivot(a,l,r);
		quickS(a,l,p-1);
		quickS(a,p+1,r);
	}

	private static int pivot(int[] a, int l, int r) {
		int p = a[r];
		int l1= l-1;
		int r1 = l;
		for(;r1<= r;r1++){
			if(p > a[r1]){
				l1 = l1+1;
				int temp = a[l1];
				a[l1] = a[r1];
				a[r1] = temp;
			}
		}
		int temp = a[l1+1];
		a[l1+1] =p;
		a[r] = temp;
		return l1+1;
	}
}
