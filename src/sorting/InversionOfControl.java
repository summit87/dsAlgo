package sorting;

public class InversionOfControl {
    public static void main(String[] args) {
        int[] a = {1, 20, 6, 4, 5};
        System.out.println(inversionOfControl(a,0,a.length-1));
    }

    public static int inversionOfControll(int[] a){
        int count = 0;
        for(int i =0;i<a.length-1;i++){
            for (int j = i+1;j<a.length;j++){
                if(a[i] > a[j]){
                    count++;
                }
            }
        }

        return count;
    }

    public static  int inversionOfControl(int[] a,int l,int r){
        int count=0;
        if(l >=  r){
            return count;
        }

        int mid = l+(r-l)/2;
        count+=inversionOfControl(a, l, mid);
        count+=inversionOfControl(a, mid+1, r);
        count+=mergeValue(a,l,mid,r);
        return count;
    }

    public static int mergeValue(int[] a,int l,int m,int r){
        int count = 0;
        int n1 = m-l+1;
        int n2 = r-m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i=0;i<n1;i++){
            left[i] = a[l+i];
        }
        for(int i=0;i<n2;i++){
            right[i] = a[m+i+1];
        }

        int k=l;
        int i1=0;
        int i2=0;
        while(i1 < n1 && i2 < n2){
            if(left[i1] < right[i2]){
                a[k] = left[i1];
                i1++;
            }
            else{
                a[k] = right[i2];
                i2++;
                /**
                 * How : https://www.youtube.com/watch?v=AseUmwVNaoY
                 */
                count+=(m+1)-(l+i1);
            }
            k++;
        }


        

        while(i1 < n1){
            a[k] = left[i1];
            k++;
            i1++;
        }
        while(i2 < n2){
            a[k] = right[i2];
            k++;
            i2++;
        }
        return count;
    }
}
