import java.util.*;
public class Test
{   
    
    public static void testMyStack(){
        //Creating Stacks
        MyStack stack1 = new MyStack(0);
        MyStack stack2 = new MyStack(1);
        MyStack stack3 = new MyStack(2);
        MyStack stack4 = new MyStack(3);
        MyStack stack5 = new MyStack(4);
        MyStack stack6 = new MyStack(5);
        MyStack stack7 = new MyStack();
        MyStack stack8 = new MyStack();
        MyStack stack9 = new MyStack();
        MyStack stack10 = new MyStack();
        
        //Testing push
        System.out.print("Testing push: ");
        boolean threwError = false;
        try {
            stack1.push(1);
        } catch(IllegalStateException E) {
            threwError = true;
        }
        System.out.println();
        //Testing pop
        
        //Testing isEmpty
        
        //Testing top
        
        //Testing size
        
        //testing isFull
        
        //testing toString
    }
    
    public static void testMyQueue(){
        
    }
    
    public static void testMyStackLL(){
        
    }
    
    public static void testMyQueueLL(){
        
    }
    
    public static void testMyLinkedList(){
        
    }
    
}