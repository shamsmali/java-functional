package com.shams.java.sess3;

/**
 * Created by shams on 12/10/16.
 */
public class Node<T> implements MyList<T> {

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T head() {
        return this.head;
    }

    @Override
    public int size() {
        return 1 + this.tail.size();
    }

    @Override
    public MyList<T> tail() {
        return this.tail;
    }

    @Override
    public MyList<T> add(T t) {
        return new Node(t, this);
    }

    @Override
    public MyList<T> addToTail(T t) {

        // find tail
        MyList c = this;
        while (!c.tail().isEmpty()) {
            c = c.tail();
        }
        ((Node)c).tail = new Node<T>(t, new Empty<T>());
        return this;
    }

    T head;
    MyList<T> tail;

    public Node(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }


    public static void main(String[] args) {
        MyList<String> node = new Node<>("shams", new Empty<>());
        node = node.add("mali").add("megha");

        node.addToTail("good").addToTail("husband").addToTail("wife");

        System.out.println(node.isEmpty());
        System.out.println(node.size());

        node.foreach(System.out::println);
        System.out.println();


        node.map((String r) -> r.toUpperCase()).foreach(System.out::println);
        System.out.println();

        node.filter((String s) -> s.contains("m")).foreach(System.out::println);
        System.out.println();

        node.reverse().foreach(System.out::println);


        System.out.println(node.foldLeft("", (s1, s2) -> s1 + " " + s2));

        MyList<Integer> ints = new Node<>(50, new Empty<>());
        ints = ints.add(10).add(20).add(30);
        System.out.println(ints.sum(ints));

        System.out.println(ints.foldLeft(0, (a1, a2) -> a1 + a2));

    }
}
