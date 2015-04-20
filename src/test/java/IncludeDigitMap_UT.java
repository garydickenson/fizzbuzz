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
    public void able_To_Create_Default(){
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            System.out.println(map.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void able_To_Create_Builder(){
        int max_Size = IncludeDigitMap.getAbsoluteMaxSize();
        int min_Key = IncludeDigitMap.getAbsoluteMinKey();
        int max_Key = IncludeDigitMap.getAbsoluteMaxKey();
        String delimiter = IncludeDigitMap.getDefaultDelimiter();
        int min_Word_Length = IncludeDigitMap.getAbsoluteMinWordLength();
        int max_Word_Length = IncludeDigitMap.getAbsoluteMaxWordLength();
        try{
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().max_Size(max_Size).min_Key(min_Key).max_Key(max_Key).delimiter(delimiter).min_Word_Length(min_Word_Length).max_Word_Length(max_Word_Length).build();
            System.out.println(map.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void can_not_Create_invalid_size(){
        int max_Size = -1;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().max_Size(max_Size).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        max_Size = 0;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().max_Size(max_Size).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        max_Size = IncludeDigitMap.getAbsoluteMaxSize()+1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().max_Size(max_Size).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

    }

    @Test
    public void can_not_Create_invalid_min_Key(){
        int min_Key = IncludeDigitMap.getAbsoluteMinKey()-1;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().min_Key(min_Key).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        min_Key = IncludeDigitMap.getAbsoluteMaxKey()+1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().min_Key(min_Key).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void can_not_Create_invalid_max_Key(){
        int max_Key = IncludeDigitMap.getAbsoluteMinKey()-1;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().max_Key(max_Key).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        max_Key = IncludeDigitMap.getAbsoluteMaxKey()+1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().max_Key(max_Key).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void can_not_Create_invalid_Delimiter(){
        String delimiter = null;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().delimiter(delimiter).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        delimiter = "";
        for (int i = 0; i < IncludeDigitMap.getAbsoluteMinDelimiterLength()-1; i++) {
            delimiter += ".";
        }
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().delimiter(delimiter).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        delimiter = "";
        for (int i = 0; i <= IncludeDigitMap.getAbsoluteMaxDelimiterLength()+1; i++) {
            delimiter += ".";
        }
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().delimiter(delimiter).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void can_not_Create_invalid_min_Word_Length(){
        int min_Word_Length = IncludeDigitMap.getAbsoluteMinWordLength()-1;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().min_Word_Length(min_Word_Length).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        min_Word_Length = IncludeDigitMap.getAbsoluteMaxWordLength()+1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().min_Word_Length(min_Word_Length).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void can_not_Create_invalid_max_Word_Length(){
        int max_Word_Length = IncludeDigitMap.getAbsoluteMinWordLength()-1;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().max_Word_Length(max_Word_Length).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        max_Word_Length = IncludeDigitMap.getAbsoluteMaxWordLength()+1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().max_Word_Length(max_Word_Length).build();
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void able_To_Set_Valid_size() {
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
    public void able_To_Set_Valid_Min_Key(){
        int min_Key = IncludeDigitMap.getAbsoluteMinKey();
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMin_Key(min_Key);
            int sfds = map.getMinKey();
            assertTrue(map.getMinKey() == min_Key);

            min_Key = IncludeDigitMap.getAbsoluteMaxKey();
            map.setMin_Key(min_Key);
            sfds = map.getMinKey();
            assertTrue(map.getMinKey() == min_Key);
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
        }
    }

    @Test
    public void able_To_Set_Valid_Max_Key(){
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
    public void able_To_Set_Valid_Delimiter(){
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
    public void able_To_Set_Valid_min_Word_Length(){
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
    public void able_To_Set_Valid_max_Word_Length(){
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

    @Test
    public void can_not_Set_invalid_size(){
        int max_Size=-1;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMaxSize(max_Size);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        max_Size = 0;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMaxSize(max_Size);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        max_Size = IncludeDigitMap.getAbsoluteMaxSize()+1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMaxSize(max_Size);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

    }

    @Test
    public void can_not_Set_invalid_min_Key(){
        int min_Key = -1;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMin_Key(min_Key);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        min_Key = IncludeDigitMap.getAbsoluteMinKey()-1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMin_Key(min_Key);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        min_Key = IncludeDigitMap.getAbsoluteMaxKey()+1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMin_Key(min_Key);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void can_not_Set_invalid_max_Key(){
        int max_Key=IncludeDigitMap.getAbsoluteMinKey()-1;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMax_Key(max_Key);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        max_Key = IncludeDigitMap.getAbsoluteMaxKey()+1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMax_Key(max_Key);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void can_not_Set_invalid_Delimiter(){
        String delimiter = null;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setDelimiter(delimiter);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        delimiter = "";
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            for (int i = 0; i < map.getMinDelimiterLength()-1; i++) {
                delimiter += i;
            }
            map.setDelimiter(delimiter);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        delimiter = "";
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            for (int i = 0; i <= map.getMaxDelimiterLength(); i++) {
                delimiter += ".";
            }
            map.setDelimiter(delimiter);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void can_not_Set_invalid_min_Word_Length(){
        int min_Word_Length = IncludeDigitMap.getAbsoluteMinWordLength()-1;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMin_Word_Length(min_Word_Length);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        min_Word_Length = IncludeDigitMap.getAbsoluteMaxWordLength()+1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMin_Word_Length(min_Word_Length);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void can_not_Set_invalid_max_Word_Length(){
        int max_Word_Length = IncludeDigitMap.getAbsoluteMinWordLength()-1;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMax_Word_Length(max_Word_Length);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        max_Word_Length = IncludeDigitMap.getAbsoluteMaxWordLength()+1;
        success = Boolean.FALSE; //expect it to fail
        try {
            IncludeDigitMap map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
            map.setMax_Word_Length(max_Word_Length);
            System.out.println(map.toString());
        }
        catch (IncludeDigitMapException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void able_to_add_Word() {
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
    public void able_To_Replace_List_With_TreeMap() {
        IncludeDigitMap map = null;
        try {
            map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
        } catch (IncludeDigitMapException IncludeDigitMapException) {
            IncludeDigitMapException.printStackTrace();
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

    @Test
    public void can_not_add_Invalid_key() {
        int key = -1;
        IncludeDigitMap map = null;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
        } catch(IncludeDigitMapException e){
            assertTrue(Boolean.FALSE);
        }
        try {
            key = map.getMinKey() - 1;
            String Word = "";
            for (int i = map.getMinWordLength(); i < map.getMaxWordLength(); i++) {
                Word += ":";
            }
            map.put(key, Word);
        } catch (ClassCastException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        success = Boolean.FALSE; //expect it to fail
        try {
            map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
        } catch(IncludeDigitMapException e){
            assertTrue(Boolean.FALSE);
        }
        try {
            key = map.getMaxKey() + 1;
            String Word = "";
            for (int i = map.getMinWordLength(); i < map.getMaxWordLength(); i++) {
                Word += ":";
            }
            map.put(key, Word);
        } catch (ClassCastException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }


    @Test
    public void can_not_add_Invalid_Word() {
        int key = -1;
        IncludeDigitMap map = null;
        Boolean success = Boolean.FALSE; //expect it to fail
        try {
            map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
        } catch (IncludeDigitMapException e) {
            assertTrue(Boolean.FALSE);
        }
        try{
            key = map.getMinKey();
            String Word = "";
            for (int i = 0; i < map.getMinWordLength()-1; i++) {
                Word += ":";
            }
            map.put(key, Word);
        } catch (ClassCastException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);

        success = Boolean.FALSE; //expect it to fail
        try {
            map = new IncludeDigitMap.IncludeDigitMapBuilder().build();
        } catch (IncludeDigitMapException e) {
            assertTrue(Boolean.FALSE);
        }
        try{
            key = map.getMinKey();
            String Word = "";
            for (int i = 0; i < map.getMaxWordLength()+1; i++) {
                Word += ":";
            }
            map.put(key, Word);
        } catch (ClassCastException e) {
            //This is good, correct behavior
            success = Boolean.TRUE;
        }
        assertTrue(success);
    }

    @Test
    public void able_To_Remove_Word(){
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
    public void able_To_Get_Available_Space(){
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
