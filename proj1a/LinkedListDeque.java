import org.junit.Test;

public class LinkedListDeque <T>{
    private ListNode first;
    private ListNode last;
    private int size;
    class ListNode{
        private T item;
        private ListNode next;
        private ListNode front;
        public ListNode(T item){
            this.item=item;
            this.next=null;
            this.front=null;
        }
    }
    public void addFirst(T item){
        if(item!=null){
            ListNode node=new ListNode(item);
            if(this.size==0){
                this.first=node;
                this.last=this.first;
            }else {
                node.next=this.first;
                this.first.front=node;
                this.first=node;
            }
            this.size++;
        }
    }

    public void addLast(T item){
        if(item!=null){
            ListNode node=new ListNode(item);
            if(this.size==0){
                this.last=node;
                this.first=this.last;
            }else{
                this.last.next=node;
                node.front=this.last;
                this.last=node;
            }
            this.size++;
        }
    }
    public boolean isEmpty(){
        if(this.size==0)
            return true;
        return false;
    }
    public int size(){
        return this.size;
    }
    public void printDeque(){
        if(this.size!=0){
            ListNode index=this.first;
            while (index!=this.last){
                System.out.print(index.item+" ");
                index=index.next;
            }
            System.out.print(index.item);
        }
    }
    public T removeFirst(){
        if(this.size==0)
            return null;
        else {
            ListNode result=this.first;
            if(this.size==1){
                this.first=null;
                this.last=null;
            }else {
                this.first=this.first.next;
                this.first.front=null;
            }

            this.size--;
            return result.item;
        }
    }
    public T removeLast(){
        if(this.size==0)
            return null;
        else {
            ListNode result=this.last;
            if(this.size==1){
                this.first=null;
                this.last=null;
            }else {
                this.last=this.last.front;
                this.last.next=null;
            }
            this.size--;
            return result.item;
        }
    }
    public T get(int index){
        if(index<0||index>=this.size) return null;
        int i=0;
        ListNode ind=this.first;
        while(ind!=null){
            if(i==index)
                return ind.item;
            i++;
            ind=ind.next;
        }
        return null;
    }
    public LinkedListDeque(){
        this.first=null;
        this.last=null;
        this.size=0;
    }
    public T getRecursive(int index){
        if(index<0||index>=this.size) return null;
        return  recurisive(index).item;
    }
    public ListNode recurisive(int index){
        if(index==0) return this.first;
        return recurisive(index-1).next;
    }
}
