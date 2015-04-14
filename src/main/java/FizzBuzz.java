import java.util.HashMap;

/**
 * Created by Gary Dickenson on 4/7/2015.
 */
public class FizzBuzz {
    private static HashMap<Integer, String> divisor_Word_Map;
    private int max_Len_Divisor_Word_list = 10;
    private static HashMap<Integer, String> include_Word_Map;
    private int max_Len_Include_Word_list = 5;
    private Boolean output_On_Division = Boolean.TRUE;
    private Boolean output_On_Include  = Boolean.FALSE;

    public FizzBuzz() {
        divisor_Word_Map = new HashMap<Integer, String>();
        divisor_Word_Map.put(  3, "Fizz");
        divisor_Word_Map.put(  5, "Buzz");
        divisor_Word_Map.put(3*5, "Fizzbuzz");

        include_Word_Map = new HashMap<Integer, String>();
        include_Word_Map.put(2, "Pip");
        include_Word_Map.put(5, "Pop");
    }

    public String evaluate(int inputNumber, int[] divisors) {
        String returnStr = String.valueOf(inputNumber);
        if(inputNumber < 3) return returnStr;
        if(divisors.length < 1 ) return returnStr;
        String delimiter = "";
        returnStr = "";
        for (int  i : divisors) {
            System.out.println("Divisor is : " + i);
            if(0 < i){
                if(0 == (inputNumber % i)){
                    returnStr += delimiter + divisor_Word_Map.get(i);
                    delimiter = "-";
                }
            }
        }
        if( 1 > returnStr.length()) returnStr = String.valueOf(inputNumber);
        return returnStr;
    }
}





