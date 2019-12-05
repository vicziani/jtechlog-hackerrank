package tailoftwostacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue<T> {

    private Deque<T> stack1 = new ArrayDeque<>();

    private Deque<T> stack2 = new ArrayDeque<>();

    public void enqueue(T i) {
        stack1.push(i);
    }

    public void dequeue() {
        if (stack2.isEmpty()) {
            move();
        }
        stack2.pop();
    }


    public T peek() {
        if (stack2.isEmpty()) {
            move();
        }
        return stack2.peek();
    }

    private void move() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
