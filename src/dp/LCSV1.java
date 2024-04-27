package dp;

public class LCSV1 {
	public static void main(String[] args){
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
    //System.out.println(lcsv1(str1,str2,0,0));
		System.out.println(lcs2(str1,str2));
	}

	private static int lcsv1(String str1, String str2, int l1, int l2) {
		if(l1 >= str1.length() || l2 >= str2.length()){
			return 0;
		}
		if (str1.charAt(l1) == str2.charAt(l2)){
			return 1+lcsv1(str1,str2,l1+1,l2+1);
		}
		return Math.max(lcsv1(str1,str2,l1+1,l2),lcsv1(str1,str2,l1,l2+1));
	}

	private static int lcs2(String str1,String str2){
		int[][] table = new int[str1.length()+1][str2.length()+1];
		for(int l1=1;l1<=str1.length();l1++){
			for (int l2=1;l2<=str2.length();l2++){
				if (l1 > str1.length() || l2 > str2.length()){
					table[l1][l2]  = 0;
				}else{
					if(str1.charAt(l1-1) == str2.charAt(l2-1)){
						table[l1][l2] = 1+table[l1-1][l2-1];
					}else{
						table[l1][l2] = Math.max(table[l1-1][l2],table[l1][l2-1]);
					}
				}
			}
		}
		for(int i=0;i<=str1.length();i++){
			for(int j=0;j<=str2.length();j++){
        System.out.print(table[i][j]+" ");
			}
      System.out.println();
		}
    System.out.println(table[str1.length()-1][str2.length()-1]);
		return table[str1.length()][str2.length()];
	}
}
