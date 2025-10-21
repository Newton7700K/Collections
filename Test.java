public class Test
{
    public static void testMyQueue(){
        MyQueue queue = new MyQueue(10);
        for(int i = 1; i<30; i++){
            queue.enqueue(i);
            System.out.println(queue.toString());
        }
    }
}