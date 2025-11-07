import java.util.*;
public class Test
{   
    
    public static void testMyStack(){
        //––––––––––––––––––––––––––––––––Creating Stacks––––––––––––––––––––––––––––––––|
        
        MyStack stack1 = new MyStack(0);
        MyStack stack2 = new MyStack(1);
        MyStack stack3 = new MyStack(2);
        MyStack stack4 = new MyStack(3);
        MyStack stack5 = new MyStack(4);
        MyStack stack6 = new MyStack(5);
        
        //––––––––––––––––––––––––––––––––––Testing push–––––––––––––––––––––––––––––––––|
        
        System.out.println("Testing push:");
        boolean threwError1 = false;
        boolean threwError2 = false;
        boolean threwError3 = false;
        boolean threwError4 = false;
        boolean threwError5 = false;
        boolean threwError6 = false;
        
        try {
            stack1.push(1);
        } catch(IllegalStateException E) {
            threwError1 = true;
        }
        
        stack2.push(1);
        try {
            stack1.push(2);
        } catch(IllegalStateException E) {
            threwError2 = true;
        }
        
        stack3.push(1);
        stack3.push(2);
        try {
            stack1.push(3);
        } catch(IllegalStateException E) {
            threwError3 = true;
        }
        
        stack4.push(1);
        stack4.push(2);
        stack4.push(3);
        try {
            stack1.push(4);
        } catch(IllegalStateException E) {
            threwError4 = true;
        }
        
        stack5.push(1);
        stack5.push(2);
        stack5.push(3);
        stack5.push(4);
        try {
            stack1.push(5);
        } catch(IllegalStateException E) {
            threwError5 = true;
        }
        
        stack6.push(1);
        stack6.push(2);
        stack6.push(3);
        stack6.push(4);
        stack6.push(5);
        try {
            stack1.push(6);
        } catch(IllegalStateException E) {
            threwError6 = true;
        }
        
        System.out.print("Caught thrown errors: ");
        System.out.print(threwError1 ? "pass " : "fail ");
        System.out.print(threwError2 ? "pass " : "fail ");
        System.out.print(threwError3 ? "pass " : "fail ");
        System.out.print(threwError4 ? "pass " : "fail ");
        System.out.print(threwError5 ? "pass " : "fail ");
        System.out.println(threwError6 ? "pass " : "fail ");
        
        System.out.print("Stacks created correctly(and testing toString): ");
        System.out.print(stack1.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack2.toString().equals("1") ? "pass " : "fail ");
        System.out.print(stack3.toString().equals("2, 1") ? "pass " : "fail ");
        System.out.print(stack4.toString().equals("3, 2, 1") ? "pass " : "fail ");
        System.out.print(stack5.toString().equals("4, 3, 2, 1") ? "pass " : "fail ");
        System.out.println(stack6.toString().equals("5, 4, 3, 2, 1") ? "pass " : "fail ");
        
        System.out.println();
        
        //––––––––––––––––––––––––––––––––––Testing size–––––––––––––––––––––––––––––––––|
        
        System.out.print("Returned correct size: ");
        System.out.print(stack1.size() == 0 ? "pass " : "fail ");
        System.out.print(stack2.size() == 1 ? "pass " : "fail ");
        System.out.print(stack3.size() == 2 ? "pass " : "fail ");
        System.out.print(stack4.size() == 3 ? "pass " : "fail ");
        System.out.print(stack5.size() == 4 ? "pass " : "fail ");
        System.out.println(stack6.size() == 5 ? "pass " : "fail ");
        
        System.out.println();
        
        //–––––––––––––––––––––––––––––––––Testing isFull––––––––––––––––––––––––––––––––|
        
        System.out.print("Returned correct size: ");
        System.out.print(stack1.isFull() ? "pass " : "fail ");
        System.out.print(stack2.isFull() ? "pass " : "fail ");
        System.out.print(stack3.isFull() ? "pass " : "fail ");
        System.out.print(stack4.isFull() ? "pass " : "fail ");
        System.out.print(stack5.isFull() ? "pass " : "fail ");
        System.out.println(stack6.isFull() ? "pass " : "fail ");
        
        System.out.println();
        
        //––––––––––––––––––––––––––––––––––Testing pop––––––––––––––––––––––––––––––––––|
        
        System.out.println("Testing pop:");
        threwError1 = false;
        threwError2 = false;
        threwError3 = false;
        threwError4 = false;
        threwError5 = false;
        threwError6 = false;
        
        try {
            stack1.pop();
        } catch(EmptyStackException E) {
            threwError1 = true;
        }
        
        stack2.pop();
        try {
            stack1.pop();
        } catch(EmptyStackException E) {
            threwError2 = true;
        }
        
        stack3.pop();
        stack3.pop();
        try {
            stack1.pop();
        } catch(EmptyStackException E) {
            threwError3 = true;
        }
        
        stack4.pop();
        stack4.pop();
        stack4.pop();
        try {
            stack1.pop();
        } catch(EmptyStackException E) {
            threwError4 = true;
        }
        
        stack5.pop();
        stack5.pop();
        stack5.pop();
        stack5.pop();
        try {
            stack1.pop();
        } catch(EmptyStackException E) {
            threwError5 = true;
        }
        
        stack6.pop();
        stack6.pop();
        stack6.pop();
        stack6.pop();
        stack6.pop();
        try {
            stack1.pop();
        } catch(EmptyStackException E) {
            threwError6 = true;
        }
        
        System.out.print("Caught thrown errors: ");
        System.out.print(threwError1 ? "pass " : "fail ");
        System.out.print(threwError2 ? "pass " : "fail ");
        System.out.print(threwError3 ? "pass " : "fail ");
        System.out.print(threwError4 ? "pass " : "fail ");
        System.out.print(threwError5 ? "pass " : "fail ");
        System.out.println(threwError6 ? "pass " : "fail ");
        
        System.out.print("Stacks cleared correctly: ");
        System.out.print(stack1.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack2.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack3.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack4.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack5.toString().equals("") ? "pass " : "fail ");
        System.out.println(stack6.toString().equals("") ? "pass " : "fail ");
        
        System.out.println();
        
        //––––––––––––––––––––––––––––––––Testing isEmpty––––––––––––––––––––––––––––––––|
        
        System.out.print("Testing isEmpty: ");
        System.out.print(stack1.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack2.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack3.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack4.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack5.toString().equals("") ? "pass " : "fail ");
        System.out.println(stack6.toString().equals("") ? "pass " : "fail ");
        
        System.out.println();
        
        //––––––––––––––––––––––––––––––––––Testing front––––––––––––––––––––––––––––––––––|
        
        System.out.println("Testing top: ");
        
        boolean threwTopError = false;
        
        try {
            stack1.top();
        } catch (EmptyStackException E) {
            threwTopError = true;
        }
        
        stack2.push(1);
        stack3.push(2);
        stack4.push(3);
        stack5.push(4);
        stack6.push(5);
        
        System.out.print("Caught thrown error: ");
        System.out.println(threwTopError ? "pass " : "fail ");
        
        System.out.print("Returned top correctly: ");
        System.out.print(stack2.top().equals(1) ? "pass " : "fail ");
        System.out.print(stack3.top().equals(2) ? "pass " : "fail ");
        System.out.print(stack4.top().equals(3) ? "pass " : "fail ");
        System.out.print(stack5.top().equals(4) ? "pass " : "fail ");
        System.out.print(stack6.top().equals(5) ? "pass " : "fail ");
        
        System.out.println();
        
        //–––––––––––––––––––––––––––Testing diff object types–––––––––––––––––––––––––––|
        
        System.out.print("Testing other object types: ");
        
        stack2.pop();
        stack3.pop();
        stack4.pop();
        stack5.pop();
        stack6.pop();
        
        stack2.push("Hello");
        stack3.push(2.312);
        stack4.push(true);
        stack5.push('a');
        
        System.out.print(stack2.top().equals("Hello") ? "pass " : "fail ");
        System.out.print(stack3.top().equals(2.312) ? "pass " : "fail ");
        System.out.print(stack4.top().equals(true) ? "pass " : "fail ");
        System.out.println(stack5.top().equals('a') ? "pass " : "fail ");
        
        System.out.println();

        //––––––––––––––––––––––––––––––Testing efficiency–––––––––––––––––––––––––––––––|
        
        System.out.println("Testing array size 100 mil: ");
        
        MyStack largeStack = new MyStack(100000000);
        
        System.out.println("Loading: ");
        
        for(int i = 0; i<100000000; i++){
            if((double) (i / 10000000) == (double) i / 10000000){
                System.out.print("|");
            }
            largeStack.push(i);
        }
        
        System.out.println(" Finished!");
        System.out.println();
        System.out.println("Testing largeArray methods:");
        
        System.out.println("IsEmpty: " + largeStack.isEmpty());
        System.out.println("IsFull: " + largeStack.isFull());
        System.out.println("Top: " + largeStack.top());
        System.out.println("Size: " + largeStack.size());
    }
    
    public static void testMyQueue(){
        //––––––––––––––––––––––––––––––––Creating Stacks––––––––––––––––––––––––––––––––|
        
        MyQueue stack1 = new MyQueue(0);
        MyQueue stack2 = new MyQueue(1);
        MyQueue stack3 = new MyQueue(2);
        MyQueue stack4 = new MyQueue(3);
        MyQueue stack5 = new MyQueue(4);
        MyQueue stack6 = new MyQueue(5);
        
        //––––––––––––––––––––––––––––––––––Testing enqueue–––––––––––––––––––––––––––––––––|
        
        System.out.println("Testing enqueue:");
        boolean threwError1 = false;
        boolean threwError2 = false;
        boolean threwError3 = false;
        boolean threwError4 = false;
        boolean threwError5 = false;
        boolean threwError6 = false;
        
        try {
            stack1.enqueue(1);
        } catch(IllegalStateException E) {
            threwError1 = true;
        }
        
        stack2.enqueue(1);
        try {
            stack1.enqueue(2);
        } catch(IllegalStateException E) {
            threwError2 = true;
        }
        
        stack3.enqueue(1);
        stack3.enqueue(2);
        try {
            stack1.enqueue(3);
        } catch(IllegalStateException E) {
            threwError3 = true;
        }
        
        stack4.enqueue(1);
        stack4.enqueue(2);
        stack4.enqueue(3);
        try {
            stack1.enqueue(4);
        } catch(IllegalStateException E) {
            threwError4 = true;
        }
        
        stack5.enqueue(1);
        stack5.enqueue(2);
        stack5.enqueue(3);
        stack5.enqueue(4);
        try {
            stack1.enqueue(5);
        } catch(IllegalStateException E) {
            threwError5 = true;
        }
        
        stack6.enqueue(1);
        stack6.enqueue(2);
        stack6.enqueue(3);
        stack6.enqueue(4);
        stack6.enqueue(5);
        try {
            stack1.enqueue(6);
        } catch(IllegalStateException E) {
            threwError6 = true;
        }
        
        System.out.print("Caught thrown errors: ");
        System.out.print(threwError1 ? "pass " : "fail ");
        System.out.print(threwError2 ? "pass " : "fail ");
        System.out.print(threwError3 ? "pass " : "fail ");
        System.out.print(threwError4 ? "pass " : "fail ");
        System.out.print(threwError5 ? "pass " : "fail ");
        System.out.println(threwError6 ? "pass " : "fail ");
        
        System.out.print("Stacks created correctly(and testing toString): ");
        System.out.print(stack1.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack2.toString().equals("1") ? "pass " : "fail ");
        System.out.print(stack3.toString().equals("2, 1") ? "pass " : "fail ");
        System.out.print(stack4.toString().equals("3, 2, 1") ? "pass " : "fail ");
        System.out.print(stack5.toString().equals("4, 3, 2, 1") ? "pass " : "fail ");
        System.out.println(stack6.toString().equals("5, 4, 3, 2, 1") ? "pass " : "fail ");
        
        System.out.println();
        
        //––––––––––––––––––––––––––––––––––Testing size–––––––––––––––––––––––––––––––––|
        
        System.out.print("Returned correct size: ");
        System.out.print(stack1.size() == 0 ? "pass " : "fail ");
        System.out.print(stack2.size() == 1 ? "pass " : "fail ");
        System.out.print(stack3.size() == 2 ? "pass " : "fail ");
        System.out.print(stack4.size() == 3 ? "pass " : "fail ");
        System.out.print(stack5.size() == 4 ? "pass " : "fail ");
        System.out.println(stack6.size() == 5 ? "pass " : "fail ");
        
        System.out.println();
        
        //–––––––––––––––––––––––––––––––––Testing isFull––––––––––––––––––––––––––––––––|
        
        System.out.print("Returned correct size: ");
        System.out.print(stack1.isFull() ? "pass " : "fail ");
        System.out.print(stack2.isFull() ? "pass " : "fail ");
        System.out.print(stack3.isFull() ? "pass " : "fail ");
        System.out.print(stack4.isFull() ? "pass " : "fail ");
        System.out.print(stack5.isFull() ? "pass " : "fail ");
        System.out.println(stack6.isFull() ? "pass " : "fail ");
        
        System.out.println();
        
        //––––––––––––––––––––––––––––––––––Testing dequeue––––––––––––––––––––––––––––––––––|
        
        System.out.println("Testing dequeue:");
        threwError1 = false;
        threwError2 = false;
        threwError3 = false;
        threwError4 = false;
        threwError5 = false;
        threwError6 = false;
        
        try {
            stack1.dequeue();
        } catch(EmptyStackException E) {
            threwError1 = true;
        }
        
        stack2.dequeue();
        try {
            stack1.dequeue();
        } catch(EmptyStackException E) {
            threwError2 = true;
        }
        
        stack3.dequeue();
        stack3.dequeue();
        try {
            stack1.dequeue();
        } catch(EmptyStackException E) {
            threwError3 = true;
        }
        
        stack4.dequeue();
        stack4.dequeue();
        stack4.dequeue();
        try {
            stack1.dequeue();
        } catch(EmptyStackException E) {
            threwError4 = true;
        }
        
        stack5.dequeue();
        stack5.dequeue();
        stack5.dequeue();
        stack5.dequeue();
        try {
            stack1.dequeue();
        } catch(EmptyStackException E) {
            threwError5 = true;
        }
        
        stack6.dequeue();
        stack6.dequeue();
        stack6.dequeue();
        stack6.dequeue();
        stack6.dequeue();
        try {
            stack1.dequeue();
        } catch(EmptyStackException E) {
            threwError6 = true;
        }
        
        System.out.print("Caught thrown errors: ");
        System.out.print(threwError1 ? "pass " : "fail ");
        System.out.print(threwError2 ? "pass " : "fail ");
        System.out.print(threwError3 ? "pass " : "fail ");
        System.out.print(threwError4 ? "pass " : "fail ");
        System.out.print(threwError5 ? "pass " : "fail ");
        System.out.println(threwError6 ? "pass " : "fail ");
        
        System.out.print("Stacks cleared correctly: ");
        System.out.print(stack1.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack2.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack3.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack4.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack5.toString().equals("") ? "pass " : "fail ");
        System.out.println(stack6.toString().equals("") ? "pass " : "fail ");
        
        System.out.println();
        
        //––––––––––––––––––––––––––––––––Testing isEmpty––––––––––––––––––––––––––––––––|
        
        System.out.print("Testing isEmpty: ");
        System.out.print(stack1.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack2.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack3.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack4.toString().equals("") ? "pass " : "fail ");
        System.out.print(stack5.toString().equals("") ? "pass " : "fail ");
        System.out.println(stack6.toString().equals("") ? "pass " : "fail ");
        
        System.out.println();
        
        //––––––––––––––––––––––––––––––––––Testing front––––––––––––––––––––––––––––––––––|
        
        System.out.println("Testing front: ");
        
        boolean threwFrontError = false;
        
        try {
            stack1.front();
        } catch (EmptyStackException E) {
            threwFrontError = true;
        }
        
        stack2.enqueue(1);
        stack3.enqueue(2);
        stack4.enqueue(3);
        stack5.enqueue(4);
        stack6.enqueue(5);
        
        System.out.print("Caught thrown error: ");
        System.out.println(threwFrontError ? "pass " : "fail ");
        
        System.out.print("Returned front correctly: ");
        System.out.print(stack2.front().equals(1) ? "pass " : "fail ");
        System.out.print(stack3.front().equals(2) ? "pass " : "fail ");
        System.out.print(stack4.front().equals(3) ? "pass " : "fail ");
        System.out.print(stack5.front().equals(4) ? "pass " : "fail ");
        System.out.print(stack6.front().equals(5) ? "pass " : "fail ");
        
        System.out.println();
        
        //–––––––––––––––––––––––––––Testing diff object types–––––––––––––––––––––––––––|
        
        System.out.print("Testing other object types: ");
        
        stack2.dequeue();
        stack3.dequeue();
        stack4.dequeue();
        stack5.dequeue();
        stack6.dequeue();
        
        stack2.enqueue("Hello");
        stack3.enqueue(2.312);
        stack4.enqueue(true);
        stack5.enqueue('a');
        
        System.out.print(stack2.front().equals("Hello") ? "pass " : "fail ");
        System.out.print(stack3.front().equals(2.312) ? "pass " : "fail ");
        System.out.print(stack4.front().equals(true) ? "pass " : "fail ");
        System.out.println(stack5.front().equals('a') ? "pass " : "fail ");
        
        System.out.println();

        //––––––––––––––––––––––––––––––Testing efficiency–––––––––––––––––––––––––––––––|
        
        System.out.println("Testing array size 100 mil: ");
        
        MyQueue largeStack = new MyQueue(100000000);
        
        System.out.println("Loading: ");
        
        for(int i = 0; i<100000000; i++){
            if((double) (i / 10000000) == (double) i / 10000000){
                System.out.print("|");
            }
            largeStack.enqueue(i);
        }
        
        System.out.println(" Finished!");
        System.out.println();
        System.out.println("Testing largeArray methods:");
        
        System.out.println("IsEmpty: " + largeStack.isEmpty());
        System.out.println("IsFull: " + largeStack.isFull());
        System.out.println("Front: " + largeStack.front());
        System.out.println("Size: " + largeStack.size());
    }
    
    public static void testMyStackLL(){
        
    }
    
    public static void testMyQueueLL(){
        
    }
    
    public static void testMyLinkedList(){
        
    }
    
}