import java.util.TreeMap;

/**
 * Created by Gary Dickenson on 4/7/2015.
 */
public class FizzBuzz {
    private TreeMap<Integer, String> divisor_Word_List;
    private int max_Length_Divisor_Word_List = 10;
    private TreeMap<Integer, String> include_Word_List;
    private int max_Length_Include_Word_List = 8;
    private Boolean output_On_Division = Boolean.TRUE;
    private Boolean output_On_Include  = Boolean.FALSE;
    private int min_Divisor_Word_Key = 3;
    private int max_Divisor_Word_Key = 19;
    private int min_Include_Word_Key = 1;
    private int max_Include_Word_Key = 9;
    private String delimiter = "-";
    private TreeMap<Integer, String> full_Divisor_List;

    public TreeMap<Integer, String> getDivisor_Word_List() {return this.divisor_Word_List;}
    public void setDivisor_Word_List(TreeMap<Integer, String> Word_List) {
        for (final int key : Word_List.keySet()) {
            setDivisor_Word(key, Word_List.get(key));
        }
    }
    public TreeMap<Integer, String> getInclude_Word_List() {return include_Word_List;}
    public void setInclude_Word_List(TreeMap<Integer, String> Word_List) {
        for (final int key : Word_List.keySet()) {
            if((this.min_Include_Word_Key>key) || (this.max_Include_Word_Key<key)){
                throw new ArrayIndexOutOfBoundsException();
            }
            if((this.getMin_Word_Length()>Word_List.get(key).length()) || (this.getMax_Word_Length()<Word_List.get(key).length())){
                // this should be a different Exception type.
                throw new ArrayIndexOutOfBoundsException();
            }
        }
        if(Word_List.size() <= this.getMax_Length_Include_Word_List()){
            this.include_Word_List = (TreeMap<Integer, String>) Word_List.clone();
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public Boolean isOutput_On_Division() {return this.output_On_Division;}
    public void setOutput_On_Division(Boolean output_On_Division) {this.output_On_Division = output_On_Division;}
    public Boolean isOutput_On_Include() {return this.output_On_Include;}
    public void setOutput_On_Include(Boolean output_On_Include) {this.output_On_Include = output_On_Include;}
    public int getMax_Length_Divisor_Word_List() {return this.max_Length_Divisor_Word_List;}
    public int getMax_Length_Include_Word_List() {return this.max_Length_Include_Word_List;}
    public int get_Length_divisor_Word_List() {return this.divisor_Word_List.size();}
    public int get_Length_Include_Word_List() {return this.include_Word_List.size();}
    public int get_Space_divisor_Word_List() {return this.getMax_Length_Divisor_Word_List()-this.divisor_Word_List.size();}
    public int get_Space_Include_Word_List() {return this.getMax_Length_Include_Word_List()-this.include_Word_List.size();}
    public int getMin_Divisor_Word_key() {return this.min_Divisor_Word_Key;}
    public int getMax_Divisor_Word_key() {return this.max_Divisor_Word_Key;}
    public int getMin_Include_Word_key() {return this.min_Include_Word_Key;}
    public int getMax_Include_Word_key() {return this.max_Include_Word_Key;}
    public int getMax_Word_Length() {return 11;}
    public int getMin_Word_Length() {return 1;}
    public String getDelimiter() {return this.delimiter;}
    public void setDelimiter(String delimiter) {this.delimiter = delimiter;}
    public TreeMap<Integer, String> getFull_Divisor_List() {return this.full_Divisor_List;}

    public FizzBuzz() {
        this.divisor_Word_List = new TreeMap<>();
        this.setDivisor_Word(3, "Fizz"); // user class methods to set divisor list so the multiplier list gets created as well
        this.setDivisor_Word(5, "Buzz");
        this.output_On_Division = Boolean.TRUE;
        this.include_Word_List = new TreeMap<>();
        this.include_Word_List.put(2, "Pip");
        this.include_Word_List.put(5, "Pop");
        this.output_On_Include  = Boolean.FALSE;
    }

    public FizzBuzz(TreeMap<Integer, String> divisor_Word_List,
                    Boolean output_On_Division,
                    TreeMap<Integer, String> include_Word_List,
                    Boolean output_On_Include) {
        this.setDivisor_Word_List(divisor_Word_List); // user class methods to set divisor list so the multiplier list gets created as well
        this.output_On_Division = output_On_Division;
        this.include_Word_List  = include_Word_List;
        this.output_On_Include  = output_On_Include;
    }
    private void generate_Divisor_list() {
        // create a Map of the multiples of the divisor list
        this.full_Divisor_List.clear();
        // go through the divisor list and generate the List that will be used during evaluation time

I was here about to generate the multiplier divisor_Word_List



        this.full_Divisor_List.put(key, Word);
    }
    public void setDivisor_Word(int key, String new_Word) {
        // check for out of bounds keys and invalid words
        if((this.min_Divisor_Word_Key>key) || (this.max_Divisor_Word_Key<key)){
            throw new ArrayIndexOutOfBoundsException();
        }
        if((this.getMin_Word_Length()>new_Word.length()) || (this.getMax_Word_Length()<new_Word.length())){
            // this should be a different Exception type.
            throw new ArrayIndexOutOfBoundsException();
        }
        if(this.divisor_Word_List.containsKey(key)){
            this.divisor_Word_List.replace(key, new_Word);
        }
        else{
            if(this.divisor_Word_List.size() < this.max_Length_Divisor_Word_List){
                this.divisor_Word_List.put(key, new_Word);
                this.generate_Divisor_list(); // update the multiplier list
            }
            else{
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
    public String getDivisor_Word(int key) {
        return this.divisor_Word_List.get(key);
    }
    public void remove_Divisor_Word(int key){
        if(this.divisor_Word_List.containsKey(key)){
int iiii = 1/0;
// update the multiplier list
            this.divisor_Word_List.remove(key);
        }
    }
    public void replace_Divisor_Word(int key, String new_Word) {
        if(this.divisor_Word_List.containsKey(key)){
int iiii = 1/0;
// update the multiplier list
            this.divisor_Word_List.replace(key, new_Word);
        }
    }
    public void setInclude_Word(int key, String new_Word) {
        if((this.min_Include_Word_Key>key) || (this.max_Include_Word_Key<key)){
            throw new ArrayIndexOutOfBoundsException();
        }
        if((this.getMin_Word_Length()>new_Word.length()) || (this.getMax_Word_Length()<new_Word.length())){
            // this should be a different Exception type.
            throw new ArrayIndexOutOfBoundsException();
        }
        if(this.include_Word_List.containsKey(key)){
            this.include_Word_List.replace(key, new_Word);
        }
        else{
            if(this.include_Word_List.size() < this.max_Length_Include_Word_List){
                this.include_Word_List.put(key, new_Word);
            }
            else{
                throw new ArrayIndexOutOfBoundsException();
            }
            
        }
    }
    public String getInclude_Word(int key) {
        return this.include_Word_List.get(key);
    }
    public void remove_Include_Word(int key){
        if(this.include_Word_List.containsKey(key)){
            this.include_Word_List.remove(key);
        }
    }
    public void replace_Include_Word(int key, String new_Word) {
        if(this.include_Word_List.containsKey(key)){
            this.include_Word_List.replace(key, new_Word);
        }
    }

    public String evaluate(int inputNumber) {
        if (inputNumber < this.min_Divisor_Word_Key) {
            return String.valueOf(inputNumber);
        }
        String inputString = String.valueOf(inputNumber);
        String returnStr = String.valueOf(inputNumber);
        // get a sorted LIST of the divisors to use for matching

        for(int i : this.divisor_Word_List.keySet()) {
            System.out.println("Divisor is : " + i);
            if (0 < i) {
                if (0 == (inputNumber % i)) {
                    returnStr += this.delimiter + divisor_Word_List.get(i);
                    delimiter = "-";
                }
            }
            if (1 > returnStr.length()) returnStr = String.valueOf(inputNumber);
            return returnStr;
        }
        return "";
    }
}






