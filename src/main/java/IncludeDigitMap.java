import org.omg.PortableInterceptor.INACTIVE;

import java.util.TreeMap;

/**
 * Created by GDICK on 4/18/2015.
 */

/*
SubClass TreeMap to provide the unique behaviour needed for the FizzBuzz project
in particular needed functionality is :
    set maximum number of digits that can be stored,
    enforce minimum and maximum string length for the stored words
    report space left in Map

*/
public class IncludeDigitMap  extends TreeMap<Integer, String> {
    private static int absolute_Max_Size = 10;
    private static int absolute_Min_Key = 0;
    private static int absolute_Max_Key = 9;
    private static int absolute_Min_Delimiter_Length = 1;
    private static int absolute_Max_Delimiter_Length = 3;
    private static int absolute_Min_Word_Length = 1;
    private static int absolute_Max_Word_Length = 11;
    private static String defaultDelimiter = "-";

    private String delimiter = "-";
    private int min_Delimiter_Length;
    private int max_Delimiter_Length;
    private int min_Word_Length;
    private int max_Word_Length;
    private int max_Size;
    private int min_Key;
    private int max_Key;

    public static int getAbsoluteMaxSize() {return absolute_Max_Size;}
    public static int getAbsoluteMinKey() {return absolute_Min_Key;}
    public static int getAbsoluteMaxKey() {return absolute_Max_Key;}

    public static int getAbsoluteMinDelimiterLength() {return absolute_Min_Delimiter_Length;}
    public static int getAbsoluteMaxDelimiterLength() {return absolute_Max_Delimiter_Length;}
    public static int getAbsoluteMinWordLength() {return absolute_Min_Word_Length;}
    public static int getAbsoluteMaxWordLength() {return absolute_Max_Word_Length;}
    public static String getDefaultDelimiter() {return defaultDelimiter;}

    public int getMaxSize() {return this.max_Size;}
    public int getMinKey() {return this.min_Key;}
    public int getMaxKey() {return this.max_Key;}
    public String getDelimiter() {return delimiter;}
    public int getMinDelimiterLength() {return this.min_Delimiter_Length;}
    public int getMaxDelimiterLength() {return this.max_Delimiter_Length;}
    public int getMinWordLength() {return this.min_Word_Length;}
    public int getMaxWordLength() {return this.max_Word_Length;}
    public void setMaxSize(int max_Size) throws IncludeDigitMapException {
        if(1 > max_Size) {
            throw new IncludeDigitMapException("Maximum Size too low");
        }
        if(absolute_Max_Size  < max_Size) {
            throw new IncludeDigitMapException("Maximum Size too high");
        }
        this.max_Size = max_Size;
    }
    public void setMin_Key(int min_Key) throws IncludeDigitMapException {
        if(absolute_Min_Key > min_Key) {
            throw new IncludeDigitMapException("Minimum Key Size too low");
        }
        if(absolute_Max_Key  < min_Key) {
            throw new IncludeDigitMapException("Minimum Key Size too high");
        }
        this.min_Key = min_Key;
    }
    public void setMax_Key(int max_Key) throws IncludeDigitMapException {
        if(absolute_Min_Key > max_Key) {
            throw new IncludeDigitMapException("Maximum Key Size too low");
        }
        if(absolute_Max_Key  < max_Key) {
            throw new IncludeDigitMapException("Maximum Key Size too high");
        }
        this.max_Key = max_Key;
    }
    public void setDelimiter(String delimiter) throws IncludeDigitMapException {
        if(null == delimiter){
            throw new IncludeDigitMapException("Delimiter string in NULL");
        }
        if(this.min_Delimiter_Length > delimiter.length()) {
            throw new IncludeDigitMapException("Delimiter string too short");
        }
        if(this.max_Delimiter_Length < delimiter.length()) {
            throw new IncludeDigitMapException("Delimiter string too long");
        }
        this.delimiter = delimiter;
    }
    public void setMin_Word_Length(int min_Word_Length) throws IncludeDigitMapException {
        if(absolute_Min_Word_Length > min_Word_Length) {
            throw new IncludeDigitMapException("Minimum word length too low");
        }
        if(absolute_Max_Word_Length < min_Word_Length) {
            throw new IncludeDigitMapException("Minimum word length too high");
        }
        this.min_Word_Length = min_Word_Length;
    }
    public void setMax_Word_Length(int max_Word_Length) throws IncludeDigitMapException {
        if(absolute_Min_Word_Length > max_Word_Length) {
            throw new IncludeDigitMapException("Maximum word length too low");
        }
        if(absolute_Max_Word_Length  < max_Word_Length) {
            throw new IncludeDigitMapException("Maximum word length too high");
        }
        this.max_Word_Length = max_Word_Length;
    }
    public void setMin_Delimiter_Length(int min_Delimiter_Length) throws IncludeDigitMapException {
        if(absolute_Min_Delimiter_Length > min_Delimiter_Length) {
            throw new IncludeDigitMapException("Minimum word length too low");
        }
        if(absolute_Max_Word_Length < min_Delimiter_Length) {
            throw new IncludeDigitMapException("Minimum word length too high");
        }
        this.min_Delimiter_Length = min_Delimiter_Length;
    }
    public void setMax_Delimiter_Length(int max_Delimiter_Length) throws IncludeDigitMapException {
        if(absolute_Min_Word_Length > max_Delimiter_Length) {
            throw new IncludeDigitMapException("Maximum word length too low");
        }
        if(absolute_Max_Delimiter_Length  < max_Delimiter_Length) {
            throw new IncludeDigitMapException("Maximum word length too high");
        }
        this.max_Delimiter_Length = max_Delimiter_Length;
    }
    public int getSpace() {return this.getMaxSize()-this.size();}

    private IncludeDigitMap(IncludeDigitMapBuilder builder) throws IncludeDigitMapException {
        // validate that the values are valid
        try {
            this.setMaxSize(builder.max_Size);
            this.setMin_Key(builder.min_Key);
            this.setMax_Key(builder.max_Key);
            this.setMin_Delimiter_Length(builder.min_Delimiter_Length);
            this.setMax_Delimiter_Length(builder.max_Delimiter_Length);
            this.setMax_Word_Length(builder.max_Delimiter_Length);
            this.setDelimiter(builder.delimiter);
            this.setMin_Word_Length(builder.min_Word_Length);
            this.setMax_Word_Length(builder.max_Word_Length);

        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
            String error_Message = "Construction Error: " + IncludeDigitMapException.getMessage();
            throw new IncludeDigitMapException(error_Message);
        }
    }


    public Boolean compare(IncludeDigitMap hm1){
        return this.compare(this, hm1);
    }
    public Boolean compare(TreeMap<Integer, String>  hm1){
        return this.compare(this, hm1);
    }
    public static Boolean compare(IncludeDigitMap hm1, IncludeDigitMap hm2){
        if(hm1.getMaxSize() != hm2.getMaxSize()) { return Boolean.FALSE;}
        if(hm1.getMinKey() != hm2.getMinKey()) { return Boolean.FALSE;}
        if(hm1.getMaxKey() != hm2.getMaxKey()) { return Boolean.FALSE;}
        if(hm1.getDelimiter() != hm2.getDelimiter()) { return Boolean.FALSE;}
        if(hm1.getMinDelimiterLength() != hm2.getMinDelimiterLength()) { return Boolean.FALSE;}
        if(hm1.getMaxDelimiterLength() != hm2.getMaxDelimiterLength()) { return Boolean.FALSE;}
        if(hm1.getMinWordLength() != hm2.getMinWordLength()) { return Boolean.FALSE;}
        if(hm1.getMaxWordLength() != hm2.getMaxWordLength()) { return Boolean.FALSE;}

        if(hm1.size() != hm2.size()) { return Boolean.FALSE;}
        for (final int key : hm1.keySet()) {
            if (hm2.containsKey(key)) {
                if(!hm1.get(key).equals(hm2.get(key))){
                    return Boolean.FALSE;
                }
            }
            else{
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
    public static Boolean compare(IncludeDigitMap hm1, TreeMap<Integer, String>  hm2){
        // this is bad, duplicate code
        // need to learn how to cast the input TreeMap to a IncludeDigitMap
        // so the other .compare can be used.
        if(hm1.size() != hm2.size()) {
            return Boolean.FALSE;
        }
        for (final int key : hm1.keySet()) {
            if (hm2.containsKey(key)) {
                if(!hm1.get(key).equals(hm2.get(key))){
                    return Boolean.FALSE;
                }
            }
            else{
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public String toString(){
        String retStr =  "\nmax_Size = "+ this.max_Size;
        retStr += "\nmin_Key = " + this.min_Key;
        retStr += "\nmax_Key = "+ max_Key;
        retStr += "\ndelimiter = "+ delimiter;
        retStr += "\nmin_Word_Length = "+ min_Word_Length;
        retStr += "\nmax_Word_Length = "+ max_Word_Length;
        retStr += "\n"+super.toString();
        return retStr;

    }

    public static class IncludeDigitMapBuilder {
        private int max_Size = IncludeDigitMap.getAbsoluteMaxSize();
        private int min_Key = IncludeDigitMap.getAbsoluteMinKey();
        private int max_Key = IncludeDigitMap.getAbsoluteMaxKey();
        private int min_Delimiter_Length = IncludeDigitMap.absolute_Min_Delimiter_Length;
        private int max_Delimiter_Length = IncludeDigitMap.absolute_Max_Delimiter_Length;
        private String delimiter = "-";
        private int min_Word_Length = IncludeDigitMap.absolute_Min_Word_Length;
        private int max_Word_Length = IncludeDigitMap.absolute_Max_Word_Length;

        public IncludeDigitMapBuilder() {
            // nothing to do
        }
        public IncludeDigitMapBuilder max_Size(int max_Size) {
            // need constraints on all methods
            this.max_Size = max_Size;
            return this;
        }

        public IncludeDigitMapBuilder min_Key(int min_Key) {
            this.min_Key = min_Key;
            return this;
        }

        public IncludeDigitMapBuilder max_Key(int max_Key) {
            this.max_Key = max_Key;
            return this;
        }

        public IncludeDigitMapBuilder delimiter(String delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public IncludeDigitMapBuilder min_Word_Length(int min_Word_Length) {
            this.min_Word_Length = min_Word_Length;
            return this;
        }

        public IncludeDigitMapBuilder max_Word_Length(int max_Word_Length) {
            this.max_Word_Length = max_Word_Length;
            return this;
        }

        public IncludeDigitMap build() throws IncludeDigitMapException {
            return new IncludeDigitMap(this);
        }

    }

    public TreeMap <Integer, String > getMap(){
        TreeMap<Integer, String> map = new TreeMap<>();
        for (final int key : this.keySet()){
            map.put(key, this.get(key));
        }
        return map;
    }
    public String replace(TreeMap<Integer, String> map) throws ClassCastException {
        this.clear();
        for(final int key : map.keySet()){
            this.put(key, map.get(key));
        }
        return null;
    }
    @Override
    public Object clone() throws ClassCastException {
        IncludeDigitMap clone = null;
        try {
            clone = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            clone.setDelimiter(this.getDelimiter());
            clone.setMin_Delimiter_Length(this.getMinDelimiterLength());
            clone.setMax_Delimiter_Length(this.getMaxDelimiterLength());
            clone.setMin_Word_Length(this.getMinWordLength());
            clone.setMax_Word_Length(this.getMaxWordLength());
            clone.setMaxSize(this.getMaxSize());
            clone.setMin_Key(this.getMinKey());
            clone.setMax_Key(this.getMaxKey());
            for(int key : this.keySet()){
                clone.put(key, this.get(key));
            }
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
            String error_Message = "Clone Error: " + IncludeDigitMapException.getMessage();
            throw new ClassCastException(error_Message);
        }

        return clone;
    }

    @Override
    public String put(Integer key, String Word) throws ClassCastException {
        // test that the key and word are within allowed ranges
        if(this.getMinKey() > key) {
            throw new ClassCastException("Key value too low");
        }
        int delete_me =this.getMaxKey();
        if(this.getMaxKey()  < key) {
            throw new ClassCastException("Key value too high");
        }
        if(this.getMinWordLength() > Word.length()) {
            throw new ClassCastException("Word is too short");
        }
        if(this.getMaxWordLength()  < Word.length()) {
            throw new ClassCastException("Word is too long");
        }
        if(this.getMaxSize()  <= this.size()) {
            throw new ClassCastException("Maximum number of Word set");
        }
        String oldValue = super.put(key, Word);
        return oldValue;
    }
/*
    public String put(Integer key, String Word) throws IncludeDigitMapException {
        // test that the key and word are within allowed ranges
        if(this.getMinKey() > key) {
            throw new IncludeDigitMapException("Key value too low");
        }
        if(this.getMaxKey()  < key) {
            throw new IncludeDigitMapException("Key value too high");
        }
        if(this.getMinWordLength() > Word.length()) {
            throw new IncludeDigitMapException("Word is too short");
        }
        if(this.getMaxWordLength()  < Word.length()) {
            throw new IncludeDigitMapException("Word is too long");
        }
        String oldValue = super.put(key, Word);
        return oldValue;
    }

*/
}
