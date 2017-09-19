package com.company;

class LinkedListIter<T> {
    T value;

    LinkedListIter next;
    LinkedListIter pred;

    LinkedListIter(T value, LinkedListIter next, LinkedListIter pred) {
        this.value = value;
        this.next = next;
        this.pred = pred;
    }
}

public class LinkedList<T> {
    private LinkedListIter<T> head;
    private LinkedListIter<T> tail;
    private int size = 0;

    public LinkedList() {
        head = null;
        tail = null;
    }

    private LinkedListIter<T> goTo(int index) {
        if (index < 0) throw new ArrayIndexOutOfBoundsException();
        LinkedListIter<T> iter = head;
        for (int i = 0; i < index; i++) {
            if (iter == tail)
                throw new ArrayIndexOutOfBoundsException();
            iter = iter.next;
        }
        return iter;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return goTo(index).value;
    }

    public boolean add(T newItem) {
        addFirst(newItem);
        return true;
    }

    public boolean add(T newItem, int index) {
        size++;
        LinkedListIter iter = head;
        for (int i = 1; i < index; i++) {
            if (iter == tail) throw new ArrayIndexOutOfBoundsException();
            iter = iter.next;
        }
        LinkedListIter<T> item = new LinkedListIter<>(newItem, iter.next, iter);
        if (iter.next != null) iter.next.pred = item;
        else tail = item;
        iter.next = item;

        return true;
    }

    public void addLast(T newItem) {
        size++;
        LinkedListIter<T> item = new LinkedListIter(newItem, null, tail);
        if (tail != null) {
            tail.next = item;
        }
        tail = item;
        if (head == null) head = tail;
    }

    public void addFirst(T newItem) {
        size++;
        LinkedListIter<T> item = new LinkedListIter<>(newItem, head, null);
        if (head != null) head.pred = item;
        head = item;
        if (tail == null) tail = head;
    }

    public boolean contains(T value) {
        LinkedListIter start = head;
        LinkedListIter end = tail;
        if (start == end) return start.value.equals(value);
        while (start != end) {
            if ((start.value.equals(value)) || (end.value.equals(value))) return true;
            start = start.next;
            if (start != end) {
                end = end.pred;
            }
        }
        return false;
    }

    public T remove() {
        size--;
        LinkedListIter<T> temp = head;
        if (head != null) {
            if (head.next != null) {
                head = head.next;
            }
            head.pred = null;
            return temp.value;
        } else return null;
    }

    public T remove(T value) {
        size--;
        LinkedListIter<T> temp = head;
        while ((temp != tail)&&(!temp.value.equals(value))) {
            temp = temp.next;
        }
        if (temp == head) head = head.next;
        else temp.pred.next = temp.next;
        if (temp == tail) tail = tail.pred;
        else temp.next.pred = temp.pred;
        return temp.value;
    }

    public T set (int index, T e) {
        LinkedListIter<T> iter = goTo(index);
        if (iter.pred != null) iter.pred.next = iter.next;
        if (iter.next != null) iter.next.pred = iter.pred;
        return iter.value;
    }

    public int indexOf(T e) {
        LinkedListIter<T> iter = head;
        for (int i = 0; i < size; i++) {
            if (iter.value.equals(e)) return i;
            iter = iter.next;
        }
        return -1;
    }

    public int lastIndexOf(T e) {
        LinkedListIter<T> iter = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (iter.value.equals(e)) return i;
            iter = iter.pred;
        }
        return -1;
    }

}