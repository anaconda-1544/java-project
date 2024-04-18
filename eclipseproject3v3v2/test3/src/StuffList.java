
class StuffList {
    private static Stuff[] stuffs = new Stuff[10]; // 초기 크기를 10으로 설정
    private static int size = 0; // 실제 저장된 Stuff 객체의 수

    public static void add(Stuff stuff) {
        if (size == stuffs.length) {
            Stuff[] newStuffs = new Stuff[stuffs.length * 2]; //가득차면 배열으 2배로
            System.arraycopy(stuffs, 0, newStuffs, 0, stuffs.length); //그리고 복붙
            stuffs = newStuffs;
            
        } 
//        System.out.println(size);
        stuffs[size++] = stuff;
    }

    public static void print() {
        if (size == 0) {
            System.out.println("Case1-2: Stuff List is empty");
        } else {
            System.out.println("Case1-2: Stuff List");
            for (int i = 0; i < size; i++) {
                Stuff stuff = stuffs[i];
                System.out.println("[" + stuff.getId() + "; " + stuff.getType() + "; " + stuff.getName() + "; " + stuff.getTag() + "]");
            }
        }
    }
}




/*import java.util.ArrayList;

public class StuffList {
    private static ArrayList<Stuff> stuffs; // 인스턴스 변수를 정적 변수로 변경

    public StuffList() {
        if (stuffs == null) {
            stuffs = new ArrayList<>();
        }
    }

    public static void add(Stuff stuff) { // 인스턴스 메소드를 정적 메소드로 변경
        if (stuffs == null) {
            stuffs = new ArrayList<>();
        }
        stuffs.add(stuff);
    }

    public static void print() { // 인스턴스 메소드를 정적 메소드로 변경
        if (stuffs == null) {
            stuffs = new ArrayList<>();
        }
        System.out.println("[00000001; exercise; ; ]\r\n"
        		+ "[00000002; food; dinner; ]\r\n"
        		+ "[00000003; room; class meeting; ]\r\n"
        		+ "[00000004; study; eclipse; ]\r\n"
        		+ "[00000005; storage; locker; ]\r\n"
        		+ "[00000006; ;basket; ]\r\n"
        		+ "[00000007;	;clock; ]\r\n"
        		+ "[00000008; ;tool; wrench: ]\r\n"
        		+ "[00000009; toolbox; my toolbox; ]"); 
        for (Stuff stuff : stuffs) {
            System.out.println(stuff.getId() + "; " + stuff.getType() + "; " + stuff.getName() + "; " + stuff.getTag());
        }
    }
}



/*
import java.util.ArrayList;

public class StuffList {
    private static ArrayList<Stuff> stuffs; // 인스턴스 변수를 정적 변수로 변경

    public StuffList() {
        if (stuffs == null) {
            stuffs = new ArrayList<>();
        }
    }

    public static void add(Stuff stuff) { // 인스턴스 메소드를 정적 메소드로 변경
        if (stuffs == null) {
            stuffs = new ArrayList<>();
        }
        stuffs.add(stuff);
    }

    public static void print() { // 인스턴스 메소드를 정적 메소드로 변경
        if (stuffs == null) {
            stuffs = new ArrayList<>();
        }
        System.out.println("Case1-2: Stuff List"); 
        for (Stuff stuff : stuffs) {
            stuff.print();
        }
    }
}


/*import java.util.ArrayList;


public class StuffList {
    private static ArrayList<Stuff> stuffs; // 인스턴스 변수를 정적 변수로 변경

    public StuffList() {
        if (stuffs == null) {
            stuffs = new ArrayList<>();
        }
    }

    public static void add(Stuff stuff) { // 인스턴스 메소드를 정적 메소드로 변경
        if (stuffs == null) {
            stuffs = new ArrayList<>();
        }
        stuffs.add(stuff);
    }
    
    private Stuff parseStuffInfo(String line) {
        String[] infoFields = line.replace(" ", " ").split("]");

        return new Stuff(infoFields);
    }
    
    
    public static void print() { // 인스턴스 메소드를 정적 메소드로 변경
        if (stuffs == null) {
            stuffs = new ArrayList<>();
        }
        System.out.println("Case1-2: Stuff List"); 
        for (Stuff stuff : stuffs) {
        	System.out.print(stuffs);
        }
    }
}
/* TODO 이 코드 참고해서 저걸 고치자
public void printResults() {
    System.out.println("Results:");
    for (String result : results) {
        System.out.println(result);
    }
}
*/


// TODO I should add this!!! :void StuffList.print() = make it to static!!!!