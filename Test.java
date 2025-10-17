public class Test
{
    public static void testMyQueue(){
        MyQueue queue = new MyQueue(10);
        for(int i = 1; i<12; i++){
            queue.enqueue(i);
            System.out.println(queue.toString());
        }
    }
}