//225. Implement Stack using Queues
public class pblmNo225 {
    int[] arr;
    int front;
    int rear;
    int capacity;

    public pblmNo225() {
        capacity = 100;
        arr = new int[capacity];
        front = -1;
        rear = -1;
    }
    
    public void push(int data) {
        if (rear == capacity - 1) {
            return; 
        }
        if (front == -1) {
            front = 0;
        }
        arr[++rear] = data;
    }
    
    public int pop() {
        if (front == -1) {
            return -1;
        }

        if (front == rear) {
            int data = arr[front];
            front = -1;
            rear = -1;
            return data;
        }
        int size = rear - front + 1;
        for (int i = 0; i < size - 1; i++) {
            int temp = arr[front];
            front++;
            arr[++rear] = temp;
        }

        int popped = arr[front];
        front++;

        if (front > rear) {
            front = -1;
            rear = -1;
        }

        return popped;
    }
    
    public int top() {
        if (front == -1) return -1;
        return arr[rear];
    }
    
    public boolean empty() {
        return front == -1;
    }
}
