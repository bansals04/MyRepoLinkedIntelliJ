package Test;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void streamT1(){

        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println(l1);

        //Way 1: create a stream object. apply some filter and condition in it.
        Stream<Integer> s = l1.stream();
        List<Integer> l3=  s.filter(val1 -> val1%2 == 0).collect(Collectors.toList());
        System.out.println(l3);

        //Way 2: do above work in single line.
        List<Integer> l2 =  l1.stream().filter(val -> val>4).collect(Collectors.toList());
        System.out.println(l2);

        //Create a empty stream. Below forEach will print nothing because em is empty.
        Stream<Object> em = Stream.empty();
        em.forEach(e1 -> System.out.println(e1));

        // Way1: to fatch from array, we need to use Stream.of() method
        String[] names = {"Aayansh", "Shubhi", "Chirag", "Baby", "Shashi"};
        Stream<String> stringStream = Stream.of(names);
        stringStream.forEach(a1 -> System.out.println(a1));

        // Way2: to fatch from array, we need to use Stream.of() method
        Stream<String> ss= Stream.of("Hello", "How", "Are", "You");
        ss.forEach(eachWord -> System.out.print(eachWord + " "));

        //Way-3 with Integer arrays
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        Set<Integer> mm = integerStream.filter(i -> i%2!=0).collect(Collectors.toSet());
        System.out.println(mm);

        IntStream intStream= Arrays.stream(new int[] {22,67,78,45,23});
        intStream.forEach(ii -> System.out.println(ii));

    }
}
