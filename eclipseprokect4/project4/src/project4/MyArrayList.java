package project4;

import java.util.Arrays;

public class MyArrayList<E> extends ObjectArrayListLimitedCapacity {
    public MyArrayList(int capacity) {
        super(capacity);
    }
    
    // Override the add method to ensure type safety
    @Override
    @SuppressWarnings("unchecked")
    public void add(Object o) {
        super.add(size, (E) o); // Use the add method from the parent class with size as index
    }

    // Method to return a subset of the ArrayList
    public MyArrayList<E> subset(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        MyArrayList<E> subsetList = new MyArrayList<>(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subsetList.add((E) super.get(i)); // It is safe to cast to type E here
        }
        return subsetList;
    }
    
    // 테스트 메소드
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Original list: " + Arrays.toString(list.array));
        System.out.println("List size: " + list.size());
        
        MyArrayList<Integer> subsetList = list.subset(1, 4);
        System.out.println("Subset list: " + Arrays.toString(subsetList.array));
        System.out.println("Subset list size: " + subsetList.size());
    }
}
