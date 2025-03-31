import java.util.*;

class MutableObject {
    String value;

    MutableObject(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        List<MutableObject> list = new ArrayList<>();
        list.add(new MutableObject("A"));
        list.add(new MutableObject("B"));
        Arrays.asList(3,5);
        List<MutableObject> unmodifiableList = Collections.unmodifiableList(list);


        // Attempt to modify an element inside the collections
        list.get(0).value = "Z";

        System.out.println("Unmodifiable List: " + unmodifiableList); // Reflects change: [Z, B]
      //  System.out.println("Immutable List: " + immutableList); // Reflects change: [Z, B]
    }
}
