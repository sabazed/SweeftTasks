package Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DataStruct<T> {

    // List for having indexed elements
    private final List<T> elements;
    // HashMap for getting indexes in O(1)
    private final HashMap<T, Integer> indexes;

    public DataStruct() {
        elements = new ArrayList<>();
        indexes = new HashMap<>();
    }

    // Adding element to the list
    public void add(T newElem) {
        if (indexes.get(newElem) == null) return;
        indexes.put(newElem, elements.size());
        elements.add(newElem);
    }

    // Removing element in O(1)
    public void remove(T elem) {
        Integer index = indexes.get(elem);
        // If the element doesn't exist terminate
        if (index == null) return;
        // Remove the element
        indexes.remove(elem);
        elements.remove(elem);
        // Swap the places of the last index and the removed index
        int len = elements.size();
        T tail = elements.get(len - 1);
        Collections.swap(elements, index, len - 1);
        elements.remove(len - 1);
        // Update the swapped index in the map
        indexes.put(tail, index);

        // NO ITERATIONS NEEDED ALL IS DONE IN O(1)!
    }

    // Get index of the element
    public int find(T elem)
    {
        return indexes.get(elem);
    }

    // Get element by index
    public T get(int index)
    {
        return elements.get(index);
    }

    // Return the size of the data
    public int size()
    {
        return elements.size();
    }

}