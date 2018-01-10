package com.xyzcorp;

import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;

public class LambdaDieTest {

    @Test
    public void testLambdaDie() {
        //Function x -> x +_1
        //Supplier () -> x
        //Consumer x -> ()
        //Predicate x -> (true | false)
        LambdaDie lambdaDie = new LambdaDie(() -> 4);
    }

    @Test
    public void testLambdaDieIntegration() {
        //Function x -> x +_1
        //Supplier () -> x
        //Consumer x -> ()
        //Predicate x -> (true | false)
        Random random = new Random();
        LambdaDie lambdaDie = new LambdaDie(() -> random.nextInt(6) + 1);
    }

}
