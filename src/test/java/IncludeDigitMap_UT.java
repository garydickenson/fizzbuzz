import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by GDICK on 4/18/2015.
 */
public class IncludeDigitMap_UT {
    @Test
    public void testTrue() { assertTrue(true); }

//    @Test(expected =Exception.class) public void testTrueShouldFailForFalse() {assertTrue(false); }

    @Test
    public void ableToCreateDefault(){
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            System.out.println(map.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void ableToCreateBuilder(){
        int max_Size = IncludeDigitMap.getAbsoluteMaxSize();
        int min_Key = IncludeDigitMap.getAbsoluteMinKey();
        int max_Key = IncludeDigitMap.getAbsoluteMaxKey();
        String delimiter = IncludeDigitMap.getDefaultDelimiter();
        int min_Word_Length = IncludeDigitMap.getAbsoluteMinWordLength();
        int max_Word_Length = IncludeDigitMap.getAbsoluteMaxWordLength();
        try{
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().maxSize(max_Size).keys(min_Key, max_Key).delimiter(delimiter).wordLength(min_Word_Length, max_Word_Length).build();
            System.out.println(map.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Boolean evaluateCreateSize(int size){
        Boolean result = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().maxSize(size).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is Not good, the builder should catch the error for the class gets the values
            result = Boolean.FALSE;
        }
        catch (IllegalStateException e) {
            //This is good, correct behavior
            result = Boolean.TRUE;
        }
        return result;

    }
    @Test
    public void canNotCreateInvalidSize(){
        int size = IncludeDigitMap.getAbsoluteMinSize()-1;
        assertTrue(evaluateCreateSize(size));

        size = IncludeDigitMap.getAbsoluteMaxSize()+1;
        assertTrue(evaluateCreateSize(size));
    }

    private Boolean evaluateCreatekeys(int min, int max){
        Boolean result = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().keys(min, max).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is Not good, the builder should catch the error for the class gets the values
            result = Boolean.FALSE;
        }
        catch (IllegalStateException e) {
            //This is good, correct behavior
            result = Boolean.TRUE;
        }
        return result;
    }
    @Test
    public void can_not_Create_Invalid_Keys(){
        int minKey = IncludeDigitMap.getAbsoluteMinKey()-1; // min too small
        int maxKey = IncludeDigitMap.getAbsoluteMaxKey();
        assertTrue(evaluateCreatekeys(minKey, maxKey));

        minKey = IncludeDigitMap.getAbsoluteMaxKey()+1; // min too big
        maxKey = IncludeDigitMap.getAbsoluteMaxKey();
        assertTrue(evaluateCreatekeys(minKey, maxKey));

        minKey = IncludeDigitMap.getAbsoluteMinKey();
        maxKey = IncludeDigitMap.getAbsoluteMinKey()-1; // max too small
        assertTrue(evaluateCreatekeys(minKey, maxKey));

        minKey = IncludeDigitMap.getAbsoluteMinKey();
        maxKey = IncludeDigitMap.getAbsoluteMaxKey()+1; // max too big
        assertTrue(evaluateCreatekeys(minKey, maxKey));

        minKey = IncludeDigitMap.getAbsoluteMaxKey(); // min > max
        maxKey = IncludeDigitMap.getAbsoluteMinKey();
        assertTrue(evaluateCreatekeys(minKey, maxKey));
    }

    private Boolean evaluateCreateDelimiter(String delimiter){
        Boolean result = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().delimiter(delimiter).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            result = Boolean.FALSE; //This is Not good, the builder should catch the error for the class gets the values
        }
        catch (IllegalStateException e) {
            result = Boolean.TRUE; //This is good, correct behavior
        }
        return result;
    }
    @Test
    public void canNotCreateInvalidDelimiter(){
        String delimiter = null;
        assertTrue(evaluateCreateDelimiter(delimiter));

        delimiter = "";
        assertTrue(evaluateCreateDelimiter(delimiter));

        delimiter = "";
        for (int i = 0; i < IncludeDigitMap.getAbsoluteMinDelimiterLength()-1; i++) {
            delimiter += ".";
        }
        assertTrue(evaluateCreateDelimiter(delimiter));

        delimiter = "";
        for (int i = 0; i <= IncludeDigitMap.getAbsoluteMaxDelimiterLength()+1; i++) {
            delimiter += ".";
        }
        assertTrue(evaluateCreateDelimiter(delimiter));
    }

    private Boolean evaluateCreateWordLength(int min, int max){
        Boolean result = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().wordLength(min, max).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            result = Boolean.FALSE; //This is Not good, the builder should catch the error for the class gets the values
        }
        catch (IllegalStateException e) {
            result = Boolean.TRUE; //This is good, correct behavior
        }
        return result;
    }
    @Test
    public void canNotCreateInvalidWordLength(){
        int min = IncludeDigitMap.getAbsoluteMinWordLength()-1; // min too small
        int max = IncludeDigitMap.getAbsoluteMaxWordLength();
        assertTrue(evaluateCreateWordLength(min, max));

        min = IncludeDigitMap.getAbsoluteMaxWordLength()+1; // min too big
        assertTrue(evaluateCreateWordLength(min, max));

        min = IncludeDigitMap.getAbsoluteMinWordLength();
        max = IncludeDigitMap.getAbsoluteMinWordLength()-1; // max too small
        assertTrue(evaluateCreateWordLength(min, max));

        min = IncludeDigitMap.getAbsoluteMinWordLength();
        max = IncludeDigitMap.getAbsoluteMaxWordLength()+1; // max too big
        assertTrue(evaluateCreateWordLength(min, max));

        min = IncludeDigitMap.getAbsoluteMaxWordLength(); // min > max
        max = IncludeDigitMap.getAbsoluteMinWordLength(); // this assumes that AbsMin and AbsMax are not the same value
        assertTrue(evaluateCreateWordLength(min, max));

    }

    @Test
    public void ableToSetValidSize() {
        int max_Size = 1;
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMaxSize(max_Size);
            assertTrue(map.getMaxSize() == max_Size);
            max_Size = IncludeDigitMap.getAbsoluteMaxSize();
            map.setMaxSize(max_Size);
            assertTrue(map.getMaxSize() == max_Size);
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }
    }

    @Test
    public void ableToSetValidMinKey(){
        int min_Key = IncludeDigitMap.getAbsoluteMinKey();
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMin_Key(min_Key);
            assertTrue(map.getMinKey() == min_Key);

            min_Key = IncludeDigitMap.getAbsoluteMaxKey();
            map.setMin_Key(min_Key);
            assertTrue(map.getMinKey() == min_Key);
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }
    }

    @Test
    public void ableToSetValidMaxKey(){
        int max_Key = IncludeDigitMap.getAbsoluteMinKey();
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMax_Key(max_Key);
            assertTrue(map.getMaxKey() == max_Key);

            max_Key = IncludeDigitMap.getAbsoluteMaxKey();
            map.setMax_Key(max_Key);
            assertTrue(map.getMaxKey() == max_Key);
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }
    }

    @Test
    public void ableToSetValidDelimiter(){
        String delimiter = "*";
        IncludeDigitMap map = null;
        try {
            map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            assertFalse(delimiter.equals(map.getDelimiter()));
            map.setDelimiter(delimiter);
            assertTrue(delimiter.equals(map.getDelimiter()));
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }

    }

    @Test
    public void ableToSetValidMinWordLength(){
        int min_Word_Length = IncludeDigitMap.getAbsoluteMinWordLength();
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMin_Word_Length(min_Word_Length);
            assertTrue(map.getMinWordLength() == min_Word_Length);

            min_Word_Length = IncludeDigitMap.getAbsoluteMaxWordLength();
            map.setMin_Word_Length(min_Word_Length);
            assertTrue(map.getMinWordLength() == min_Word_Length);
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }
    }

    @Test
    public void ableToSetValidMaxWordLength(){
        int max_Word_Length = IncludeDigitMap.getAbsoluteMinWordLength();
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMax_Word_Length(max_Word_Length);
            assertTrue(map.getMaxWordLength() == max_Word_Length);

            max_Word_Length = IncludeDigitMap.getAbsoluteMaxWordLength();
            map.setMax_Word_Length(max_Word_Length);
            assertTrue(map.getMaxWordLength() == max_Word_Length);
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }
    }

    private Boolean evaluateSetSize(int size){
        Boolean result = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMaxSize(size);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            result = Boolean.TRUE;
        }
        return result;
    }

    @Test
    public void canNotSetInvalidSize(){
        int size = IncludeDigitMap.getAbsoluteMinSize()-1; // too small
        assertTrue(evaluateSetSize(size));

        size = IncludeDigitMap.getAbsoluteMaxSize()+1; // too big
        assertTrue(evaluateSetSize(size));

    }

    private Boolean evaluateSetInvalidMinKey(int key){
        Boolean result = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMin_Key(key);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            result = Boolean.TRUE;
        }
        return result;
    }
    @Test
    public void canNotSetInvalidMinKey(){
        int key = IncludeDigitMap.getAbsoluteMinKey()-1; // too small
        assertTrue(evaluateSetInvalidMinKey(key));

        key = IncludeDigitMap.getAbsoluteMaxKey()+1; // too big
        assertTrue(evaluateSetInvalidMinKey(key));
    }

    private Boolean evaluateSetInvalidMaxKey(int key){
        Boolean result = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMax_Key(key);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            result = Boolean.TRUE;
        }
        return result;
    }
    @Test
    public void canNotSetInvalidMaxKey(){
        int key = IncludeDigitMap.getAbsoluteMinKey()-1; // too small
        assertTrue(evaluateSetInvalidMaxKey(key));

        key = IncludeDigitMap.getAbsoluteMaxKey()+1; // too big
        assertTrue(evaluateSetInvalidMaxKey(key));
    }

    private Boolean evaluateSetInvalidDelimiter(IncludeDigitMap map, String delimiter){
        Boolean  result = Boolean.FALSE; //expect it to fail
        try {
            map.setDelimiter(delimiter);
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            result = Boolean.TRUE;
        }
        return result;
    }
    @Test
    public void canNotSetInvalidDelimiter(){
        IncludeDigitMap map = null;
        try {
            map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
        }
        catch (IncludeDigitMapException e) {
            // got some error creating a new object
            assertTrue(Boolean.FALSE);
        }
        String delimiter = null;
        assertTrue(evaluateSetInvalidDelimiter(map, delimiter));

        delimiter = "";
        assertTrue(evaluateSetInvalidDelimiter(map, delimiter));

        delimiter = "";
        // set to the max size defined in this instance
        for (int i = 0; i <= map.getMaxDelimiterLength()+1; i++) {
            delimiter += ".";
        }
        assertTrue(evaluateSetInvalidDelimiter(map, delimiter));

    }

    private Boolean evaluateSetInvalidMinWordLength(int size){
        Boolean result = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMin_Word_Length(size);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            result = Boolean.TRUE; //This is good, correct behavior
        }
        return result;
    }
    @Test
    public void canNotSetInvalidMinWordLength(){
        int size = IncludeDigitMap.getAbsoluteMinWordLength()-1;  // too small
        assertTrue(evaluateSetInvalidMinWordLength(size));

        size = IncludeDigitMap.getAbsoluteMaxWordLength()+1; // too big
        assertTrue(evaluateSetInvalidMinWordLength(size));
    }

    private Boolean evaluateSetInvalidMaxWordLength(int size) {
        Boolean result = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMax_Word_Length(size);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            result = Boolean.TRUE;
        }
        return result;
    }
    @Test
    public void canNotSetInvalidMaxWordLength(){
        int size = IncludeDigitMap.getAbsoluteMinWordLength()-1; // too small
        assertTrue(evaluateSetInvalidMaxWordLength(size));

        size = IncludeDigitMap.getAbsoluteMaxWordLength()+1; // too big
        assertTrue(evaluateSetInvalidMaxWordLength(size));
    }

    @Test
    public void ableToAddWord() {
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            int key = map.getMinKey();
            String Word = "";
            for (int i = map.getMinWordLength(); i < map.getMaxWordLength(); i++) {
                Word += ":";
            }
            map.put(key, Word);
            assertTrue(Word.equals(map.get(key)));

        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }
    }

    @Test
    public void ableToReplaceListWithTreeMap() {
        IncludeDigitMap map = null;
        try {
            map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
            assertTrue(Boolean.FALSE);
        }
        try{
            String Word = "";
            for (int i = map.getMinWordLength(); i < map.getMaxWordLength(); i++) {
                Word += ":";
            }
            TreeMap<Integer, String> Word_List = new TreeMap<>();
            for(int key = map.getMinKey(); key < map.getMaxKey(); key++){
                Word_List.put(key, Word);
            }

            map.replace(Word_List);
            assertTrue(map.compare(Word_List));

        } catch (ClassCastException e) {
            e.printStackTrace();
            assertTrue(Boolean.FALSE);
        }
    }

    private Boolean evaluateAddInvalidKeyOrWord(IncludeDigitMap map, int key, String Word){
        Boolean result = Boolean.FALSE; //expect it to fail
        try {
            map.put(key, Word);
        } catch (ClassCastException e) {
            result = Boolean.TRUE; //This is good, correct behavior
        }
        return result;
    }
    @Test
    public void canNotAddInvalidKeyOrWord() {
        int key = -1;
        IncludeDigitMap map = null;
        try {
            map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
        } catch(IncludeDigitMapException e){
            assertTrue(Boolean.FALSE);
        }

        String Word = "";
        for (int i = map.getMinWordLength(); i < map.getMaxWordLength(); i++) {
            Word += ":";
        }

        key = map.getMinKey() - 1;
        assertTrue(evaluateAddInvalidKeyOrWord(map, key, Word));  // Key too small , valid Word

        key = map.getMaxKey() + 1;
        assertTrue(evaluateAddInvalidKeyOrWord(map, key, Word));  // Key too big, valid Word

        key = map.getMinKey();
        Word = "";
        for (int i = 0; i < map.getMinWordLength()-1; i++) {
            Word += ":";
        }
        assertTrue(evaluateAddInvalidKeyOrWord(map, key, Word)); // valid Key, Word too small

        key = map.getMinKey();
        Word = "";
        for (int i = 0; i < map.getMaxWordLength()+1; i++) {
            Word += ":";
        }
        assertTrue(evaluateAddInvalidKeyOrWord(map, key, Word)); // valid Key, Word too big
    }

    @Test
    public void ableToRemoveWord(){
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            TreeMap<Integer, String> Word_List = map.getMap();
            while(0 < map.size()){
                int key = map.firstKey();
                Word_List.remove(key);
                map.remove(key);
            }
            assertTrue(map.compare(Word_List));
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }

    }

    @Test
    public void ableToGetAvailableSpace(){
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.clear();
            assertTrue((map.size()) == 0);
            int added_count = 0;
            for (int j = map.getMinKey(); j < map.getMaxKey(); j++) {
                map.put(j, "Pup_"+j);
                added_count++;
                assertTrue((map.size()) == added_count);
                assertTrue((map.getMaxSize() - map.size()) == map.getSpace());
            }
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }
    }
    @Test
    public void ableToClone(){
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            for (int j = map.getMinKey(); j < map.getMaxKey(); j++) {
                map.put(j, "Pup_" + j);
            }
            IncludeDigitMap map2 = (IncludeDigitMap) map.clone();
            assertTrue(map.compare(map2));
            map.put(map.getMinKey(), "Pop");
            assertFalse(map.compare(map2));

        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }


    }
}
