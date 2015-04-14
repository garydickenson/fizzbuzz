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
    public void able_To_Create_Default(){
        System.out.println("Able to create, no parameter constructor");
        FizzBuzz fizzBuzz = new FizzBuzz();

    }
    @Test
    public void able_To_Create_Parametrized(){
        System.out.println("Able to create, parametrized constructor");
        FizzBuzz fizzBuzz = new FizzBuzz();
    }
    @Test public void able_To_Replace_Divisor_Word_List(){ }
    @Test public void able_To_Add_Divisor_Word_List_Item(){ }
    @Test public void able_To_Remove_Divisor_Word_List_Item(){ }
    @Test public void able_To_Replace_Divisor_Word_List_Item(){ }
/*
    get Word list
    get in int in word list hash keys
    remove  key-String combo
    set new key-String combo
    test if maximum items set
    report number of additional divisors that can be set.
    test for zero, neg numbers, number 1

    Design question how to deal with multiples?
    Do I require the client to set them,
    automatically create them and allow over-ride?
    Do automatically generated ones count against the max?


    */
    @Test
    public void ableToEvaluate(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        int[] divisors = new int[] {3,5};
        String evalResult = fizzBuzz.evaluate(15, divisors);
        System.out.println("Result : " + evalResult);
    }
}
