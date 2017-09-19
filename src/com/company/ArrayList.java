package com.company;

import java.util.Collection;

public class ArrayList<T> {

    private int size = 0;
    private Object[] elements = new Object[size];

    private void extend() {
        Object[] temp = elements;
        elements = new Object[size + 1];
        System.arraycopy(temp, 0, elements, 0, size);
        size++;
    }

    public ArrayList() {
    }

    public ArrayList(int size) {
        if (size < 0) throw new IllegalArgumentException();
        this.size = size;
        elements = new Object[size];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T e) {
        extend();
        elements[size - 1] = e;
        return true;
    }

    public void add(T e, int index) {
        if ((index < 0)||(index > size)) throw new IllegalArgumentException();
        extend();
        if (index != size - 1) {
            System.arraycopy(elements, index, elements, index + 1, size - index - 1);
        }
        elements[index] = e;
    }

    public T get(int index) {
        if ((index < 0)||(index > size)) throw new IllegalArgumentException();
        return (T)elements[index];
    }

    public void addAll(Collection<T> elems) {
        for (T elem : elems) {
            add(elem);
        }
    }

    public T remove(int index) {
        if ((index < 0)||(index > size)) throw new IllegalArgumentException();
        size--;
        Object[] temp = elements;
        elements = new Object[size];
        System.arraycopy(temp, 0, elements, 0, index);
        System.arraycopy(temp, index + 1, elements, index, size - index);
        return (T) temp[index];
    }

    public boolean remove(T e) {
        int i = indexOf(e);
        if (i < 0) return false;
        remove(i);
        return true;
    }

    public int indexOf(T e) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) return i;
        }
        return -1;
    }

    public int lastIndexOf(T e) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(e)) return i;
        }
        return -1;
    }

    public void clear() {
        elements = new Object[0];
        size = 0;
    }

    public T set(int index, T e) {
        T temp = (T) elements[index];
        elements[index] = e;
        return temp;
    }

    public boolean contains(T e) {
        return indexOf(e) >= 0;
    }
}