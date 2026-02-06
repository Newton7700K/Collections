/**
 * Write a description of class MyHeap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHeap<E extends Comparable<E>>
{
    // instance variables - replace the example below with your own
    private int count = 0;
    private E[] heap;
    
    /**
     * Constructor for objects of class MyHeap
     */
    public MyHeap(int maxSize) {
        heap = (E[]) new Comparable[maxSize];
    }
    
    /**
     * Constructor for objects of class MyHeap
     */
    public void add(E element) {
        int idx = count;
        while(idx != 0 && element.compareTo(heap[(idx-1)/2])>0) {
            heap[idx] = heap[(idx-1)/2];
            idx = (idx-1)/2;
        }
        heap[idx] = element;
        count++;
    }
    
    /**
     * Constructor for objects of class MyHeap
     */
    public E getMax() {
        return heap[0];
    }
    
    
    
    public E removeMax() {
        int idx = 0;
        int max = heap[0];
        heap[idx] = heap[count-1];
        count--;
        while (idx*2+1<count && heap[idx*2+1]!=0) {
            if (heap[idx] > heap[idx*2+1] && heap[idx] > heap[idx*2+2]){
                
            } else if (heap[idx*2+1] > heap[idx*2+2]) {
                heap[idx] = heap[idx*2+1];
                idx = 
            }
        }
        return 
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