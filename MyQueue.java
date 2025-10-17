
/**
 * Write a description of class MyQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyQueue
{
    private int[] queue;
    private int front = 0;
    private int end = 0;
    
    public MyQueue(int maxSize) {
        queue = new int[maxSize];
    }
    
    public void enqueue(int element) {
        if (front == 2 * (queue.length-1)) {
            front = queue.length;
        }   
        if (front >= queue.length - 1){
            end = front % queue.length + 1;
        } else {
            end = 0;
        }
        queue[front % queue.length] = element;
        front++;
    }
    
    public int dequeue() {  
        if (front >= queue.length){
            end = front % queue.length + 1;
        } else {
            end = 0;
        }
        front--;
        return queue[front % queue.length];
    }
    
    public boolean isEmpty(){
        if (front % queue.length == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int front(){
        return queue[front % queue.length];
    }
    
    public int size(){
        return front;
    }
    
    public boolean isFull(){
        if(front / 2 == queue.length){
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        String str = queue[end] + "";
        for (int i = end + 1; i < front-end-1; i++) {
            str += ", " + queue[i % queue.length];
        }
        return str;
    }
}