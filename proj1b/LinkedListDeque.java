public class LinkedListDeque<Item> implements Deque<Item>{
    private ListNode first;
    private ListNode last;
    private int size;
    private class ListNode{
        private Item item;
        private ListNode next;
        private ListNode front;
        private ListNode(Item item){
            this.item=item;
            this.next=null;
            this.front=null;
        }
    }
    @Override
    public void addFirst(Item item){
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

    @Override
    public void addLast(Item item){
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
    @Override
    public boolean isEmpty(){
        if(this.size==0)
            return true;
        return false;
    }
    @Override
    public int size(){
        return this.size;
    }
    @Override
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
    @Override
    public Item removeFirst(){
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
    @Override
    public Item removeLast(){
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
    @Override
    public Item get(int index){
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
    public Item getRecursive(int index){
        if(index<0||index>=this.size) return null;
        return  recurisive(index).item;
    }
    private ListNode recurisive(int index){
        if(index==0) return this.first;
        return recurisive(index-1).next;
    }
}
