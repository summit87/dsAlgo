package list;

public class MList<T> {
    private T data;
    private MList<T> next;

    public MList(){

    }

    public MList(T data){
        this.data = data;
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    public void setNext(MList<T> next){
        this.next = next;
    }

    public MList<T> getNext(){
        return next;
    }

    public MList<Integer> createList(Integer t, MList<Integer> list) {
        MList<Integer> newNode = new MList<Integer>(t);
        if (list == null) {
            list = newNode;
            return list;
        }
        list.setNext(createList(t, list.getNext()));
        return list;
    }

    public void print(MList<Integer> list) {
        if (list == null) {
            return;
        }
        System.out.print(list.getData() + ",");
        print(list.getNext());
    }


   
}
