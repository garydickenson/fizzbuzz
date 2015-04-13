import java.util.HashMap;

/**
 * Created by Gary Dickenson on 4/7/2015.
 */
public class FizzBuzz {
    private static HashMap<Integer, String> outputWordList = new HashMap<>();
//        h.put(1, 1000);
//        h.put(20, 1001);
    public FizzBuzz() {
        outputWordList.put(3, "Fizz");
        outputWordList.put(5, "Buzz");
    }

    public String evaluate(int inputNumber, int[] divisors) {
        String returnStr = String.valueOf(inputNumber);
        if(inputNumber < 3) return returnStr;
        if(divisors.length < 1 ) return returnStr;
        String delimitor = "";
        returnStr = "";
        for (int  i : divisors) {
            System.out.println("Divisor is : " + i);
            if(0 < i){
                if(0 == (inputNumber % i)){
                    returnStr += delimitor + outputWordList.get(i);
                    delimitor = "-";
                }
            }
        }
        if( 1 > returnStr.length()) returnStr = String.valueOf(inputNumber);
        return returnStr;
    }
}





