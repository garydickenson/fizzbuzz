import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Gary Dickenson on 4/7/2015.
 */
public class FizzBuzz_UT {
    @Test
    public void testTrue() { assertTrue(true); }

//    @Test(expected =Exception.class) public void testTrueShouldFailForFalse() {assertTrue(false); }

    @Test
    public void ableToCreateObject(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        //System.out.println("Able to create");

    }
/*
    get Word list
    get in int in word list hash keys
    remove  key-String combo
    set new key-String combo
    test if maximum items set
    report number of additional divisors that can be set.
    test for zero, neg numbers, number 1


    */
    @Test
    public void ableToEvaluate(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        int[] divisors = new int[] {3,5};
        String evalResult = fizzBuzz.evaluate(15, divisors);
        System.out.println("Result : " + evalResult);
    }
}
