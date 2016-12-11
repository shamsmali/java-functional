package com.shams.java.sess3;

import java.util.function.Predicate;

/**
 * Created by shams on 12/11/16.
 */
public class Nil<T> implements List<T> {
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public List<T> tail() {
        return this;
    }

    @Override
    public boolean exists(Predicate<T> p) {
        return false;
    }

    @Override
    public void tail(List t) {
        throw new RuntimeException("no such method");
    }

    @Override
    public T head() {
        throw new RuntimeException("no such method");
    }

    @Override
    public int length() {
        return 0;
    }
}
