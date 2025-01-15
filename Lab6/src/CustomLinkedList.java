import java.util.*;

public class CustomLinkedList<T> implements CustomList<T> {

    private Node<T> head;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public CustomLinkedList(T data) {
        if (data == null){
            throw new NullPointerException("Data cannot be null");
        }
        this.head = new Node<>(data);
        this.size = 1;
    }

    public CustomLinkedList(Collection<? extends T> collection) {
        if (collection == null){
            throw new NullPointerException("Collection cannot be null");
        }
        this.head = null;
        this.size = 0;
        for (T item : collection) {
            add(item);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int i = 0;
        while(current != null){
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a == null){
            throw new NullPointerException("Array cannot be null");
        }
        if(a.length < size){
            a = (T1[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        Node<T> current = head;
        int i = 0;
        while(current != null){
            try {
                a[i++] = (T1) current.data;
            } catch (ClassCastException e) {
                throw new ArrayStoreException("Array type is incompatible");
            }
            current = current.next;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        if (t == null){
            throw new NullPointerException("Track cannot be null");
        }
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (Objects.equals(head.data, o)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.data, o)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Collection cannot be null");
        }
        for(Object item : c){
            if(!contains(item)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null){
            throw new NullPointerException("Collection cannot be null");
        }
        boolean modified = false;
        for (T item : c) {
            if(add(item)){
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if(c == null){
            throw new NullPointerException("Collection cannot be null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if(c.isEmpty()){
            return false;
        }
        if (index == size){
            return addAll(c);
        }
        Node<T> current = head;
        Node<T> prev = null;
        int count = 0;
        while(count < index){
            prev = current;
            current = current.next;
            count++;
        }

        for (T item : c) {
            Node<T> newNode = new Node<>(item);
            if (prev == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = current;
                prev.next = newNode;
            }
            prev = newNode;
            size++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Collection cannot be null");
        }
        boolean modified = false;
        for (Object item : c) {
            while(remove(item)){
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Collection cannot be null");
        }
        boolean modified = false;
        Node<T> current = head;
        Node<T> prev = null;

        while (current != null) {
            if (!c.contains(current.data)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                modified = true;
                current = (prev == null) ? head : prev.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        int count = 0;
        while (count < index) {
            current = current.next;
            count++;
        }
        return current.data;
    }

    @Override
    public T set(int index, T element) {
        if (element == null){
            throw new NullPointerException("Element cannot be null");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        int count = 0;
        while (count < index) {
            current = current.next;
            count++;
        }
        T oldData = current.data;
        current.data = element;
        return oldData;
    }

    @Override
    public void add(int index, T element) {
        if (element == null){
            throw new NullPointerException("Element cannot be null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            Node<T> prev = null;
            int count = 0;
            while (count < index) {
                prev = current;
                current = current.next;
                count++;
            }
            newNode.next = current;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node<T> current = head;
            Node<T> prev = null;
            int count = 0;
            while (count < index) {
                prev = current;
                current = current.next;
                count++;
            }
            removedData = current.data;
            prev.next = current.next;
        }
        size--;
        return removedData;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> current = head;
        int index = 0;
        while(current != null){
            if(Objects.equals(current.data, o)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> current = head;
        int index = -1;
        int currentIndex = 0;
        while(current != null){
            if(Objects.equals(current.data, o)){
                index = currentIndex;
            }
            current = current.next;
            currentIndex++;
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("ListIterator is not supported for CustomLinkedList");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("ListIterator is not supported for CustomLinkedList");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("SubList is not supported for CustomLinkedList");
    }


    private class CustomIterator implements Iterator<T> {
        private Node<T> current;

        public CustomIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException("No next element");
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}