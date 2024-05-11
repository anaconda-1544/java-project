package project4;

import java.util.Arrays;

public class ObjectArrayListLimitedCapacity {
    protected Object[] array;
    protected int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ObjectArrayListLimitedCapacity(int capacity) {
        array = new Object[capacity];
        size = 0;
    }
    
    // ArrayList의 크기를 반환합니다.
    public int size() {
        return size;
    }
    
    // 지정된 인덱스에 요소를 추가합니다.
    public void add(int index, Object o) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = o;
        size++;
    }
    
    // ArrayList가 비어 있는지 확인합니다.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // 지정된 인덱스의 요소를 반환합니다.
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }
    
    // ArrayList의 끝에 요소를 추가합니다.
    public void add(Object o) {
        add(size, o);
    }

    // 지정된 인덱스의 요소를 제거하고 반환합니다.
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
        return removedElement;
    }
    
    // 테스트 메소드
    public static void main(String[] args) {
        ObjectArrayListLimitedCapacity list = new ObjectArrayListLimitedCapacity(5);
        System.out.println("Is list empty? " + list.isEmpty());
        System.out.println("List size: " + list.size());

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("List after adding elements: " + Arrays.toString(list.array));
        System.out.println("List size: " + list.size());

        list.add(1, 15);
        System.out.println("List after adding 15 at index 1: " + Arrays.toString(list.array));
        System.out.println("List size: " + list.size());

        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("Removed element: " + list.remove(1));
        System.out.println("List after removing element at index 1: " + Arrays.toString(list.array));
        System.out.println("List size: " + list.size());
    }
}
