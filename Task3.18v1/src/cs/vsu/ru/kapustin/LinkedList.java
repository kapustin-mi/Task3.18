package cs.vsu.ru.kapustin;

import java.util.Collection;
import java.util.NoSuchElementException;

public class LinkedList<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public LinkedList() {
    }

    public LinkedList(Collection<T> collection) {
        addAll(collection);
    }

    public void addAll(Collection<T> c) {
        for (T element : c) {
            if (element != null) {
                addLast(element);
            }
        }
    }

    public void addFirst(T elem) {
        first = new Node<>(elem, first);
        if (size == 0) {
            last = first;
        }
        size++;
    }

    public void addLast(T elem) {
        Node<T> newLast = new Node<>(elem, null);
        if (size == 0) {
            first = newLast;
        } else {
            last.next = newLast;
        }
        last = newLast;
        size++;
    }

    public void add(int index, T elem) {
        checkPositionIndex(index);

        if (index == size) {
            addLast(elem);
        } else if (index == 0) {
            addFirst(elem);
        } else {
            Node<T> nodeBefore = node(index - 1);
            nodeBefore.next = new Node<>(elem, nodeBefore.next);
            size++;
        }
    }

    public void removeFirst() {
        checkEmpty();

        if (size == 1) {
            last = null;
            first = null;
        } else {
            first = first.next;
            last.next = first;
        }
        size--;
    }

    public void removeLast() {
        checkEmpty();

        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = node(size - 2);
            last.next = null;
        }
        size--;
    }

    public void remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> nodeBefore = node(index - 1);
            remove(nodeBefore);
        }
    }

    private void remove(Node<T> nodeBefore) {
        nodeBefore.next = nodeBefore.next.next;
        size--;
    }

    private Node<T> node(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkElementIndex(index);
        return node(index).value;
    }

    public T first() {
        checkEmpty();
        return first.value;
    }

    public T last() {
        checkEmpty();
        return last.value;
    }

    private void checkEmpty() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
