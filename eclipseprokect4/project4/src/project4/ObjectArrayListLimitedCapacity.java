package project4;

import java.util.Arrays;

public class ObjectArrayListLimitedCapacity {
    protected Object[] array;
    protected int size;

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
            throw new IndexOutOfBoundsException("인덱스: " + index + ", 크기: " + size);
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
            throw new IndexOutOfBoundsException("인덱스: " + index + ", 크기: " + size);
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
            throw new IndexOutOfBoundsException("인덱스: " + index + ", 크기: " + size);
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
        System.out.println("리스트 Empty 여부: " + list.isEmpty());
        System.out.println("리스트 크기: " + list.size());

        list.add(100);
        list.add(200);
        list.add(300);

        System.out.println("요소를 추가한 후의 리스트: " + Arrays.toString(list.array));
        System.out.println("리스트 크기: " + list.size());

        list.add(1, 150); //2번째 자리에 150 추가
        System.out.println("인덱스 1에 150를 추가한 후의 리스트: " + Arrays.toString(list.array));
        System.out.println("리스트 크기: " + list.size());

        System.out.println("인덱스 2의 요소: " + list.get(2));

        System.out.println("제거된 요소: " + list.remove(1));
        System.out.println("인덱스 1의 요소를 제거한 후의 리스트: " + Arrays.toString(list.array));
        System.out.println("리스트 크기: " + list.size());
    }
}
