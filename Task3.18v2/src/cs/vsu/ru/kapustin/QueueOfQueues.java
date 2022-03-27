package cs.vsu.ru.kapustin;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOfQueues {

    public QueueOfQueues() {
    }

    public Queue<Queue<Integer>> create(int length) {
        Queue<Queue<Integer>> resultQueue = new LinkedList<>();
        for (int i = 1; i <= length; i++) {
            resultQueue.add(createInternalQueue(i));
        }

        return resultQueue;
    }

    private Queue<Integer> createInternalQueue(int lastNumber) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= lastNumber; i++) {
            queue.add(i);
        }

        return queue;
    }
}
