//class MyResource implements AutoCloseable {
//    public void close() {
//        throw new RuntimeException("Exception in close()");
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        try (MyResource res = new MyResource()) {
//            throw new RuntimeException("Exception in try");
//        }
//    }
//}


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> l = Arrays.asList(3,5,5,6);
        l.add(23);
        l.forEach(System.out::println);

//        integerList
//                .stream()
//                .filter(e->e>10).findFirst()
//                .or(()-> Optional.of(1)).ifPresentOrElse(System.out::println,
//                        ()->System.out.println("Value doesn't exists"));
    }
}




