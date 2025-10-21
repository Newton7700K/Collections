public class Test
{
    private static MyQueue queue = new MyQueue(10);
    
    public static void testMyQueue(){
        for(int i = 1; i<30; i++){
            queue.enqueue(i);
            System.out.println(queue.toString());
        }
        System.out.println();
        for(int i = 0; i<2; i++){
            queue.dequeue();
            System.out.println(queue.toString());
        }
    }
    
    public static void testDequeue(){
        System.out.println(queue.dequeue());
        System.out.println(queue.toString());
    }
}