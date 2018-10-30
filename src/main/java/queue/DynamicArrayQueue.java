package queue;

/**
 * @Auther: Ben
 * @Date: 2018/10/29 16
 * @Description:
 */
public class DynamicArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;
    public DynamicArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item){
        if(tail == n){
            if(head == 0){
                return false;
            }
            // 选择在入队操作搬移数据是因为如果在出队操作搬移数据的话，
            // 每次出队操作都会从时间复杂度O(1)变为O(n)
            // 在入队时操作的话就只有队列满了才会搬移一次，能减少搬移的次数
            for(int i = head; i < tail; ++i){
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    public String denqueque(){
        if(head == tail){
            return null;
        }
        String result = items[head];
        --head;
        return result;
    }

    public void pringAll(){
        for (int i = head; i < tail; ++i){
            System.out.println(items[i] + " ");
        }
    }

    public static void main(String[] args) {
        DynamicArrayQueue queue = new DynamicArrayQueue(7);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        //由于队列满了g就存不进去了
        queue.enqueue("g");
        queue.enqueue("o");
        System.out.println("=======printAll========");
        queue.pringAll();
    }

}
