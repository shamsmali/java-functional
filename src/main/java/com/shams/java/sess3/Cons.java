package com.shams.java.sess3;

import java.util.function.Predicate;

/**
 * Created by shams on 12/11/16.
 */
public class Cons<T> implements List<T> {

    T head;
    List<T> tail;

    @Override
    public void tail(List t) {
        this.tail = t;
    }

    @Override
    public boolean exists(Predicate<T> p) {
        return p.test(head) ? true : this.tail.exists(p);
    }

    public Cons(T head, List<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return this.head;
    }

    @Override
    public List<T> tail() {
        return this.tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 1 + this.tail.length();
    }

    public static void main(String[] args) {
        List<String> ll = new Cons<>("Apple", new Cons<>("Banana", new Cons<>("Orange", new Nil<>())));
        System.out.println(ll.isEmpty() + " " + ll.length());

        ll.foreach(System.out::println);
        System.out.println();
        System.out.println();

        ll.map(s -> s.toUpperCase()).foreach(System.out::println);
        System.out.println();
        System.out.println();

        ll.reverse().foreach((System.out::println));
        System.out.println();
        System.out.println();

        ll.filter(s -> s.contains("e")).foreach(System.out::println);
        System.out.println();
        System.out.println(ll.foldLeft("", (s1, s2) -> s1 + "," + s2));


        List<Integer> nums = new Cons<>(1, new Cons<>(2, new Cons<>(3, new Cons<>(4, new Nil<>()))));

        System.out.println(nums.foldLeft(0, (n1, n2) -> n1 + n2));

        System.out.println("length " + nums.foldLeft(0, (n1, n2) -> n2 + 1));


        System.out.println();

        System.out.println(nums.foldRight(0, (n1, n2) -> n1 + n2));

        System.out.println();

        nums.take(2).foreach(System.out::println);
        System.out.println();

        nums.addToEnd(5).foreach(System.out::println);
        nums.take(4).foreach(System.out::println);

        System.out.println();
        System.out.println(ll.exists(i -> i.equalsIgnoreCase("Orange")));
    }
}
