package com.shams.java.sess3;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by shams on 12/11/16.
 */
public interface List<T> {

    T head();
    boolean isEmpty();
    int length();
    List<T> tail();
    void tail(List t);
    boolean exists(Predicate<T> p);

    default List<T> addToEnd(T t) {
        List curr = this;
        while (!curr.tail().isEmpty()) {
            curr = curr.tail();
        }
        curr.tail(new Cons(t, new Nil()));
        return this;
    }

    default <R> List<T> map(Function<T, R> fn) {
        if (this instanceof Cons) {
            return new Cons(fn.apply(this.head()), this.tail().map(fn));
        } else
            return new Nil();
    }

    default List<T> reverse() {
        Cons<T> curr = new Cons<T>(this.head(), new Nil<T>());

        List<T> next = tail();
        while (!next.isEmpty()) {
            curr = new Cons<T>(next.head(), curr);
            next = next.tail();
        }
        return curr;
    }

    default List<T> filter(Predicate<T> pf) {
        if (this instanceof Cons) {
            return pf.test(this.head()) ? new Cons<T>(this.head(), this.tail().filter(pf)) : this.tail().filter(pf);
        } else {
            return new Nil<T>();
        }
    }

    default void foreach(Consumer<T> consumer) {
        if (this instanceof Cons) {
            consumer.accept(this.head());
            this.tail().foreach(consumer);
        } else {
            // do nothing
        }
    }

    default <B> B foldLeft(B acc, TernaryF<T, B> mapr) {
        if (this instanceof Cons) {
            return this.tail().foldLeft(mapr.apply(this.head(), acc), mapr);
        } else {
            return acc;
        }
    }

    default <B> B foldRight(B acc, TernaryF<T, B> mapr) {
        if (this instanceof Cons) {
            return mapr.apply(this.head(), this.tail().foldRight(acc, mapr));
        } else {
            return acc;
        }
    }

    default List<T> take(int n) {

        List<T> c = new Nil<T>();
        List<T> curr = this;
        while (n-- > 0 && !curr.isEmpty()) {
            c = new Cons(curr.head(), c);
            curr = curr.tail();
        }
        return c.reverse();

    }
}
