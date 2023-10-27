import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayDeque <T>{
    private int first;
    private int last;
    private int size;
    private int maxSize;
    private T[] array;

    public void addFirst(T item){
        if(this.size>=0.75*this.maxSize)
            resize(2*this.size);
        if(this.size==0){
            this.array[0]=item;
            this.first=this.last=0;
        }else{
             this.first=(this.first-1+this.maxSize)%this.maxSize;
             this.array[this.first]=item;
        }
        this.size++;
    }
    public void addLast(T item){
        if(this.size>=0.75*this.maxSize)
            resize(2*this.size);
        if(this.size==0){
            this.array[0]=item;
            this.first=this.last=0;
        }else {
            this.last=(this.last+1)%this.maxSize;
            this.array[this.last]=item;
        }
        this.size++;
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
            int i=this.first;
            while(i!=this.last){
                System.out.print(this.array[i]+" ");
                i=(i+1)%this.maxSize;
            }
            System.out.print(this.array[i]);
        }
    }
    public T removeFirst(){
        if (this.size==0) return null;
        T result=this.array[this.first];
        if(this.maxSize>=16&&this.size<(0.25*this.maxSize))
            resize(2*this.size);
        this.first=(this.first+1)%this.maxSize;
        this.size--;
        return result;
    }
    public T removeLast(){
        if (this.size==0) return null;
        T result=this.array[this.last];
        if(this.maxSize>=16&&this.size<(0.25*this.maxSize))
            resize(2*this.size);
        this.last=(this.last-1+this.maxSize)%this.maxSize;
        this.size--;
        return result;
    }
    public T get(int index){
        if(index<0||index>=this.size) return null;
        return this.array[(this.first+index)%this.maxSize];
    }
    private void resize(int newSize){
        T[] newArray=(T[]) new Object[newSize];
        for(int i=0;i<this.size;i++){
            newArray[i]=get(i);
        }
        this.maxSize=newSize;
        this.first=0;
        this.last=this.size-1;
        this.array=newArray;
    }
    public ArrayDeque(){
        this.array=(T[]) new Object[8];
        this.size=0;
        this.maxSize=8;
        this.first=this.last=0;
    }
}
