package tree;

public class HeightOfTreeFromArray {
    public static void main(String[] args) {
        System.out.println(height("nnnnlnll", 0));
    }

    private static int height(String str,int index){
        if(index >= str.length()){
            return 0;
        }

        if(str.charAt(index) == 'l'){
            return 1;
        }
        int lh = 1+height(str, index+1);
        int rh = 1+height(str, index+1);

        return lh > rh ? lh :rh;
        
    }
}
