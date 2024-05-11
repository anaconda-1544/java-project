package project4;
import java.util.Arrays;

public class ObjectArrayListLimitedCapacity { //교수님의 조건에 맞게 만들기
	private Object[] array;
	private int size;
	private static final int DEFAULT_CAPACITY = 10; //10으로 고정하기!\
	
	public ObjectArrayListLimitedCapacity(int capacity) {
		array = new Object[capacity];
		size = 0;
	}
	
	public int size () {
		return size;
	}
	
	
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
    
	
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }
    
    
    
    public void add(Object o) {
        add(size, o);
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null; // 메모리 누수 때문에 필요
        size--;
        return removedElement;
    }
    
    
    // 테스트하게 하는 메소드
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