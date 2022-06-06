package com.example.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String[] args) throws IOException {

        // finite stream

//        // Stream.of
//        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
//        stream.map(String::toUpperCase).forEach(System.out::println);
//
//        // Stream.empty
//        Stream<String> emptyStream = Stream.empty();
//
//        // Arrays.stream
//        int[] numbers = {2, 3, 5, 7, 11, 13};
//        int r = Arrays
//                .stream(numbers).sum();
//        System.out.println(r);

//        infinite stream

//        Stream.iterate(0, n -> n + 1)
//                .filter(n -> n % 2 == 0)
//                .limit(10)
//                .forEach(System.out::println);

        // fibonnaci with iterate
//        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
////                .limit(100)
//                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
//

        long distinctWords=Files.lines(Paths.get("data.txt"), Charset.defaultCharset())
                .flatMap(line-> Arrays.stream(line.split(" ")) )
                .distinct()
                .count();
        System.out.println(distinctWords);

    }

}
