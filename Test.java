import java.util.*;
public class Test
{   
    
    public static void testMyQueue(){
        MyQueue<Integer> queue = new MyQueue<Integer>(5);
        try{
            System.out.println(queue.front());
        } catch(NoSuchElementException e) {
            System.out.println("NoSuchElementException");
        }
        System.out.println("Size: " + queue.size());
        System.out.println("Is Empty: " + queue.isEmpty());
        System.out.println("Is Full: " + queue.isFull());
        queue.enqueue(1);
        System.out.println(queue);
        queue.enqueue(2);
        System.out.println(queue);
        queue.enqueue(3);
        System.out.println(queue);
        queue.enqueue(4);
        System.out.println(queue);
        queue.enqueue(5);
        System.out.println(queue);
        try{
            queue.enqueue(6);
        } catch(IllegalStateException e) {
            System.out.println("IllegalStateException");
        }
        
        for(int i = 0; i<100; i++){
            queue.dequeue();
            queue.enqueue(i);
            System.out.println(queue);
        }
        
        MyQueue<String> queue1 = new MyQueue<String>(5);
        
        queue1.enqueue("Bananna");
        System.out.println(queue1);
        queue1.enqueue("Apple");
        System.out.println(queue1);
        queue1.enqueue("Cherry");
        System.out.println(queue1);
        queue1.enqueue("Watermelon");
        System.out.println(queue1);
        queue1.enqueue("Strawberry");
        System.out.println(queue1);
        for(int i = 0; i<100; i++){
            int random = (int)(Math.random()*179);
            String randomFruit = Fruits.fruitList[random];
            queue1.dequeue();
            queue1.enqueue(randomFruit);
            System.out.println(queue1);
        }
    }
    
    public static void testMyStack(){
        MyStack stack = new MyStack(5);
        try{
            System.out.println("Top: " + stack.top());
        } catch(EmptyStackException e) {
            System.out.println("EmptyStackException");
        }
        System.out.println("Size: " + stack.size());
        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println("Is Full: " + stack.isFull());
        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        stack.push(4);
        System.out.println(stack);
        stack.push(5);
        System.out.println(stack);
        try{
            stack.push(6);
        } catch(IllegalStateException e) {
            System.out.println("IllegalStateException");
        }
        System.out.println("Top: " + stack.top());
        System.out.println("Size: " + stack.size());
        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println("Is Full: " + stack.isFull());
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        try{
            stack.pop();
        } catch(EmptyStackException e) {
            System.out.println("EmptyStackException");
        }
        System.out.println("Size: " + stack.size());
        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println("Is Full: " + stack.isFull());
    }
    
}