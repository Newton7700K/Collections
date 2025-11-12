
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
        MyStack<String> stack = new MyStack<String>(code.length());
        for(int i = 0; i<code.length(); i++){
            if ("<{(".indexOf(code.substring(i,i+1)) != -1) {
                stack.push(code.substring(i,i+1));
            } else if (">})".indexOf(code.substring(i,i+1)) != -1) {
                if(stack.isEmpty() || (">})".indexOf(code.substring(i,i+1)) != "<{(".indexOf(stack.top()))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    public static double evalPostfix(String expression){
        return  0.0;
    }
}