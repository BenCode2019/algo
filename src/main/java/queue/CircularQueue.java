package queue;

/**
 * 循环队列
 * @Auther: Ben
 * @Date: 2018/10/29 13
 * @Description:
 */
public class CircularQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item){
        //判断队列是否满了的算法
        if((tail + 1) % n == head){
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    //出队
    public String dequeue(){
        if(head == tail){
            return null;
        }
        String result = items[head];
        head = (head + 1) % n;
        return result;
    }

    public void printAll(){
        if(0 == n){
            return;
        }
        for (int i = head; i % n != tail; ++i){
            System.out.println(items[i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("如果被除数小于除数，余数总等于被除数");
        System.out.println(4%5);
        CircularQueue queue = new CircularQueue(7);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        //由于队列满了g就存不进去了
        queue.enqueue("g");
        System.out.println("=======printAll========");
        queue.printAll();
        String dequeue = queue.dequeue();
        System.out.println("========deque========");
        System.out.println(dequeue);
        System.out.println("=======printAll========");
        queue.printAll();
    }
}
