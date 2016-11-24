package com.shams.java.sess1;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class App {
    static BinaryOperator<Integer> sum = (a, b) -> a + b;
    static UnaryOperator<Integer> square = (a) -> a * a;
    static UnaryOperator<Integer> nothing = (a) -> a;
    static UnaryOperator<Integer> cube = (a) -> square.apply(a) * a;
    static Predicate<Integer> isEven = (a) -> a % 2 == 0;
    static Predicate<Integer> isOdd = isEven.negate();


    public static void main(String[] args) {

        // compute sum of squares
        IntStream.range(1, 10).map(square::apply).reduce(sum::apply).ifPresent(System.out::println);

        // compute sum of cubes
        IntStream.range(1, 10).map(cube::apply).reduce(sum::apply).ifPresent(System.out::println);

        System.out.println("Sum over numbers " + sumOfNumbers(nothing, 100));
        System.out.println("Sum of even numbers " + sumOfNumbers(nothing, 100, isEven));
        System.out.println("Sum of odd numbers " + sumOfNumbers(nothing, 100, isOdd));
        System.out.println("Sum over squares " + sumOfNumbers(square, 100));
        System.out.println("Sum over cubes   " + sumOfNumbers(cube, 100));

        System.out.println(isEven.test(2));
        System.out.println(isOdd.test(5));

    }

    public static Integer sumOfNumbers(UnaryOperator<Integer> func, int n) {
        return IntStream.range(0, n + 1).map(func::apply).reduce(sum::apply).getAsInt();
    }

    public static Integer sumOfNumbers(UnaryOperator<Integer> func, int n, Predicate<Integer> filter) {
        return IntStream.range(0, n + 1).filter(filter::test).map(func::apply).reduce(sum::apply).getAsInt();
    }

}
