package MyQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Voidmian
 * @Date 2019/10/25 10:45
 */
public class MyCircularQueue {
    /** Initialize your data structure here. Set the size of the queue to be k. */
    private int []  myCircularQueue ;
    private Integer myQueueHead;
    private Integer myQueueTail;
    private Integer myQueueLength;

    static public void test(){
        MyCircularQueue myCircularQueue=new MyCircularQueue(6);
        System.out.println(myCircularQueue.enQueue(6));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.enQueue(5));
    }


    public MyCircularQueue(int k) {
        myCircularQueue =new int[k];
        myQueueHead=-1;
        myQueueTail=-1;
        myQueueLength=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        if (isEmpty()) {
            myCircularQueue[0]=value;
            myQueueHead = 0;
            myQueueTail = 0;
            return true;
        }
        myQueueTail++;
        myQueueTail%=myQueueLength;
        myCircularQueue[myQueueTail]=value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
            return false;
        if (myQueueHead==myQueueTail) {
            myQueueHead=-1;
            myQueueTail=-1;
            return true;
        }
        myQueueHead++;
        myQueueHead%=myQueueLength;
        return true;
    }

    /** Get the front item from the queue. */
    public Integer Front() {
        if(myQueueHead==-1)
            return -1;
        return myCircularQueue[myQueueHead];
    }

    /** Get the last item from the queue. */
    public Integer Rear() {
        if(myQueueTail==-1)
            return -1;
        return myCircularQueue[myQueueTail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(myQueueHead == -1 && myQueueTail==-1)
            return true;
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        int temp=myQueueTail+1;
        temp%=myQueueLength;
        if(temp == myQueueHead) {
            return true;
        }
        return false;
    }
}
