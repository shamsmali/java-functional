package com.shams.java.sess2;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by shams on 12/3/16.
 */
public class OptionalExample {

    public static void main(String[] args) {

        Optional<String> os = Optional.of("Shams Mali");
        // alternative for returning null
        someMethod("hello").ifPresent(someConsumer());

        // avoid using if else instead use Optional.orElse
        if ("some".equalsIgnoreCase("sh")) {
            System.out.println("fff");
        } else {
            System.out.println("eee");
        }
        // if doesnt contain then return not found. This good alter native for if else
        someMethod("shams").orElse("not found");

        os.ifPresent(someConsumer());


        // in case you want to get the value from some external system
        someMethod("shams").orElseGet(someSupplier());

        // simply get the value from the method

        someMethod("sh").get();

        // apply filter or map
        someMethod("sh").map(s -> s.toUpperCase());
        someMethod("sh").filter(s -> s.contains("sh")).ifPresent(someConsumer());


        // in case if you want throw exception
        someMethod("shams").orElseThrow(() -> new IllegalArgumentException("value not found"));


    }

    public static Supplier<String> someSupplier() {
        return () -> "some value";
    }

    public static Consumer<String> someConsumer() {
        return (s -> System.out.println(s));
    }

    public static Optional<String> someMethod(String dd) {
        if (dd.equalsIgnoreCase("sh")) {
            return Optional.of("shams");
        }

        return Optional.empty();
    }
}
