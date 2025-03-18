import java.util.ArrayList;

public class GenericCollection<T> {
    private ArrayList<T> elements;

    public GenericCollection() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public void remove(int i) {
        if (i < 0 || i >= elements.size()) {
            System.out.println("Index out of bounds");
            return;
        }
        elements.remove(i);
    }

    public T get(int i) {
        if (i < 0 || i >= elements.size()) {
            System.out.println("Index out of bounds");
            return null;
        }
        return elements.get(i);
    }

    public int size() {
        return elements.size();
    }

    public void printAll() {
        for (T element : elements) {
            System.out.println(element);
        }
    }
}
