
public class Applications
{
    public static <E> void reverse(MyQueueLL<E> queue){
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
            if ("<{[(".indexOf(code.substring(i,i+1)) != -1) {
                stack.push(code.substring(i,i+1));
            } else if (">}])".indexOf(code.substring(i,i+1)) != -1) {
                if(stack.isEmpty() || (">}])".indexOf(code.substring(i,i+1)) != "<{[(".indexOf(stack.top()))){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    public static double evalPostfix(String expression){
        MyStack<Double> stack = new MyStack<Double>(expression.length());
        int startIdx = 0;
        int endIdx = 0;
        for(int i = 0; i<expression.length(); i++){
            if ("+-*/".indexOf(expression.substring(i,i+1)) == -1){
                if(expression.substring(i,i+1).equals(" ")){
                    endIdx = i;
                    stack.push(Double.parseDouble(expression.substring(startIdx,endIdx)));
                    startIdx = endIdx + 1;
                }
            }
            double secondDouble = stack.pop();
            switch("+-*/".indexOf(expression.substring(i,i+1))){
                case 1: //addition
                    stack.push(stack.pop() + secondDouble);
                    break;
                case 2: //subtraction
                    stack.push(stack.pop() - secondDouble);
                    break;
                case 3: //multiplication
                    stack.push(stack.pop() * secondDouble);
                    break;
                case 4: //division
                    stack.push(stack.pop() / secondDouble);
                    break;
            }
        }
        return  stack.top();
    }
}