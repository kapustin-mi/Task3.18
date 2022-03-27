package cs.vsu.ru.kapustin;

public class Queue<T> extends LinkedList<T> {

    public Queue() {
        super();
    }

    public void add(T element) {
        addLast(element);
    }

    public T poll() {
        T elem = peek();
        removeFirst();

        return elem;
    }

    public T peek() {
        if (size() == 0) {
            return null;
        }

        return first();
    }

    public int count() {
        return size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append('{');
        while (peek() != null) {
            sb.append(poll());

            if (peek() != null) {
                sb.append(", ");
            }
        }
        sb.append('}');

        return sb.toString();
    }
}
