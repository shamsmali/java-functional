package com.shams.java.sess3;

import static fj.Show.optionShow;
import static fj.data.List.list;

import fj.F;
import fj.data.List;
import fj.data.Option;

import static fj.Show.intShow;
import static fj.Show.listShow;
import static fj.data.Option.some;


/**
 * Created by shams on 12/4/16.
 */

public class FP {

    public static void main(String[] args) {
        List<Integer> a = list(1, 2, 3).map(i -> i + 42);
        listShow(intShow).println(a);
        Option<Integer> s = some(12);

        optionShow(intShow).println(s.filter(i -> i == 12));

        F timesTwo = new F<String, String>() {
            @Override
            public String f(String o) {
                return o;
            }

        };

    }
}
