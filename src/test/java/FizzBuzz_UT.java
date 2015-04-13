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

    @Test
    public void ableToEvaluate(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.evaluate(1);
    }
}
