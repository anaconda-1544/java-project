	package project4;
	import java.util.ArrayList;
	import java.util.Arrays;
	
	public class MyArrayList<E> extends ObjectArrayListLimitedCapacity {
	    protected Object[] array;
	    protected int size; // 접근 제한자 변경
	
	    public MyArrayList(int capacity) {
	        super(capacity);
	    }
	    
	    // ArrayList의 subset을 반환하는 메소드
	    public MyArrayList<E> subset(int fromIndex, int toIndex) {
	        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
	            throw new IndexOutOfBoundsException();
	        }
	        MyArrayList<E> subsetList = new MyArrayList<>(toIndex - fromIndex);
	        for (int i = fromIndex; i < toIndex; i++) {
	            subsetList.add((E) array[i]);
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
	