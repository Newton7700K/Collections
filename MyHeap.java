import java.util.*;
import java.util.Arrays;

/**
 * Write a description of class MyHeap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHeap<E extends Comparable<E>>
{
    // instance variables - replace the example below with your own
    private int count;
    private int isMinHeap; // if positive, is max heap; if negative, is min heap
    private E[] heap;
    
    /**
     * Constructor for objects of class MyHeap
     */
    public MyHeap(boolean isMinHeap) {
        count = 0;
        heap = (E[]) new Comparable[1];
        this.isMinHeap = 1;
        if(isMinHeap){
            this.isMinHeap = -1;
        }
    }
    
    /**
     * Constructor for objects of class MyHeap
     */
    public void add(E element) {
        int child = count;
        int parent = (child - 1) / 2;
        
        while(child != 0 && isMinHeap * element.compareTo(heap[parent])>0) {
            heap[child] = heap[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        
        heap[child] = element;
        heap = Arrays.copyOf(heap, heap.length * 2);
        count++;
    }
    
    /**
     * Constructor for objects of class MyHeap
     */
    public E getTop() {
        return heap[0];
    }
    
    public E removeTop() {
        if(isEmpty()){
            throw new NoSuchElementException();
        } else {
            E top = heap[0];
            int idx = 0;
            heap[idx] = heap[count-1];
            
            while (idx*2+1<count) {
                int left = idx*2+1;
                int right = idx*2+2;
                
                if (heap[idx].compareTo(heap[idx*2+1]) == isMinHeap 
                        && heap[idx].compareTo(heap[idx*2+2]) == isMinHeap){
                    
                } else if (heap[idx*2+1].compareTo(heap[idx*2+2]) == isMinHeap) {
                    E temp = heap[idx];
                    heap[idx] = heap[left];
                    heap[left] = temp;
                    idx = left;
                } else {
                    E temp = heap[idx];
                    heap[idx] = heap[right];
                    heap[right] = temp;
                    idx = right;
                }
            }
            count--;
            return top;
        }
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**
     * Constructor for objects of class MyHeap
     */
    public String toString() {
        String str = heap[0] + "";
        for(int i = 1; i<heap.length; i++){
            str += ", " + heap[i];
        }
        return str;
    }
}