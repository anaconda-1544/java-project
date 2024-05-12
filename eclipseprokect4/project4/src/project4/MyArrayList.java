package project4;

import java.util.Arrays;

public class MyArrayList<E> extends ObjectArrayListLimitedCapacity {
    public MyArrayList(int capacity) {
        super(capacity);
    }
    
    // add 메소드를 오버라이드하여 타입 안전성을 보장합니다.
    @Override
    public void add(Object o) {
        if (o == null || !(o.getClass().equals(Object.class))) {
            try {
                E item = (E) o; // 타입 체크
                super.add(size, item); // 부모 클래스의 add 메소드를 사용하여 인덱스 size에 추가합니다.
            } catch (ClassCastException e) {
                throw new IllegalArgumentException("무효한 오브젝트 타입");
            }
        } else {
            super.add(size, o);
        }
    }

    // ArrayList의 부분집합을 반환하는 메소드입니다.
    public MyArrayList<E> subset(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        MyArrayList<E> subsetList = new MyArrayList<>(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subsetList.add((E) super.get(i)); // 여기서 E 타입으로 캐스팅하여 안정성을 높임
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
        System.out.println("원본 리스트: " + Arrays.toString(list.array));
        System.out.println("리스트 크기: " + list.size());
        
        MyArrayList<Integer> subsetList = list.subset(1, 4);
        System.out.println("부분 리스트: " + Arrays.toString(subsetList.array));
        System.out.println("부분 리스트 크기: " + subsetList.size());
    }
}
