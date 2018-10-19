package linkedlist;

/**
 * @Auther: Ben
 * @Date: 2018/10/18 14
 * @Description:
 */


public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;

    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) return;

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) return;

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) return;

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

        // 可重复删除指定value的代码
    /*
    if (head != null && head.data == value) {
    	head = head.next;
    }
    Node pNode = head;
    while (pNode != null) {
    	if (pNode.next.data == data) {
    		pNode.next = pNode.next.next;
    		continue;
    	}
    	pNode = pNode.next;
    }
    */
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void printAll(Node node) {
        Node p = node;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    /**
     * 采用递归方法对链表进行反转，注意temp head和 temp.next的使用
     * @param head
     * @return
     */
    public Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        //将下一个节点暂存到tmp，tmp为3 2 1
        Node temp = head.next;
        //递归head.next
        Node newHead = reverse(head.next);
        //将上一个节点的next指向当前节点 (1.next-> 2 head) (2.next -> 3 head)...
        temp.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 采用循环的方式进行反转
     * @param list
     * @return
     */
    public Node reverse2(Node list) {
        Node headNode = null;

        Node previousNode = null;
        Node currentNode = list;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                //如果当前指针是最后一个节点，将headNode指向他
                headNode = currentNode;
            }
            //1 当前节点的下一个指针指向他的上一个节点，也就是将当前节点的下一个节点变为上一个节点，起到了反转的作用，所以这一步很重要，后面两步就是调整上一个节点和当前节点的指针
            currentNode.next = previousNode;
            //2 设置上一个节点为当前节点
            previousNode = currentNode;
            //3 设置当前节点为下一个节点
            currentNode = nextNode;
        }

        return headNode;
    }

    /**
     * 采用快慢指针
     * @param list
     * @return
     */
    public static boolean checkCircle(Node list){
        //不知道为啥要list.next 其实使用list也是可以的
        Node fast = list.next;
        Node slow = list;
        //这里只判断fast.next不用判断fast.next.next
        // 是因为在代码里已经将fast = fast.next.next;指向fast，所以判断fast不为空就好了
        while(fast != null && fast.next != null){
            //快指针每次走两步
            fast = fast.next.next;
            //慢指针每次走一步
            slow = slow.next;
            //如果是一个环，快慢指针早晚会相遇
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 采用递归方法合并两个有序链表
     * @param one
     * @param two
     * @return
     */
    public static Node mergeSortedList2(Node one,Node two){
        if(one == null){
            return two;
        }
        if(two == null){
            return one;
        }
        Node head;
        if(one.data < two.data){
            head = one;
            head.next = mergeSortedList2(one.next,two);
        }else{
            head = two;
            head.next = mergeSortedList2(one,two.next);
        }
        return head;
    }

    /**
     * 合并两个有序的链表
     * @param n1
     * @param n2
     * @return
     */
    public static Node mergeSortedList(Node n1,Node n2){
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }
        Node one = n1;
        Node two = n2;
        Node head;
        //这个看着变扭但是没办法，需要给head第一个节点单独判断。
        if (one.data < two.data) {
            head = one;
            one = one.next;
        } else {
            head = two;
            two = two.next;
        }
        Node mergeNode = head;
        //循环one 和 two 将最小的数循环的接到mergeNode后面
        while(one != null && two != null){
            if(one.data < two.data){
                mergeNode.next = one;
                one = one.next;
            }else{
                mergeNode.next = two;
                two = two.next;
            }
            mergeNode = mergeNode.next;
        }
        //例如one:1 2 3 4 two:5 6 7 ，one都走完了，所以要把two接到mergeNo后面
        if(one != null){
            mergeNode.next = one;
        }else{
            mergeNode.next = two;
        }
        return head;
    }


    /**
     * 删除倒数第k个节点，开始想全部遍历一遍不就知道倒数第几个在哪了，为啥用快慢指针，
     * 后来知道如果数据量很大的情况时间复杂度就是O(n)，采用快慢指针时间复杂度才为O(1).
     * @param list
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        //如果k为2,则fast往右走一步
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;

        Node slow = list;
        Node prev = null;
        //两个指针一起往右走，当fast.next为null时，slow正好指向k个节点
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev == null) {
            list = list.next;
        } else {
            //删除当前的slow所指向的节点
            prev.next = prev.next.next;
        }
        return list;
    }

    /**
     * 求中间结点
     * @param list
     * @return
     */
    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }
        Node fast = list;
        Node slow = list;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        //测试链表反转
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertToHead(1);
        singlyLinkedList.insertToHead(2);
        singlyLinkedList.insertToHead(3);
        singlyLinkedList.insertToHead(4);
        singlyLinkedList.printAll();
        Node re = singlyLinkedList.reverse(singlyLinkedList.head);
        SinglyLinkedList.printAll(re);
        System.out.println("this node reverse end ");
        //测试链表是否有环
        Node node1 = SinglyLinkedList.createNode(1);
        Node node2 = SinglyLinkedList.createNode(1);
        Node node3 = SinglyLinkedList.createNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        boolean b = checkCircle(node1);
        System.out.println("this node is Circle " + b);
        //测试合并两个有序的链表
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        singlyLinkedList2.insertToHead(5);
        singlyLinkedList2.insertToHead(3);
        singlyLinkedList2.insertToHead(1);
        SinglyLinkedList singlyLinkedList3 = new SinglyLinkedList();
        singlyLinkedList3.insertToHead(6);
        singlyLinkedList3.insertToHead(4);
        singlyLinkedList3.insertToHead(2);
        Node mergeNode = mergeSortedList2(singlyLinkedList2.head, singlyLinkedList3.head);
        SinglyLinkedList.printAll(mergeNode);
        System.out.println("this is mergeNode end ");
        //测试删除第k个节点
        Node deleteLastKth = deleteLastKth(mergeNode, 2);
        SinglyLinkedList.printAll(deleteLastKth);
        System.out.println("this is deleteLastKth end ");
        //测试找到中间节点
        SinglyLinkedList singlyLinkedList4 = new SinglyLinkedList();
        singlyLinkedList4.insertToHead(1);
        singlyLinkedList4.insertToHead(2);
        singlyLinkedList4.insertToHead(3);
        singlyLinkedList4.insertToHead(4);
        singlyLinkedList4.insertToHead(5);
        singlyLinkedList4.insertToHead(6);
        singlyLinkedList4.insertToHead(7);
        singlyLinkedList4.printAll();
        Node middleNode = findMiddleNode(singlyLinkedList4.head);
        SinglyLinkedList.printAll(middleNode);
        System.out.println("this is findMiddleNode end ");
    }
}