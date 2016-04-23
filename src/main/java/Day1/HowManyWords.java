package Day1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class HowManyWords {

    public void printMap(Map<String, Integer> map){

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry pair = (Map.Entry)iterator.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            iterator.remove();
        }
    }

    public static Map<String, Integer> countWords(String sentence)
    {
        sentence = sentence.toLowerCase(); //convert all chars to lowercase

        String[] arrayOfStrings = sentence.split(" ");//convert string to array of strings, splitting sentence by "spaces"

        Map<String, Integer> result = new HashMap<String, Integer>(); //declaring result variable

        for (String substring : arrayOfStrings) //iterating through arrayOfStrings
        {
            substring = substring.replaceAll("\\W", ""); //deleting all special chars

            if(!result.containsKey(substring)) //if the word is not in result yet
            {
                result.put(substring, 1); //putting this word in result with value 1
            }
            else
            {
                result.put(substring, result.get(substring) + 1); //if already in result, putting there with value +1
            }
        }

        return result;

    }

    @Test
    public void testCountWords001() {
        String str = "Today is a very sunny day. Sunny days are very nice.";

        printMap(countWords(str));
    }

    @Test
    public void testCountWords002() {
        String str = "Toda$y is a^ very sunny& day. Sun$ny days? are very nice.";

        printMap(countWords(str));
    }
}
