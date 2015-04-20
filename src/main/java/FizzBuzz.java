import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Gary Dickenson on 4/7/2015.
 */
public class FizzBuzz {
    private TreeMap<Integer, String> divisor_Word_List;
    private int max_Length_Divisor_Word_List = 10;
    private Boolean output_On_Division = Boolean.TRUE;
    private Boolean output_On_Include  = Boolean.FALSE;
    private int min_Divisor_Word_Key = 3;
    private int max_Divisor_Word_Key = 19;
    private String delimiter = "-";
    private TreeMap<Integer, String> full_Divisor_List;
    public int max_Word_Length = 11;
    public int min_Word_Length = 1;
    private IncludeDigitMap includeDigitMap;

    public TreeMap<Integer, String> getDivisor_Word_List() {return this.divisor_Word_List;}
    public void setDivisor_Word_List(TreeMap<Integer, String> Word_List) {
        if(null != this.divisor_Word_List) {
            this.divisor_Word_List.clear();
        }
        for (final int key : Word_List.keySet()) {
            this.setDivisor_Word(key, Word_List.get(key));
        }
    }
    public TreeMap<Integer, String> getInclude_Word_List() {return includeDigitMap.getMap();}
    public void clearInclude_Word_List(){this.includeDigitMap .clear();}
    public void setInclude_Word_List(TreeMap<Integer, String> Word_List) {this.includeDigitMap.replace(Word_List);}
    public Boolean isOutput_On_Division() {return this.output_On_Division;}
    public void setOutput_On_Division(Boolean output_On_Division) {this.output_On_Division = output_On_Division;}
    public Boolean isOutput_On_Include() {return this.output_On_Include;}
    public void setOutput_On_Include(Boolean output_On_Include) {this.output_On_Include = output_On_Include;}
    public int getMax_Length_Divisor_Word_List() {return this.max_Length_Divisor_Word_List;}
    public int getMax_Size_Include_Word_List() {return this.includeDigitMap .getMaxSize();}
    public int get_Length_divisor_Word_List() {return this.divisor_Word_List.size();}
    public int get_Length_Include_Word_List() {return this.includeDigitMap.size();}
    public int get_Space_divisor_Word_List() {return this.getMax_Length_Divisor_Word_List()-this.divisor_Word_List.size();}
    public int get_Space_Include_Word_List() {return this.includeDigitMap.getSpace();}
    public int getMin_Divisor_Word_key() {return this.min_Divisor_Word_Key;}
    public int getMax_Divisor_Word_key() {return this.max_Divisor_Word_Key;}
    public int getMin_Include_Word_key() {return this.includeDigitMap.getMinKey();}
    public int getMax_Include_Word_key() {return this.includeDigitMap.getMaxKey();}
    public int getMin_Word_Length() {return this.min_Word_Length;}
    public int getMax_Word_Length() {return this.max_Word_Length;}
    public String getDelimiter() {return this.delimiter;}
    public String getIncludeWordDelimiter() {return this.includeDigitMap.getDelimiter();}
    public void setDelimiter(String delimiter) {this.delimiter = delimiter;}
    public void setIncludeWordDelimiter(String delimiter) throws IncludeDigitMapException {this.includeDigitMap.setDelimiter(delimiter);}
    public TreeMap<Integer, String> getFull_Divisor_List() {return this.full_Divisor_List;}

    public FizzBuzz() {
        this.divisor_Word_List = new TreeMap<>();
        this.full_Divisor_List = new TreeMap<>();
        this.setDivisor_Word(3, "Fizz"); // user class methods to set divisor list so the multiplier list gets created as well
        this.setDivisor_Word(5, "Buzz");
        this.output_On_Division = Boolean.TRUE;
        try {
            this.includeDigitMap  = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            this.includeDigitMap .put(2, "Pip");
            this.includeDigitMap .put(5, "Pop");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        this.output_On_Include  = Boolean.FALSE;
    }

    private void generate_Divisor_list() {
        // create a Map of the multiples of the divisor list
        // add the initial list to the full List
        // go through the divisor list and generate the List that will be used during evaluation time
        // take the first key, multiple all the other keys by it and add to full List
        // get the next key, multiple the remaining keys. (skipping the first one) and add to list
        // continue until all combinations have been computed, The words are the [lowest numeric value]_[highest numeric value]

        this.full_Divisor_List = (TreeMap<Integer, String>)this.divisor_Word_List.clone();
        List<Integer> key_list =  new ArrayList<Integer>(this.divisor_Word_List.keySet());
        for (int i = 0; i < key_list.size(); i++) {
            int first_key = key_list.get(i);
            for (int j = i+1; j < key_list.size(); j++) {
                int second_key = key_list.get(j);

                this.full_Divisor_List.put(first_key*second_key, this.divisor_Word_List.get(first_key)+this.delimiter+this.divisor_Word_List.get(second_key));
            }
        }
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
            this.replace_Divisor_Word(key, new_Word);
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
        if(this.divisor_Word_List.containsKey(key)) {
            this.divisor_Word_List.remove(key);
            this.generate_Divisor_list(); // update the multiplier list
        }
    }
    public void replace_Divisor_Word(int key, String new_Word) {
        if(this.divisor_Word_List.containsKey(key)){
            this.divisor_Word_List.replace(key, new_Word);
            this.generate_Divisor_list(); // update the multiplier list
        }
    }
    public String setInclude_Word(int key, String Word) throws ClassCastException {
        return this.includeDigitMap.put(key, Word);
    }
    public String getInclude_Word(int key) {
        return this.includeDigitMap.get(key);
    }
    public void remove_Include_Word(int key){
        try {
            System.out.println(this.includeDigitMap.toString());
            this.includeDigitMap.remove(key);
        } catch (NullPointerException e){}
    }
    public void replace_Include_Word(int key, String Word) {
          this.includeDigitMap.replace(key, Word);
    }
    public Boolean compareIncludeMap(TreeMap<Integer, String> Word_List){
        return this.includeDigitMap.compare(Word_List);
    }
    public String evaluate(int inputNumber) {
        String returnStr = "";

        if (this.output_On_Division) {
            // got through the full divisor list in reverse order.
            // stop on first match.
            ArrayList<Integer> keys = new ArrayList<>(this.getFull_Divisor_List().keySet());
            for (int i = keys.size() - 1; i >= 0; i--) {
                int divisor = keys.get(i);
                if (0 == (inputNumber % divisor)) {
                    returnStr = this.getFull_Divisor_List().get(keys.get(i));
                    break;
                }
            }
        }
        if (this.output_On_Include) {
            if (inputNumber < this.includeDigitMap.getMinKey()) {
                if (1 > returnStr.length()) {
                    returnStr = String.valueOf(inputNumber);
                }
            } else {
                String inputString = String.valueOf(inputNumber);
                String delimiter = this.includeDigitMap.getDelimiter();
                if (1 > returnStr.length()) {
                    delimiter = "";
                }
                for (int i : this.includeDigitMap.keySet()) {
                    String delete_me_1 = this.includeDigitMap .get(i);
                    int delete_me_2 = inputString.indexOf(String.valueOf(i));
                    if (inputString.contains(String.valueOf(i))) {
                        returnStr = returnStr + delimiter + this.includeDigitMap.get(i);
                        delimiter = this.includeDigitMap.getDelimiter();
                    }
                }
            }
        }
        if (1 > returnStr.length()) {
            returnStr = String.valueOf(inputNumber);
        }
        return returnStr;
    }
}






