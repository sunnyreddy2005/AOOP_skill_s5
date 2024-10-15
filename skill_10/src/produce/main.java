package produce;

import java.util.LinkedList;
import java.util.Queue;

class MessageQueue {
    private final int capacity;
    private final Queue<String> queue = new LinkedList<>();

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

   
    public synchronized void produce(String message) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); 
        }
        queue.add(message);
        System.out.println("Produced: " + message);
        notify(); 
    }

    
    public synchronized String consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); 
        }
        String message = queue.poll();
        System.out.println("Consumed: " + message);
        notify(); 
        return message;
    }
}


class Producer implements Runnable {
    private final MessageQueue queue;

    public Producer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int messageCount = 0;
        try {
            while (true) {
                String message = "Message-" + messageCount++;
                queue.produce(message);
                Thread.sleep(100); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


class Consumer implements Runnable {
    private final MessageQueue queue;

    public Consumer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                queue.consume();
                Thread.sleep(150); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class main {
    public static void main(String[] args) {
        
        MessageQueue messageQueue = new MessageQueue(5);

        
        Thread producerThread = new Thread(new Producer(messageQueue));
        Thread consumerThread = new Thread(new Consumer(messageQueue));

       
        producerThread.start();
        consumerThread.start();
    }
}
