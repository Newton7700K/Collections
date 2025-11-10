
public class Applications
{
    public static <E> void reverse(MyQueue<E> queue){
        MyStack<E> temp = new MyStack<E>(queue.size());
        while(!queue.isEmpty()){
            temp.push(queue.dequeue());
        }
        while(!temp.isEmpty()){
            queue.enqueue(temp.pop());
        }
    }
    
    public static boolean checkSyntax(String code){
        
    }
    
    public static double evalPostfix(String expression){
        
    }
}