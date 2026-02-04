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
    
    public void add(E element) {
        int idx = count;
        while(idx != 0 && element.compareTo(heap[(idx-1)/2])>0) {
            heap[idx] = heap[(idx-1)/2];
            idx = (idx-1)/2;
        }
        heap[idx] = element;
        count++;
    }
    
    public E getMax() {
        return heap[0];
    }
    
    public String toString() {
        for(int )
    }
}