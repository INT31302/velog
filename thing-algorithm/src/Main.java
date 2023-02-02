import java.util.*;


abstract class TestPerformance<T> {

    protected final int MAX_VALUE = 100000;

    abstract protected void add(T object);

    abstract protected void remove(T object);

    abstract protected void contains(T object);

    abstract protected void get(T object);

    abstract public void run();


    /**
     * functionName 조회 함수
     *
     * @return string
     */
    protected String getInheritanceMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    /**
     * 성능 측정 결과를 양식에 맞추는 함수
     *
     * @param methodName 실행 되고 있는 className
     * @param startTime  시작 시간
     * @param endTime    종료 시간
     * @return result
     */
    protected String testResultToString(String methodName, String collectionName, long startTime, long endTime) {
        return String.format("[%s] %s 실행 시간: %f 초", collectionName, methodName, (double) (endTime - startTime) / 1000000000);
    }

}

class ArrayPerformance extends TestPerformance<List<Integer>> {
    final ArrayList<Integer> arrayList = new ArrayList<>();
    final LinkedList<Integer> linkedList = new LinkedList<>();

    @Override
    protected void add(List<Integer> object) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MAX_VALUE; i++) {
            object.add(i);
        }
        long endTime = System.nanoTime();

        String methodName = getInheritanceMethodName();
        String collectionName = object.getClass().getSimpleName();
        System.out.println(testResultToString(methodName, collectionName, startTime, endTime));
    }

    @Override
    protected void remove(List<Integer> object) {
        Iterator<Integer> iterator = object.iterator();
        long startTime = System.nanoTime();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        long endTime = System.nanoTime();
        String methodName = getInheritanceMethodName();
        String collectionName = object.getClass().getSimpleName();
        System.out.println(testResultToString(methodName, collectionName, startTime, endTime));
    }

    @Override
    protected void contains(List<Integer> object) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MAX_VALUE; i++) {
            object.contains(i);
        }
        long endTime = System.nanoTime();

        String methodName = getInheritanceMethodName();
        String collectionName = object.getClass().getSimpleName();
        System.out.println(testResultToString(methodName, collectionName, startTime, endTime));
    }

    @Override
    protected void get(List<Integer> object) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MAX_VALUE; i++) {
            object.get(i);
        }
        long endTime = System.nanoTime();

        String methodName = getInheritanceMethodName();
        String collectionName = object.getClass().getSimpleName();
        System.out.println(testResultToString(methodName, collectionName, startTime, endTime));
    }

    /**
     * test 로직 실행
     */
    public void run() {
        add(arrayList);
        add(linkedList);
        get(arrayList);
        get(linkedList);
        contains(arrayList);
        contains(linkedList);
        remove(arrayList);
        remove(linkedList);
    }
}

class SetPerformance extends TestPerformance<Set<Integer>> {
    final Set<Integer> hashSet = new HashSet<>();
    final Set<Integer> treeSet = new TreeSet<>();

    @Override
    protected void add(Set<Integer> object) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MAX_VALUE; i++) {
            object.add(i);
        }
        long endTime = System.nanoTime();

        String methodName = getInheritanceMethodName();
        String collectionName = object.getClass().getSimpleName();
        System.out.println(testResultToString(methodName, collectionName, startTime, endTime));
    }

    @Override
    protected void remove(Set<Integer> object) {
        Iterator<Integer> iterator = object.iterator();
        long startTime = System.nanoTime();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        long endTime = System.nanoTime();
        String methodName = getInheritanceMethodName();
        String collectionName = object.getClass().getSimpleName();
        System.out.println(testResultToString(methodName, collectionName, startTime, endTime));
    }

    @Override
    protected void contains(Set<Integer> object) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MAX_VALUE; i++) {
            object.contains(i);
        }
        long endTime = System.nanoTime();

        String methodName = getInheritanceMethodName();
        String collectionName = object.getClass().getSimpleName();
        System.out.println(testResultToString(methodName, collectionName, startTime, endTime));
    }

    @Override
    protected void get(Set<Integer> object) {

    }

    /**
     * test 로직 실행
     */
    public void run() {
        add(treeSet);
        add(hashSet);
        contains(treeSet);
        contains(hashSet);
        remove(treeSet);
        remove(hashSet);
    }
}

class Test {


    public void run() {
        ArrayPerformance arrayPerformance = new ArrayPerformance();
        arrayPerformance.run();

        SetPerformance setPerformance = new SetPerformance();
        setPerformance.run();
    }

}

public class Main {

    public static void main(String[] args) {
        new Test().run();
    }
}