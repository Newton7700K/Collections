
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
    private boolean isOverflowed = false;
    
    public MyQueue(int maxSize) {
        queue = new int[maxSize];
    }
    
    public void enqueue(int element) {
        queue[front % (queue.length)] = element;
        if (front == 2 * (queue.length)) {
            front = queue.length;
        }   
        if (front >= queue.length){
            end = front % (queue.length) + 1;
        }
        front++;
        System.out.println("Front: " + front);
        System.out.println("End: " + end);
    }
    
    public int dequeue() {
        if(front-end!=0){
            front--;
        }
        System.out.println("Front: " + front);
        System.out.println("End: " + end);
        return queue[front % (queue.length)];
    }
    
    public boolean isEmpty(){
        if (front % queue.length == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int front(){
        return queue[front % (queue.length-1)];
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
        String str = queue[end % (queue.length)] + "";
        for (int i = end + 1; i < front; i++) {
            str += ", " + queue[i % (queue.length)];
        }
        if (front - end == 0) {
            return "0";
        } else {
            return str;
        }
    }
}