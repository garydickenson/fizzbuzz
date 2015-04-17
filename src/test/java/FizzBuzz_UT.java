import org.junit.Test;

import java.util.TreeMap;
import java.util.TreeMap;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gary Dickenson on 4/7/2015.
 */
public class FizzBuzz_UT {
    @Test
    public void testTrue() { assertTrue(true); }

//    @Test(expected =Exception.class) public void testTrueShouldFailForFalse() {assertTrue(false); }

    public Boolean compare_TreeMaps(TreeMap<Integer, String> hm1, TreeMap<Integer, String> hm2){
        if(hm1.size() != hm2.size()) {
            return Boolean.FALSE;
        }
        for (final int key : hm1.keySet()) {
            if (hm2.containsKey(key)) {
                if(hm1.get(key) != hm2.get(key)){
                    return Boolean.FALSE;
                }
            }
            else{
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Test
    public void able_To_Create_Default(){
        TreeMap<Integer, String> divisor_Word_List;
        FizzBuzz fizzBuzz = new FizzBuzz();

    }
    @Test
    public void able_To_Create_Parametrized(){
        FizzBuzz fizzBuzz;
        Boolean output_On_Division = Boolean.FALSE;
        Boolean output_On_Include  = Boolean.TRUE;
        TreeMap<Integer, String> divisor_Word_List;
        divisor_Word_List = new TreeMap<>();
        divisor_Word_List.put(  3, "Fizz2");
        divisor_Word_List.put(  5, "Buzz2");

        TreeMap<Integer, String> include_Word_Map;
        include_Word_Map = new TreeMap<>();
        include_Word_Map.put(2, "Pip2");
        include_Word_Map.put(5, "Pop2");

        fizzBuzz = new FizzBuzz(divisor_Word_List, output_On_Division, include_Word_Map, output_On_Include);
        assertFalse(fizzBuzz.isOutput_On_Division());
        assertTrue(fizzBuzz.isOutput_On_Include());
        assertTrue(this.compare_TreeMaps(divisor_Word_List, fizzBuzz.getDivisor_Word_List()));
        assertTrue(this.compare_TreeMaps(include_Word_Map, fizzBuzz.getInclude_Word_List()));
    }
    @Test public void able_To_Get_And_Set_Delimiter() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String new_Delimiter = ":";
        fizzBuzz.setDelimiter(new_Delimiter);
        assertTrue(fizzBuzz.getDelimiter().equals(new_Delimiter));
        new_Delimiter = "+";
        fizzBuzz.setDelimiter(new_Delimiter);
        assertTrue(fizzBuzz.getDelimiter().equals(new_Delimiter));
        new_Delimiter = "#";
        fizzBuzz.setDelimiter(new_Delimiter);
        assertTrue(fizzBuzz.getDelimiter().equals(new_Delimiter));
    }
    @Test public void able_To_Set_Output_On_Division(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.setOutput_On_Division(Boolean.TRUE);
        assertTrue(fizzBuzz.isOutput_On_Division());
        fizzBuzz.setOutput_On_Division(Boolean.FALSE);
        assertFalse(fizzBuzz.isOutput_On_Division());
    }
    @Test public void able_To_Set_Output_On_Include(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.setOutput_On_Include(Boolean.TRUE);
        assertTrue(fizzBuzz.isOutput_On_Include());
        fizzBuzz.setOutput_On_Include(Boolean.FALSE);
        assertFalse(fizzBuzz.isOutput_On_Include());
    }
    @Test public void able_To_Get_Divisor_Word_List(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> divisor_Word_List = new TreeMap<>();
        divisor_Word_List.put(5, "Buzz");
        divisor_Word_List.put(3, "Fizz");
//Test that it gets sorted
//TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(divisor_Word_List);
        fizzBuzz.setDivisor_Word_List(divisor_Word_List);
        assertTrue(this.compare_TreeMaps(divisor_Word_List, fizzBuzz.getDivisor_Word_List()));
    }

    @Test public void able_To_Get_Full_Divisor_List(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> divisor_Word_List = new TreeMap<>();
        divisor_Word_List.put(3, "Fizz");
        divisor_Word_List.put(5, "Buzz");
        fizzBuzz.setDivisor_Word_List(divisor_Word_List);
        TreeMap<Integer, String> divisor_Word_List = new TreeMap<>();
        divisor_Word_List.put(35, "Fizz_Buzz");
        assertTrue(this.compare_TreeMaps(divisor_Word_List, fizzBuzz.getFull_Divisor_List()));

        //Add some individual words and test again
        fizzBuzz.setDivisor_Word(11, "Pep");
        divisor_Word_List.put(3 * 11, "Fizz_Pep");
        divisor_Word_List.put(5 * 11, "Buzz_Pep");
        assertTrue(this.compare_TreeMaps(divisor_Word_List, fizzBuzz.getFull_Divisor_List()));

        fizzBuzz.setDivisor_Word(8, "Pop");
        divisor_Word_List.put(3 * 8, "Fizz_Pop");
        divisor_Word_List.put(5*8, "Buzz_Pop");
        divisor_Word_List.put(11*8, "Pop_Buzz");
        assertTrue(this.compare_TreeMaps(divisor_Word_List, fizzBuzz.getFull_Divisor_List()));

        fizzBuzz.setDivisor_Word(7, "Fuzz");
        divisor_Word_List.put(3*7, "Fizz_Fuzz");
        divisor_Word_List.put(5*7, "Buzz_Fuzz");
        divisor_Word_List.put(8*7, "Fuzz_Buzz");
        divisor_Word_List.put(11*7, "Pop_Fuzz");
        assertTrue(this.compare_TreeMaps(divisor_Word_List, fizzBuzz.getFull_Divisor_List()));


    }
    @Test public void able_To_Get_Divisor_Word(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertTrue("Buzz" == fizzBuzz.getDivisor_Word(5));
    }
    @Test public void able_To_Get_Divisor_Word_List_Length(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        for (int j = 3; j < 7; j++) {
            Word_List.put(j, "Buzz");
            fizzBuzz.setDivisor_Word_List(Word_List);
            assertTrue(Word_List.size() == fizzBuzz.get_Length_divisor_Word_List());
        }
        String add_Word = "Fuzz";
        Word_List.clear();
        fizzBuzz.setDivisor_Word_List(Word_List);
        for (int j = 8; j < 11; j++) {
            Word_List.put(j, add_Word);
            fizzBuzz.setDivisor_Word(j, add_Word);
            assertTrue(Word_List.size() == fizzBuzz.get_Length_divisor_Word_List());
        }
    }
    @Test public void able_To_Get_Divisor_Word_List_Available_Space(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        for (int j = 0; j < fizzBuzz.getMax_Length_Divisor_Word_List(); j++) {
            Word_List.put(j+fizzBuzz.getMin_Divisor_Word_key(), "Huzz"+j);
            fizzBuzz.setDivisor_Word_List(Word_List);
            assertTrue((fizzBuzz.getMax_Length_Divisor_Word_List()-fizzBuzz.getDivisor_Word_List().size()) == fizzBuzz.get_Space_divisor_Word_List());
        }
    }
    @Test public void able_To_Replace_Divisor_Word_List(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        for (int j = 0; j < fizzBuzz.getMax_Length_Divisor_Word_List()+5; j++) {
            Word_List.put(j + fizzBuzz.getMin_Divisor_Word_key(), "Buzz2");
            if(Word_List.size() <= fizzBuzz.getMax_Length_Divisor_Word_List()) {
                fizzBuzz.setDivisor_Word_List(Word_List);
                assertTrue(this.compare_TreeMaps(Word_List, fizzBuzz.getDivisor_Word_List()));
            }
            else{
                // expect it to fail
                Boolean success = Boolean.FALSE;
                try {
                    fizzBuzz.setDivisor_Word_List(Word_List);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    //This is good, correct behavior
                    success = Boolean.TRUE;
                }
                assertTrue(success);
            }
        }
    }

    @Test public void not_able_To_Replace_With_Invalid_Divisor_Word_List(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        Word_List.put(fizzBuzz.getMin_Divisor_Word_key()-1, "Invalid");
        // Expect it to Fail
        Boolean success = Boolean.FALSE;
        try{
            fizzBuzz.setDivisor_Word_List(Word_List);
        }
        catch(ArrayIndexOutOfBoundsException e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        Word_List.clear();
        Word_List.put(fizzBuzz.getMax_Divisor_Word_key()+1, "Invalid");
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setDivisor_Word_List(Word_List);
        }
        catch(ArrayIndexOutOfBoundsException e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        Word_List.clear();
        Word_List.put(fizzBuzz.getMin_Divisor_Word_key(), "");
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setDivisor_Word_List(Word_List);
        }
        catch(Exception e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        Word_List.clear();
        Word_List.put(fizzBuzz.getMin_Divisor_Word_key(), "Way_Too_Long......");
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setDivisor_Word_List(Word_List);
        }
        catch(Exception e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }
    @Test public void able_To_Add_Divisor_Word(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        fizzBuzz.setDivisor_Word_List(Word_List);

        for (int j = 0; j < fizzBuzz.getMax_Length_Divisor_Word_List()+5; j++) {
            int key = j+fizzBuzz.getMin_Divisor_Word_key();
            Word_List.put(key, "Buzz2");
            if(Word_List.size() <= fizzBuzz.getMax_Length_Divisor_Word_List()) {
                fizzBuzz.setDivisor_Word(key, Word_List.get(key));
                assertTrue(this.compare_TreeMaps(Word_List, fizzBuzz.getDivisor_Word_List()));
            }
            else{
                // expect it to fail
                Boolean success = Boolean.FALSE;
                try {
                    fizzBuzz.setDivisor_Word(key, Word_List.get(key));
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    //This is good, correct behavior
                    success = Boolean.TRUE;
                }
                assertTrue(success);
            }
        }
    }
    @Test public void not_able_To_Add_Invalid_Divisor_Word(){
        System.out.println("Able to not_able_To_Add_Invalid_Divisor_Word");
        FizzBuzz fizzBuzz = new FizzBuzz();
        // Expect it to Fail
        Boolean success = Boolean.FALSE;
        try{
            fizzBuzz.setDivisor_Word(4, "");
        }
        catch(Exception e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setDivisor_Word(0, "Way_Too_Long");
        }
        catch(Exception e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }
    @Test public void not_able_To_Add_Invalid_Divisor_Number(){
        System.out.println("Able to not_able_To_Add_Invalid_Divisor_Number");
        FizzBuzz fizzBuzz = new FizzBuzz();
        // Expect it to Fail
        Boolean success = Boolean.FALSE;
        try{
            fizzBuzz.setDivisor_Word(0, "Invalid");
        }
        catch(ArrayIndexOutOfBoundsException e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setDivisor_Word(2, "Invalid");
        }
        catch(ArrayIndexOutOfBoundsException e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setDivisor_Word(20, "Invalid");
        }
        catch(ArrayIndexOutOfBoundsException e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }
    @Test public void able_To_Remove_Divisor_Word(){
        System.out.println("Able to able_To_Remove_Divisor_Word");
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.remove_Divisor_Word(3);
        TreeMap<Integer, String> divisor_Word_List = new TreeMap<>();
        divisor_Word_List.put(5, "Buzz");
        assertTrue(this.compare_TreeMaps(divisor_Word_List, fizzBuzz.getDivisor_Word_List()));
    }
    @Test public void able_To_Replace_Divisor_Word(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> word_List = fizzBuzz.getDivisor_Word_List();
        for (final int key : word_List.keySet()) {
            String new_Word = word_List.get(key)+key;
            fizzBuzz.replace_Divisor_Word(key, new_Word);
            word_List.put(key, new_Word);
            assertTrue(this.compare_TreeMaps(word_List, fizzBuzz.getDivisor_Word_List()));
        }


    }

    @Test public void able_To_Get_Include_Word_List(){
        System.out.println("Able to able_To_Get_Include_Word_List");
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        Word_List.put(2, "Pip");
        Word_List.put(7, "Pop");
        fizzBuzz.setInclude_Word_List(Word_List);
        assertTrue(this.compare_TreeMaps(Word_List, fizzBuzz.getInclude_Word_List()));
    }
    @Test public void able_To_Get_Include_Word(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertTrue("Pop" == fizzBuzz.getInclude_Word(5));
    }
    @Test public void able_To_Get_Include_Word_List_Length(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        int k = 0;
        for (int j = 0; j < 4; j++) {
            k++;
            Word_List.put(j + fizzBuzz.getMin_Include_Word_key(), "Buzz2");
            fizzBuzz.setInclude_Word_List(Word_List);
            int a =Word_List.size();
            int b = fizzBuzz.get_Length_Include_Word_List();
            assertTrue(Word_List.size() == fizzBuzz.get_Length_Include_Word_List());
        }
        for (int j = k; j < fizzBuzz.getMax_Length_Include_Word_List(); j++) {
            String add_Word = "Pop"+j;
            Word_List.put(j, add_Word);
            fizzBuzz.setInclude_Word(j, add_Word);
            assertTrue(Word_List.size() == fizzBuzz.get_Length_Include_Word_List());
        }
    }
    @Test public void able_To_Get_Include_Word_List_Available_Space(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        for (int j = fizzBuzz.getMin_Include_Word_key(); j < fizzBuzz.getMax_Include_Word_key(); j++) {
            Word_List.put(j, "Pup");
            fizzBuzz.setInclude_Word_List(Word_List);
            assertTrue((fizzBuzz.getMax_Length_Include_Word_List() - fizzBuzz.getInclude_Word_List().size()) == fizzBuzz.get_Space_Include_Word_List());
        }
    }
    @Test public void able_To_Replace_Include_Word_List(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        for (int j = 0; j < fizzBuzz.getMax_Length_Include_Word_List()+5; j++) {
            Word_List.put(j + fizzBuzz.getMin_Include_Word_key(), "Pop2"+j);
            if(Word_List.size() <= fizzBuzz.getMax_Length_Include_Word_List()) {
                fizzBuzz.setInclude_Word_List(Word_List);
                assertTrue(this.compare_TreeMaps(Word_List, fizzBuzz.getInclude_Word_List()));
            }
            else{
                // expect it to fail
                Boolean success = Boolean.FALSE;
                try {
                    fizzBuzz.setInclude_Word_List(Word_List);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    //This is good, correct behavior
                    success = Boolean.TRUE;
                }
                assertTrue(success);
            }
        }
    }
    @Test public void not_able_To_Replace_With_Invalid_Include_Word_List(){
        System.out.println("Able to not_able_To_Replace_With_Invalid_Include_Word_List");
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        Word_List.put(fizzBuzz.getMin_Include_Word_key()-1, "Invalid");
        // Expect it to Fail
        Boolean success = Boolean.FALSE;
        try{
            fizzBuzz.setInclude_Word_List(Word_List);
        }
        catch(ArrayIndexOutOfBoundsException e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        Word_List.clear();
        Word_List.put(fizzBuzz.getMax_Include_Word_key()+1, "Invalid");
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setInclude_Word_List((Word_List));
        }
        catch(ArrayIndexOutOfBoundsException e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        Word_List.clear();
        Word_List.put(fizzBuzz.getMin_Include_Word_key(), "");
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setInclude_Word_List((Word_List));
        }
        catch(Exception e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        Word_List.clear();
        Word_List.put(fizzBuzz.getMin_Include_Word_key(), "Way_Too_Long........");
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setInclude_Word_List((Word_List));
        }
        catch(Exception e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }
    @Test public void able_To_Add_Include_Word(){
        //test out of bounds
        System.out.println("Able to able_To_Add_Include_Word");
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> Word_List = new TreeMap<>();
        fizzBuzz.setInclude_Word_List(Word_List);

        for (int j = 1; j < fizzBuzz.getMax_Length_Include_Word_List()+5; j++) {
            int key = j+fizzBuzz.getMin_Include_Word_key();
            Word_List.put(key, "Pop2");
            if(Word_List.size() <= fizzBuzz.getMax_Length_Include_Word_List()) {
                fizzBuzz.setInclude_Word(key, Word_List.get(key));
                assertTrue(this.compare_TreeMaps(Word_List, fizzBuzz.getInclude_Word_List()));
            }
            else{
                // expect it to fail
                Boolean success = Boolean.FALSE;
                try {
                    fizzBuzz.setInclude_Word(key, Word_List.get(key));
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    //This is good, correct behavior
                    success = Boolean.TRUE;
                }
                assertTrue(success);
            }
        }
    }
    @Test public void not_able_To_Add_Invalid_Include_Word(){
        System.out.println("Able to not_able_To_Add_Invalid_Include_Word");
        FizzBuzz fizzBuzz = new FizzBuzz();
        // Expect it to Fail
        Boolean success = Boolean.FALSE;
        try{
            fizzBuzz.setInclude_Word(fizzBuzz.getMin_Include_Word_key(), "");
        }
        catch(Exception e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setInclude_Word(fizzBuzz.getMin_Include_Word_key(), "Way_Too_Long");
        }
        catch(Exception e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }
    @Test public void not_able_To_Add_Invalid_Include_Number(){
        System.out.println("Able to not_able_To_Add_Invalid_Include_Number");
        FizzBuzz fizzBuzz = new FizzBuzz();
        // Expect it to Fail
        Boolean success = Boolean.FALSE;
        try{
            fizzBuzz.setInclude_Word(fizzBuzz.getMin_Include_Word_key()-1, "Invalid");
        }
        catch(ArrayIndexOutOfBoundsException e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
        // Expect it to Fail
        success = Boolean.FALSE;
        try{
            fizzBuzz.setInclude_Word(fizzBuzz.getMax_Include_Word_key()+1, "Invalid");
        }
        catch(ArrayIndexOutOfBoundsException e){
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }
    @Test public void able_To_Remove_Include_Word(){
        System.out.println("Able to able_To_Remove_Include_Word");
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.remove_Include_Word(2);
        TreeMap<Integer, String> include_Word_List = new TreeMap<>();
        include_Word_List.put(5, "Pop");
        assertTrue(this.compare_TreeMaps(include_Word_List, fizzBuzz.getInclude_Word_List()));
    }
    @Test public void able_To_Replace_Include_Word(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> word_List = fizzBuzz.getInclude_Word_List();
        for (final int key : word_List.keySet()) {
            String new_Word = word_List.get(key)+key;
            fizzBuzz.replace_Include_Word(key, new_Word);
            word_List.put(key, new_Word);
            assertTrue(this.compare_TreeMaps(word_List, fizzBuzz.getInclude_Word_List()));
        }
    }
    @Test
    public void ableToEvaluate() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        TreeMap<Integer, String> test_Data = new TreeMap<>();
        test_Data.put(1, "1");
        test_Data.put(3, "Fizz");
        test_Data.put(5, "Buzz");
        test_Data.put(15, "14");
        test_Data.put(15, "Fizz-Buzz");
        for (final int key : test_Data.keySet()) {
            System.out.print(key + " : " +test_Data.get(key));
            assertTrue(fizzBuzz.evaluate(15).equals(test_Data.get(key)));
            System.out.println("  Pass");
        }
    }
}
