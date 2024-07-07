package list;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreateList {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("list1.txt"));
        MList<Integer> mlist = new MList<Integer>();
        MList<Integer> mlist1 = null;
        while (scanner.hasNext()) {
            Integer v = scanner.nextInt();
            mlist1 = mlist.createList(v, mlist1);
        }
        mlist1.print(mlist1);
    }

    

}
