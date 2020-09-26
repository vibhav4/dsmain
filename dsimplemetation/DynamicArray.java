import java.util.Iterator;

public class DynamicArray implements Iterable<Integer>,Iterator<Integer> {

    private int[] array;
    private int DEFAULT_CAPACITY = 5;
    private int capacity;
    private int lastElementIndex = -1;
    private int loadfactor = 2;
    private int iteratorCount;

    public DynamicArray() {
        this.array = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public DynamicArray(int size) {
        this.array = new int[size];
        this.capacity = size;
    }

    public void add(int element) {
        lastElementIndex++;
        if (lastElementIndex + 1 > capacity) {
            int[] arrNew = new int[capacity * loadfactor];
            for (int i = 0; i < lastElementIndex; i++) {
                arrNew[i] = array[i];
            }
            this.array = arrNew;
            this.capacity = capacity;
            array[lastElementIndex] = element;
        } else {
            array[lastElementIndex] = element;
        }
    }

    public int size() {
        return lastElementIndex + 1;
    }

    public int get(int i) {
        return array[i];
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i <= lastElementIndex; i++) {
            output = output.append(":" + array[i] + ":");
        }
        return output.toString();
    }

    @Override
    public boolean hasNext() {
        if (iteratorCount <= lastElementIndex) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        iteratorCount++;
        return this.array[iteratorCount - 1];
    }

    @Override
    public void remove() {

    }

    @Override
    public Iterator<Integer> iterator() {
        this.iteratorCount = 0;
        return this;
    }

    // Run

    public static void main(String args[]) {

        DynamicArray dd = new DynamicArray();
        dd.add(3);
        dd.add(45);
        dd.add(66);
        dd.add(2);
        dd.add(23);
        dd.add(88);

        Iterator aa = dd.iterator();

        while (aa.hasNext()) {
            System.out.println("iteratir se - " + aa.next());
        }

        System.out.println(dd);

        System.out.println(dd.get(5));


    }
}