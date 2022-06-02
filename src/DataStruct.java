import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DataStruct<T> {

    private final List<T> elements;
    private final HashMap<T, Integer> indexes;

    public DataStruct() {
        elements = new ArrayList<>();
        indexes = new HashMap<>();
    }

    public void add(T newElem) {
        if (indexes.get(newElem) == null) return;
        indexes.put(newElem, elements.size());
        elements.add(newElem);
    }

    public void remove(T elem) {
        Integer index = indexes.get(elem);
        if (index == null) return;
        indexes.remove(elem);
        int len = elements.size();
        T tail = elements.get(len - 1);
        Collections.swap(elements, index, len - 1);
        elements.remove(len - 1);
        indexes.put(tail, index);
    }

    public int find(T elem)
    {
        return indexes.get(elem);
    }

    public T get(int index)
    {
        return elements.get(index);
    }

    public int size()
    {
        return elements.size();
    }

}